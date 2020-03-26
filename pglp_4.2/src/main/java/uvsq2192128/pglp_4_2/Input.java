package uvsq2192128.pglp_4_2;

import java.util.Scanner;

public class Input implements UserInput {

	public String readValue() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    String s = sc.nextLine();
	 
	    return s.replace("\n", "").replace("\r", "");
	}
	
}
