package uvsq.pglp;

/**
 *SpecifiCommand interface.
 */

public interface SpecificCommand extends Command {

  /** Apply.
  * @param a first operande.
  * @param b second operande.7
  * @return result of calculations.
  * @throws DivisionByZero division exception.
   */
  double apply(double a, double b) throws DivisionByZero;
}
