package script;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import antlr.ScriptBaseVisitor;
import antlr.ScriptParser;
import exception.ErrorInVerificationException;

public class ScriptVerify extends ScriptBaseVisitor<Boolean>{

	private final ParseTree tree;
	private final ArrayList<Integer> variables;
	
	public ScriptVerify(ParseTree tree){
		this.tree = tree;
		this.variables = new ArrayList<Integer>();
	}
	
	public void verify() throws ErrorInVerificationException{
		Boolean result = visit(tree);
		if(result == null){
			throw new ErrorInVerificationException("Bad parse");
		}
		else if(result == false){
			throw new ErrorInVerificationException("Bad verification");
		}
	}
	
	@Override 
	public Boolean visitParse(ScriptParser.ParseContext ctx) { 
		return visit(ctx.getChild(0)); 
	}

	@Override 
	public Boolean visitBlock(ScriptParser.BlockContext ctx) { 
		Boolean result = true;
		for(int i = 0; i < ctx.getChildCount(); i++){
			result = (result && visit(ctx.getChild(i)));
		}
		return result;
	}

	@Override 
	public Boolean visitLine(ScriptParser.LineContext ctx) { 
		return visit(ctx.getChild(0)); 
	}
	
	@Override 
	public Boolean visitAssignVar(ScriptParser.AssignVarContext ctx) {
		Integer var = Integer.valueOf(ctx.getChild(0).getText().charAt(1));
		
		Integer variableIndex = 1;
		while(!ScriptParser.VOCABULARY.getSymbolicName(variableIndex).equals("Variable")){
			variableIndex++;
		}
		
		
		if(ctx.getChild(2).getClass().equals(TerminalNodeImpl.class)){
			String var2 = ctx.getChild(2).getText();
			if(!checkExpression(var2)){
				return false;
			}
		}
		else{
			Integer number = Integer.valueOf(ctx.getChild(2).getText());
			if(number > 65535){
				System.err.println("Number " + number + " too big");
				return false;
			}
		}
		
		if(!variables.contains(var)){
			variables.add(var);
		}
		return true;
	}


	@Override 
	public Boolean visitNotExpression(ScriptParser.NotExpressionContext ctx) { 
		String var = ctx.getChild(1).getText();
		return checkExpression(var);
	}


	@Override 
	public Boolean visitOperation(ScriptParser.OperationContext ctx) { 
		String var1 = ctx.getChild(0).getText();
		String var2 = ctx.getChild(2).getText();

		return (checkExpression(var1) && checkExpression(var2));
	}
	
	private Boolean checkExpression(String var){
		Integer varI = Integer.valueOf(var.charAt(1));
		if(!variables.contains(varI)){
			System.err.println("Variable " + var + " are not allocated");
			return false;
		}
		
		return true;
	}
}
