package uvsq2192128.pglp_4_2;

import java.util.Stack;

public class MoteurRPN {
    //this one has the classes of addition, substraction....
	
	private Stack<Double> stack;
	public MoteurRPN(final Stack<Double> stackArg) {
		stack = stackArg;
	}
	
	
	public void calcul(String operation) {

		SpecificCommand op;
		
		switch (operation) {
		case "+":
			op = new Addition();
		case "*":
			op = new Addition();
		case "/":
			op = new Addition();
		case "-":
		   op = new Substraction();
		}
	}
	
	private class Substraction implements SpecificCommand{

		public Substraction() {
			// TODO Auto-generated constructor stub
		}

		public double apply(int a, int b) {
			return a - b;
			
		}

	}
	
	private class Addition implements SpecificCommand{

		public Addition() {
			// TODO Auto-generated constructor stub
		}

		public double apply(int a, int b) {
			return a + b;
			
		}

	}
	private class Multiplication implements SpecificCommand{

		public Multiplication() {
			// TODO Auto-generated constructor stub
		}

		public double apply(int a, int b) {
			return a * b;
			
		}

	}
	private class Division implements SpecificCommand{

		public Division() {
			// TODO Auto-generated constructor stub
		}

		public double apply(int a, int b) {
			return a/b;
			
			
		}

	}
}
