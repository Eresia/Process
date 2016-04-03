package test;

import java.io.IOException;

import exception.ErrorInVerificationException;
import script.ScriptLaunch;

public class Main {

	public static void main(String[] args) {
		try {
			ScriptLaunch launch = new ScriptLaunch("script.txt", "success.txt", 32);
			launch.start();
		} catch (IOException | ErrorInVerificationException e) {
			System.err.println(e.getMessage());
		}
	}

}
