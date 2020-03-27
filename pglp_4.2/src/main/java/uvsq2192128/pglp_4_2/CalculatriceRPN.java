package uvsq2192128.pglp_4_2;


public enum CalculatriceRPN {
	MAINPROGRAM;

	public void execute()  {
		SaisieRPN saisieInterection = new SaisieRPN();

		saisieInterection.interectUserInput();
	
	}

	public static void main(String[] args){

        CalculatriceRPN.MAINPROGRAM.execute();
		
	}

}