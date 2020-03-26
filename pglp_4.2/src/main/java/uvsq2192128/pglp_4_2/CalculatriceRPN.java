package uvsq2192128.pglp_4_2;


public enum CalculatriceRPN {
	MAINPROGRAM;

	public void execute() throws OperationException, MiniMumOperandNeeded, DivisionByZero {
		SaisieRPN saisieInterection = new SaisieRPN();

		saisieInterection.interectUserInput();
	
	}

	public static void main(String[] args){

		try {
			CalculatriceRPN.MAINPROGRAM.execute();
		} catch (OperationException | MiniMumOperandNeeded | DivisionByZero e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}