package uvsq2192128.pglp_4_2;

import java.util.Stack;

public class Interpreter {
   
	// this class has the two classes of quit and undo
	private Stack<Double> stack;
	public Interpreter(final Stack<Double> stackArg) {
		this.stack = stackArg;
	}
	
	public void interprete(String value) {
		GenericCommand command;
		switch(value) {
		case "exit":
			command = new Quit();
		case "undo":
			command = new Undo();
			
		command.execute();
			
		}
	}
	private class Quit implements GenericCommand{

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
		
	}
    
	private class Undo implements GenericCommand{

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
