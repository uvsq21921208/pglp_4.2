package uvsq2192128.pglp_4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class MoteurRPN extends Interpreter{
    //this one has the classes of addition, substraction....
	
	private Stack<Double> stack;
	private Stack<Double> history;
	private Map<String, SpecificCommand> commands;
	public MoteurRPN(final Stack<Double> stackArg, final Stack<Double> historyArg) {
		
		super(stackArg,historyArg);
		commands = new HashMap<String, SpecificCommand>();
		commands.put("+", new Addition());
		commands.put("*", new Multiplication());
		commands.put("-", new Substraction());
		commands.put("/", new Division());

		stack = stackArg;
		history = historyArg;
	}
	
	public void save(double operand) {
		stack.push(operand);
	}
	public double[] getListOfOperandes() {
		double[] values = new double[stack.size()];
		int index = 0;
		for (double value : stack) {
			values[index++] = value;
		}
		return values;
	}
	public double calcul(String operation) throws MiniMumOperandNeeded, DivisionByZero {
		
		return this.eval(this.commands.get(operation));
	}
	
	
	private double eval(final SpecificCommand operation) throws MiniMumOperandNeeded, DivisionByZero {
		if (stack.size() >= 2) {
			double a =stack.pop();
			double b =stack.pop();
			history.push(a);
			history.push(b);
			stack.push(operation.apply(a,b));
			return stack.peek();
		} else {
			throw new MiniMumOperandNeeded();
		}
	}
	private class Substraction implements SpecificCommand{

		public Substraction() {
			// TODO Auto-generated constructor stub
		}

		public double apply(double a, double b) {
			return a - b;
			
		}

	}
	
	private class Addition implements SpecificCommand{

		public Addition() {
			// TODO Auto-generated constructor stub
		}

		public double apply(double a, double b) {
			return a + b;
			
		}

	}
	private class Multiplication implements SpecificCommand{

		public Multiplication() {
			// TODO Auto-generated constructor stub
		}

		public double apply(double a, double b) {
			return a * b;
			
		}

	}
	private class Division implements SpecificCommand{

		public Division() {
			// TODO Auto-generated constructor stub
		}

		public double apply(double a, double b) {
			if (b == 0)
				try {
					throw new DivisionByZero();
				} catch (DivisionByZero e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return a / b;
			
			
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
			return false;
		}

	}
	
}
