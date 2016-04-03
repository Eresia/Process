package script;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import antlr.ScriptBaseVisitor;
import antlr.ScriptParser;
import exception.ErrorInVerificationException;

public class ScriptVerify extends ScriptBaseVisitor<Boolean>{

	private final ParseTree tree;
	private final ArrayList<Integer> variables;
	private final ArrayList<String> gotos;
	private final ArrayList<String> labels;
	
	public ScriptVerify(ParseTree tree){
		this.tree = tree;
		this.variables = new ArrayList<Integer>();
		gotos = new ArrayList<String>();
		labels = new ArrayList<String>();
	}
	
	public void verify() throws ErrorInVerificationException{
		Boolean result = visit(tree);
		if(result == null){
			throw new ErrorInVerificationException("Bad parse");
		}
		
		if(result){
			for(String s : gotos){
				if(!labels.contains(s)){
					System.err.println("Label " + s + " don't exist");
					result = false;
				}
			}
		}
		
		if(result == false){
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
			if(!visit(ctx.getChild(2))){
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
	
	@Override 
	public Boolean visitHexaDisp(ScriptParser.HexaDispContext ctx) { 
		String numberS = ctx.getText().substring(2);
		try{
			Integer number = Integer.parseInt(numberS, 16);
			if(number > 65535){
				System.err.println("Number " + numberS + " too big");
				return false;
			}
		} catch(NumberFormatException e){
			System.err.println("Number " + numberS + " too big");
			return false;
		}
		return true;
	}
	
	@Override 
	public Boolean visitIntegerDisp(ScriptParser.IntegerDispContext ctx) { 
		String numberS = ctx.getText();
		try{
			Integer number = Integer.parseInt(numberS);
			if(number > 65535){
				System.err.println("Number " + numberS + " too big");
				return false;
			}
		} catch(NumberFormatException e){
			System.err.println("Number " + numberS + " too big");
			return false;
		}
		return true;
	}
	
	@Override 
	public Boolean visitGotoExpression(ScriptParser.GotoExpressionContext ctx) { 
		String g = ctx.getChild(1).getText();
		if(!gotos.contains(g)){
			gotos.add(g);
		}
		return true;
	}


	@Override 
	public Boolean visitLabelExpression(ScriptParser.LabelExpressionContext ctx) { 
		String l = ctx.getChild(1).getText();
		if(labels.contains(l)){
			System.err.println("Label " + l + " already defined");
			return false;
		}
		else{
			labels.add(l);
		}
		return true;
	}
	
	@Override 
	public Boolean visitErrorNode(ErrorNode node) { 
		System.err.println("Error in parsage");
		return false;
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
