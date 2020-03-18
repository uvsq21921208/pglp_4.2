package uvsq2192128.pglp_4_2;


public enum CalculatriceRPN {
	MAINPROGRAM;

	public void execute() throws OperationException, MiniMumOperandNeeded {
		SaisieRPN saisieInterection = new SaisieRPN();

		saisieInterection.interectUserInput();
	
	}

	public static void main(String[] args) throws OperationException, MiniMumOperandNeeded {

		CalculatriceRPN.MAINPROGRAM.execute();
	}

}