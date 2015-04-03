/**
 * 
 */
package cz.zcu.uir.sendmoremoney;

/**
 * @author Jan Dvorak A13B0293P
 * Interface representing abstract verbal arithmetic solver
 */
public interface VerbalArithmeticSolver {
	
	/**
	 * Method which solves VerbalArithmetic problem by implemented algorithm
	 * @param expression verbal arithmetic expression
	 * @return solved arangment of values for given expression
	 */
	int[] solveVerbalArithmetic(String expression);
}
