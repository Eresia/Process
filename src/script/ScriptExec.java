package script;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import antlr.ScriptBaseVisitor;
import antlr.ScriptParser;

public class ScriptExec extends ScriptBaseVisitor<Integer>{
	
	private final ParseTree tree;
	private final FileWriter outFile;
	
	private int operationNumber;
	private int nbMaxInstruction;
	
	private final ArrayList<String> instructions;
	
	private final HashMap<String, Integer> gotos;
	private final HashMap<String, Integer> labels;
	
	public ScriptExec(ParseTree tree, FileWriter outFile, int nbMaxInstruction){
		this.tree = tree;
		this.outFile = outFile;
		this.nbMaxInstruction = nbMaxInstruction;
		
		gotos = new HashMap<String, Integer>();
		labels = new HashMap<String, Integer>();
		instructions = new ArrayList<String>();
	}
	
	public void start(){
		operationNumber = 0;
		visit(tree);
		for(String s : gotos.keySet()){
			String result = new String();
			Integer op = gotos.get(s);
			Integer target = labels.get(s);
			result += Operation.JUMP;
			result += fullBinaryNumber(Integer.toBinaryString(target), 5, true);
			result = fullBinaryNumber(result, 16, false);
			createAndPutInstruction(binaryToDecimalString(result), op);
		}
		for(String i : instructions){
			writeInstruction(i);
		}
		writeInstruction("\t[" + (operationNumber) + ".." + (nbMaxInstruction - 1) + "]\t:\t0;");
	}

	@Override 
	public Integer visitParse(ScriptParser.ParseContext ctx) { 
		visit(ctx.getChild(0)); 
		return null;
	}

	@Override 
	public Integer visitBlock(ScriptParser.BlockContext ctx) {
		for(int i = 0; i < ctx.getChildCount(); i++){
			visit(ctx.getChild(i));
		}
		return null;
	}

	@Override 
	public Integer visitLine(ScriptParser.LineContext ctx) { 
		visit(ctx.getChild(0));
		return null;
	}
	
	@Override 
	public Integer visitAssignVar(ScriptParser.AssignVarContext ctx) {
		Integer var = Integer.valueOf(new String() + ctx.getChild(0).getText().charAt(1));
		String varS = getBinaryRegister(var);
		
		Integer variableIndex = 1;
		while(!ScriptParser.VOCABULARY.getSymbolicName(variableIndex).equals("Variable")){
			variableIndex++;
		}
		
		if(ctx.getChild(2).getClass().equals(TerminalNodeImpl.class)){
			String result = new String();
			Integer var2 = Integer.valueOf(new String() + ctx.getChild(2).getText().charAt(1));
			String var2S = getBinaryRegister(var2);
			result += Operation.MV;
			result += var2S;
			result += varS;
			createInstruction(binaryToDecimalString(fullBinaryNumber(result, 16, false)));
		}
		else{
			String result = new String();
			String number = Integer.toBinaryString(visit(ctx.getChild(2)));
			number = binaryToDecimalString(number);
			result += Operation.MVI;
			result += varS;
			createInstruction(binaryToDecimalString(fullBinaryNumber(result, 16, false)));
			createInstruction(number);
		}
		
		return null;
	}


	@Override 
	public Integer visitNotExpression(ScriptParser.NotExpressionContext ctx) { 
		String result = new String();
		Integer var = Integer.valueOf(new String() + ctx.getChild(1).getText().charAt(1));
		String varS = getBinaryRegister(var);
		
		result += Operation.NOT;
		result += varS;
		result = fullBinaryNumber(result, 16, false);
		createInstruction(binaryToDecimalString(result));
		return null;
	}


	@Override 
	public Integer visitOperation(ScriptParser.OperationContext ctx) { 
		String result = new String();
		Integer var1 = Integer.parseInt(new String() + ctx.getChild(0).getText().charAt(1));
		Integer var2 = Integer.parseInt(new String() + ctx.getChild(2).getText().charAt(1));
		String var1S = getBinaryRegister(var1);
		String var2S = getBinaryRegister(var2);
		
		String op = new String();
		switch(ctx.getChild(1).getText().charAt(0)){
			case '+':
				op += Operation.ADD;
				break;
			case '-':
				op += Operation.SUB;
				break;
			case '&':
				op += Operation.AND;
				break;
			case '|':
				op += Operation.OR;
				break;
		}
		
		result += op;
		result += var1S;
		result += var2S;
		result = fullBinaryNumber(result, 16, false);
		
		createInstruction(binaryToDecimalString(result));
		
		return null;
	}
	
	@Override 
	public Integer visitHexaDisp(ScriptParser.HexaDispContext ctx) { 
		return Integer.parseInt(ctx.getText().substring(2), 16);
	}
	
	@Override 
	public Integer visitIntegerDisp(ScriptParser.IntegerDispContext ctx) { 
		return Integer.valueOf(ctx.getText());
	}
	
	@Override 
	public Integer visitGotoExpression(ScriptParser.GotoExpressionContext ctx) { 
		String l = ctx.getChild(1).getText();
		gotos.put(l, operationNumber);
		operationNumber++;
		return null;
	}


	@Override 
	public Integer visitLabelExpression(ScriptParser.LabelExpressionContext ctx) { 
		String l = ctx.getChild(1).getText();
		labels.put(l, operationNumber);
		return null;
	}
	
	private String binaryToDecimalString(String binary){
		return Integer.toString(Integer.parseInt(binary,2));
	}
	
	private String getBinaryRegister(int regist){
		return fullBinaryNumber(Integer.toBinaryString(regist), 3, true);
	}
	
	private String fullBinaryNumber(String number, Integer nb, boolean before){
		String result = String.copyValueOf(number.toCharArray());
		String zero = "0";
		while(result.length() < nb){
			if(before){
				result = zero + result;
			}
			else{
				result += zero;
			}
		}
		return result;
	}
	
	private void createInstruction(String instruction){
		instructions.add("\t" + operationNumber + "\t:\t" + instruction +";");
		operationNumber++;
	}
	
	private void createAndPutInstruction(String instruction, int position){
		instructions.add(position, "\t" + position + "\t:\t" + instruction +";");
	}
	
	private void writeInstruction(String instruction){
		try {
			outFile.write(instruction);
			outFile.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
