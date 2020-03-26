package uvsq2192128.pglp_4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreter {
   
	// this class has the two classes of quit and undo
	private Map<String, GenericCommand> commands;
	public Interpreter(final Stack<Double> stackArg, final Stack<Double> historyArg) {
		this.commands = new HashMap<String, GenericCommand>();
		this.commands.put("undo", new Undo(stackArg, historyArg));
		this.commands.put("exit", new Quit());

	}
	
	public void interprete(String value) {
		GenericCommand command = this.commands.get(value);
        command.execute();
		
	}
	private class Quit implements GenericCommand{

		@Override
		public void execute() {
			Display display = new Display();
			display.showMessage("You are quiting!");
			System.exit(0);
			
		}
		
	}
    
	private class Undo implements GenericCommand{
		private Stack<Double> stack;
		private Stack<Double> history;
        public Undo(Stack<Double> stackarg, Stack<Double> historyarg){
        	stack = stackarg;
        	history = historyarg;
        }
		@Override
		public void execute() {
			
			if (!stack.isEmpty()) {
				this.stack.pop();
				if(history.size()>= 2) {
				this.stack.push(this.history.pop());
				this.stack.push(this.history.pop());
				}
			}
			}
			
		
	}

}
