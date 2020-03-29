package uvsq.pglp;

public enum CalculatriceRpn {
       /**
        * Main program enumaration.
        */
       MAINPROGRAM;
  /**
  * execute method implementation.
  */
  public void execute()  {
    SaisieRPn saisieInterection = new SaisieRPn();
    saisieInterection.interectUserInput();
  }
  /**
  * Main program.  
  * @param args main program args (consol mode).
  */

  public static void main(final String[] args) {

    CalculatriceRpn.MAINPROGRAM.execute();
  }

}
