package uvsq2192128.pglp_4_2;

import java.util.Stack;
import java.util.regex.Pattern;

public class SaisieRPN {
    //here we create the stack and we send a reference to both classes of interpreter and
	// moteurrpn
	
	
	private Stack<Double> stack;
	private MoteurRPN moteur;
	private Interpreter interpreter; 
	public SaisieRPN() {
	    stack = new Stack<Double>();
	    moteur = new MoteurRPN(stack);
	    interpreter = new Interpreter(stack);
	}
   
	
	public void interectUserInput() throws OperationException {
		UserDisplay display = new Display();
		UserInput input = new Input();
		String message = "Entrez un operende, une operation ou bien tapez exit pour quitter";
		display.showMessage(message);
		String value = input.readValue();
        if (isOperator(value)) {
        	moteur.calcul(value);
        }
	}



	// Check if a given string is an operator or not
	/**
	 * 
	 * @param symbol = Operation symbol
	 * @return True if the given symbol is a an operation symbol.
	 * @throws OperationException when the given symbol is not a an operation
	 *                            symbol.
	 */
	public boolean isOperator(String symbol) throws OperationException {

		boolean isOperation = Pattern.compile("[+-/*]").matcher(symbol).matches();
		if (isOperation) {
			return isOperation;
		} else {
			throw new OperationException();
		}

	}
	
}
