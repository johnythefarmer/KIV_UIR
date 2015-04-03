/**
 * 
 */
package cz.zcu.uir.sendmoremoney;

/**
 * @author Jan Dvorak A13B0293P
 *
 */
public class VerbalArithmeticBacktrackingSolver implements
		VerbalArithmeticSolver {

	/* (non-Javadoc)
	 * @see cz.zcu.uir.sendmoremoney.VerbalArithmeticSolver#solveVerbalArithmetic(java.lang.String)
	 */
	@Override
	public int[] solveVerbalArithmetic(String expression) {
		VerbalArithmetic va = new VerbalArithmetic(expression);
		
		return solveVerbalArithmetic(va);
	}

	@Override
	public int[] solveVerbalArithmetic(VerbalArithmetic va) {
		// TODO Auto-generated method stub
		return null;
	}

}
