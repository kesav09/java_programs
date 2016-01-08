package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteCommandLine {
	public static void main(String[] args) throws IOException, InterruptedException{
		Process process = Runtime.getRuntime().exec("ls -lrt");
		Thread.sleep(100);
		System.out.println(process.exitValue());
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
		  sb.append(line).append("\n");
		}
		String answer = sb.toString();
	    System.out.println(answer);
	}
}
