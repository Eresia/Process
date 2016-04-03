package test;

import java.io.IOException;

import org.antlr.v4.runtime.RecognitionException;

import exception.ErrorInVerificationException;
import script.ScriptLaunch;

public class Main {

	public static void main(String[] args) {
		String scriptFileName = "script.txt";
		String outFileName = "inst_mem.mif";
		int nbWords = 32;
		if(args.length >= 1){
			scriptFileName = args[1];
			if(args.length >= 2){
				outFileName = args[2];
				if(args.length >= 3){
					nbWords = Integer.parseInt(args[3]);
				}
			}
		}
		
		try {
			ScriptLaunch launch = new ScriptLaunch(scriptFileName, outFileName, nbWords);
			launch.start();
		} catch (IOException | ErrorInVerificationException e) {
			System.err.println(e.getMessage());
		} catch(RecognitionException e){
			System.err.println("Error in parsage");
		}
	}

}
