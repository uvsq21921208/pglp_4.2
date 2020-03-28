package uvsq.pglp;

import java.util.Arrays;
import java.util.Stack;
/**
 * SaisieRPN class.
 */

public class SaisieRPn {
  /**
  * stack of operandes.
  */

  private Stack<Double> stack;
  /**
  * history of operandes(stack).
  */
  private Stack<Double> history;
  /**
  * moteur reference.
  */
  private MoteurRPn moteur;
  /**
  * public constructor.
  */

  public SaisieRPn() {
    stack = new Stack<Double>();
    history = new Stack<Double>();
    moteur = new MoteurRPn(stack, history);
  }
  /**
  * user interaction.
  */
  
  public void interectUserInput() {
    UserDisplay display = new Display();
    UserInput input = new Input();
    String message =
        "Entrez un operende, une operation ou bien tapez exit pour quitter";
    String currentExpression = "";
    display.showMessage(message);
    while (true) {
      String value = input.readValue();
      if (moteur.isOperator(value)) {
        double result;
        try {
          result = moteur.calcul(value);
          message = "Result " + result;
          currentExpression += " " + value;
          display.showMessage(
                "L'expression courante" + currentExpression);
          display.showMessage(message);
        } catch (MiniMumOperandNeeded e) {
          message = "You need atleast two operandes !";
          display.showMessage(message);
        } catch (DivisionByZero e) {
          message = "You cannot divide by zero !";
          display.showMessage(message);
          display.showMessage(
                Arrays.toString(moteur.getListOfOperandes()));
        }

      } else {
        if (value.equals("exit") || value.equals("undo")) {
          moteur.interprete(value);
          if (value.equals("undo")) {
            if (currentExpression.length() > 2) {
              currentExpression =
                currentExpression.substring(0,
                currentExpression.length() - 2);
              display.showMessage(
                    "L'expression courante" + currentExpression);
            } else {
              display.showMessage(
                  "L'expression courante: vide");
            }
          }
        } else {
          try {
            double a = Double.parseDouble(value);
            moteur.save(a);
            display.showMessage(
                 Arrays.toString(moteur.getListOfOperandes()));
            currentExpression += " " + value;
            display.showMessage(
                 "L'expression courante" + currentExpression);
          } catch (NumberFormatException e) {
            message =
              "Errer ! Entrez un operande, "
              + "une operation ou "
              + "exit pour exit ou undo ";
            display.showMessage(message);
          }
        }
      }
    }
  }
}
