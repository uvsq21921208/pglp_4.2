package uvsq.pglp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreter {
  /**
  * A map to map commands with their symbol.
  */
  private Map<String, GenericCommand> commands;
  /**
  * Public constructor.
  * @param stackArg stack of operandes.
  * @param historyArg history of operandes.
  */

  public Interpreter(final Stack<Double> stackArg,
              final Stack<Double> historyArg) {
    this.commands = new HashMap<String, GenericCommand>();
    this.commands.put("undo", new Undo(stackArg, historyArg));
    this.commands.put("exit", new Quit());

  }
  /**
  * Interprate the value.
  * @param value the value to interprate(exit/undo).
  */

  public void interprete(final String value) {

    GenericCommand command = this.commands.get(value);
    command.execute();

  }

  private class Quit implements GenericCommand {
    /**
    * execute method implementation.
    */
    public void execute() {
      Display display = new Display();
      display.showMessage("You are quiting!");
      System.exit(0);
    }

  }
  /**
  * Undo class.
  */

  private class Undo implements GenericCommand {
    /**
    * stack of operandes.
    */
    private Stack<Double> stack;
    /**
    * history of operandes.
    */
    private Stack<Double> history;
    /** Public consructor.
    * @param stackarg stack of operandes. 
    * @param historyarg stack of operandes.
    */

    Undo(final Stack<Double> stackarg, final Stack<Double> historyarg) {
      stack = stackarg;
      history = historyarg;
    }

    public void execute() {
      if (!stack.isEmpty()) {
        this.stack.pop();
        if (history.size() >= 2) {
          this.stack.push(this.history.pop());
          this.stack.push(this.history.pop());
        }
      }
    }

  }

}
