package script;

import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.ScriptBaseVisitor;
import antlr.ScriptParser;

public class ScriptExec extends ScriptBaseVisitor<Integer>{
	
	private final ParseTree tree;
	private final FileWriter outFile;
	
	private int operationNumber;
	private int nbMaxInstruction;
	
	public ScriptExec(ParseTree tree, FileWriter outFile, int nbMaxInstruction){
		this.tree = tree;
		this.outFile = outFile;
		this.nbMaxInstruction = nbMaxInstruction;
	}
	
	public void start() throws IOException{
		operationNumber = 0;
		visit(tree);
		outFile.write("\t[" + (operationNumber) + ".." + (nbMaxInstruction - 1) + "]\t:\t0;\n");
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
		TerminalNode node = (TerminalNode) ctx.getChild(2);
		
		if(node.getSymbol().getType() == variableIndex){
			String result = new String();
			Integer var2 = Integer.valueOf(new String() + ctx.getChild(2).getText().charAt(1));
			String var2S = getBinaryRegister(var2);
			result += Operation.MV;
			result += var2S;
			result += varS;
			writeInstruction(binaryToDecimalString(fullBinaryNumber(result, 16, false)));
		}
		else{
			String result = new String();
			String number = Integer.toBinaryString(Integer.valueOf(ctx.getChild(2).getText()));
			number = binaryToDecimalString(number);
			result += Operation.MVI;
			result += varS;
			writeInstruction(binaryToDecimalString(fullBinaryNumber(result, 16, false)));
			writeInstruction(number);
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
		writeInstruction(binaryToDecimalString(result));
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
		
		writeInstruction(binaryToDecimalString(result));
		
		return null;
	}
	
	@Override 
	public Integer visitHexaDisp(ScriptParser.HexaDispContext ctx) { 
		return Integer.parseInt(ctx.getChild(1).getText(), 16);
	}
	
	@Override 
	public Integer visitIntegerDisp(ScriptParser.IntegerDispContext ctx) { 
		return Integer.valueOf(ctx.getText());
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
	
	private void writeInstruction(String instruction){
		try {
			outFile.write("\t" + operationNumber + "\t:\t" + instruction +";");
			outFile.write("\n");
			operationNumber++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
