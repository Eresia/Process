package script;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ScriptLexer;
import antlr.ScriptParser;
import exception.ErrorInVerificationException;

public class ScriptLaunch {
	
	private final ScriptExec script;
	private final FileWriter outFile;
	
	private final static String begin = "WIDTH=16;\nDEPTH=32;\n\nADDRESS_RADIX=UNS;\nDATA_RADIX=UNS;\n\nCONTENT BEGIN\n";
	private final static String end = "END;";
	
	public ScriptLaunch(String scriptFilePath, String outFilePath, int nbMaxInstruction) throws IOException, ErrorInVerificationException, RecognitionException{
		outFile = new FileWriter(new File(outFilePath));
		
		final ANTLRInputStream in = new ANTLRInputStream(new FileReader(scriptFilePath));
		final ScriptLexer lexer = new ScriptLexer(in);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final ScriptParser parser = new ScriptParser(tokens);
		
		ParseTree tree = parser.parse();
		
		ScriptVerify verify = new ScriptVerify(tree);
		verify.verify();
		
		script = new ScriptExec(tree, outFile, nbMaxInstruction);
	}
	
	public void start() throws IOException{
		outFile.write(begin);
		script.start();
		outFile.write(end);
		outFile.close();
	}

}
