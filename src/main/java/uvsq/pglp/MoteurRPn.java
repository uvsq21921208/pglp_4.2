package uvsq.pglp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;
/**
* MoteurRPN class.
*/

public class MoteurRPn extends Interpreter {
  /**
  * stack of operandes.
  */
  private static Stack<Double> stack;
  /**
  * history of operandes (stack).
  */
  private Stack<Double> history;
  /**
   * setter to initilialize stack.
   * @param stackArg stack of operandes.
   */

  private synchronized void setStack(final Stack<Double> stackArg) {
    stack = stackArg;
  }
  /**
  * map a specific command with its string representation.
  */
  
  private Map<String, SpecificCommand> commands;
  /**
  * Public constructor.
  * @param stackArg stack of operandes.
  * @param historyArg history of operandes (stack).
  */

  public MoteurRPn(final Stack<Double> stackArg,
      final Stack<Double> historyArg) {
    super(stackArg, historyArg);
    setStack(stackArg);
    history = historyArg;
    commands = new HashMap<String, SpecificCommand>();
    commands.put("+", new Addition());
    commands.put("*", new Multiplication());
    commands.put("-", new Substraction());
    commands.put("/", new Division(stack));
 
  }
  /**
  * method to save an operande.
  * @param operand operand.
  */

  public void save(final double operand) {
    stack.push(operand);
  }
  /**
  * List of operandes.
  * @return list of operandes.
  */

  public double[] getListOfOperandes() {
    double[] values = new double[stack.size()];
    int index = 0;
    for (double value : stack) {
      values[index++] = value;
    }
    return values;
  }
  /**
    * Calcul the results of operation.
    * @param operation operation operation to be executed.
    * @return results of calculations.
    * @throws MiniMumOperandNeeded if less than two operandes are in the stack.
    * @throws DivisionByZero if you try to divide by zero.
    */

  public double calcul(final String operation)
      throws MiniMumOperandNeeded, DivisionByZero {
    return this.eval(this.commands.get(operation));
  }
  /**
  * Evaluate.
  * @param operation operation to be executed.
  * @return results of calculations.
  * @throws MiniMumOperandNeeded if less than two operandes are in the stack.
  * @throws DivisionByZero if you try to divide by zero.
  */

  private double eval(final SpecificCommand operation)
      throws MiniMumOperandNeeded, DivisionByZero {
    if (stack.size() >= 2) {
      double a = stack.pop();
      double b = stack.pop();
      history.push(a);
      history.push(b);
      stack.push(operation.apply(a, b));
      return stack.peek();
    } else {
      throw new MiniMumOperandNeeded();
    }
  }
  /**
  * Substraction class.
  */
    
  private static class Substraction implements SpecificCommand {
    Substraction() { }

    /** Apply.
    * @param a first operande.
    * @param b second operande.
    * @return result of calculations.
    */
    public double apply(final double a, final double b) {
      return a - b;
    }

  }
  /**
  * Addition class.
  */

  private static class Addition implements SpecificCommand {

    Addition() { }
    /**
    * Apply.
    * @param a first operande.
    * @param b second operande.
    * @return result of calculations.
    */

    public double apply(final double a, final double b) {
      return a + b;
    }

  }
  /**
  * Multiplication class.
  */

  private static class Multiplication implements SpecificCommand {

    Multiplication() { }
    /** Apply.
    * @param a first operande.
    * @param b second operande.
    * @return result of calculations.
    */

    public double apply(final double a, final double b) {
      return a * b;
    }
  }

  private static class Division implements SpecificCommand {
    /**
    * Public constructor.
    * @param stackarg stack reference.
    */
    Division(final Stack<Double> stackarg) { }
    /** Apply.
    * @param a first operande.
    * @param b second operande.
    * @return result of calculations.
    * @throws DivisionByZero division by zero exception.
    */

    public double apply(final double a, final double b)
        throws DivisionByZero {
      if (a != 0) {
        return  b / a;
      } else {
        stack.push(b);
        stack.push(a);
        throw new DivisionByZero();
      }

    }

  }
  /**
  * Check if it's an operator or not.
  * @param symbol = Operation symbol
  * @return True if the given symbol is a an operation symbol.
  */

  public boolean isOperator(final String symbol) {

    boolean isOperation =
        Pattern.compile("[+-/*]").matcher(symbol).matches();
    if (isOperation) {
      return isOperation;
    } else {
      return false;
    }
  }

}
