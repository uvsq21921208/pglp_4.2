package uvsq.pglp;

import java.util.Scanner;

public class Input implements UserInput {
  /** Reads input from user.
  *@return user input.
  */
  public String readValue() {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    sc.close();
    return s.replace("\n", "").replace("\r", "");
  }

}
