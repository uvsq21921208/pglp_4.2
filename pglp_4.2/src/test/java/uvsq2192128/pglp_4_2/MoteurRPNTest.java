package uvsq2192128.pglp_4_2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoteurRPNTest {
	private MoteurRPN moteur;
	private Stack<Double> stack;
	private Stack<Double> history;
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before

	public void setUp() {
		stack = new Stack<Double>();
		history = new Stack<Double>();
		moteur = new MoteurRPN(stack, history);
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
	
	

	}
	@Test
	public void calculTest() throws MiniMumOperandNeeded, DivisionByZero {
		double x = 5;
		double y = 7;
		moteur.save(x);
		moteur.save(y);
		
		assertEquals(moteur.calcul("+"), 12, 0);
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
    public void undoExitTest() throws MiniMumOperandNeeded, DivisionByZero {
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
}
