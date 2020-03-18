package uvsq2192128.pglp_4_2;

import java.util.Stack;

public class Interpreter {
   
	// this class has the two classes of quit and undo
	private Stack<Double> stack;
	public Interpreter(final Stack<Double> stackArg) {
		this.stack = stackArg;
	}
	
	
	private class Quit implements GenericCommand{
		
	}
    
	private class Undo implements GenericCommand{
		
	}

}
