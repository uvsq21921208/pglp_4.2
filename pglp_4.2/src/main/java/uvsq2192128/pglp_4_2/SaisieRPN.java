package uvsq2192128.pglp_4_2;

import java.util.Stack;

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
   
	
	public void interectUserInput() throws OperationException, MiniMumOperandNeeded {
		UserDisplay display = new Display();
		UserInput input = new Input();
		String message = "Entrez un operende, une operation ou bien tapez exit pour quitter";
		String currentExpression = "";
		display.showMessage(message);
		while(true) {
		String value = input.readValue();
        if (moteur.isOperator(value)) {
        	
        	currentExpression += " "+value;
			display.showMessage("L'expression courante"+currentExpression);
        	double result = moteur.calcul(value);
        	message = "Result " + result;
        	display.showMessage(message);
             
        }else {
        	if(value.equals("exit") || value.equals("undo")) {
        		
        		moteur.interprete(value);
        	}else {
        		try{
        			double a = Double.parseDouble(value);
        			moteur.save(a);
        			currentExpression += " "+value;
        			display.showMessage("L'expression courante"+currentExpression);
        		} catch(NumberFormatException e)
        		{
        			message = "Errer ! Entrez un operande, une operation ou exit pour exit ou undo ";
        			display.showMessage(message);
        		}
        	}
        }
		}
	}

	
}
