package uvsq.pglp;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import uvsq.pglp.DivisionByZero;
import uvsq.pglp.MiniMumOperandNeeded;
import uvsq.pglp.MoteurRPn;

public class MoteurRPNTest {
	private MoteurRPn moteur;
	private Stack<Double> stack;
	private Stack<Double> history;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setUp() {
		stack = new Stack<Double>();
		history = new Stack<Double>();
		moteur = new MoteurRPn(stack, history);
	}

	@Test
	// Operations tests
	public void isOperatorTest(){
		String operation = "+";
		assertTrue(moteur.isOperator(operation));
		operation = "-";
		assertTrue(moteur.isOperator(operation));
		operation = "/";
		assertTrue(moteur.isOperator(operation));
		operation = "*";
		assertTrue(moteur.isOperator(operation));
		operation = "azeazeaze+";
		assertFalse(moteur.isOperator(operation));
	}
	
	@Test 
	public void miniMumOperandNeededTest() throws MiniMumOperandNeeded, DivisionByZero {
		exceptionRule.expect(MiniMumOperandNeeded.class);
		moteur.calcul("+");
	}
	
	@Test
	public void calculTest() throws MiniMumOperandNeeded, DivisionByZero {
		double x = 5;
		double y = 7;
		moteur.save(x);
		moteur.save(y);
	}
	
	@Test
	public void calculTestDivisionByZeroExceptionTest() throws MiniMumOperandNeeded, DivisionByZero {
		double x = 5;
		double y = 0;
		moteur.save(x);
		moteur.save(y);
		exceptionRule.expect(DivisionByZero.class);
		moteur.calcul("/");
	}
	
    @Test 
    public void undoTest() throws MiniMumOperandNeeded, DivisionByZero {
    	double x = 5;
		double y = 2;
		
		moteur.save(x);
		moteur.save(y);
		moteur.calcul("*");
		moteur.interprete("undo");
		double [] operandes = moteur.getListOfOperandes();
		double [] expectedOperandes = {5,2};
	    assertEquals(Arrays.toString(operandes), Arrays.toString(expectedOperandes));
    }
    
    @Test  
    public void undoEmpty() {
    	// Trying to make undo in an empty stack produces no error.
    	double [] a = {};
    	assertEquals(Arrays.toString(moteur.getListOfOperandes()), Arrays.toString(a));
    	moteur.interprete("undo");
    }
}
