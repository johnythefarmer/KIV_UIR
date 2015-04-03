/**
 * 
 */
package cz.zcu.uir.sendmoremoney;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Jan Dvorak A13B0293P
 *
 */
public class VerbalArithmeticBacktrackingSolver implements
		VerbalArithmeticSolver {

	private char[] letters;
	private int letterCount;
	private boolean[] usedLetters;
	private VerbalArithmetic va;
	
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
		this.va = va;
		initializeLetters(va.getUniqueLetters());
		this.letterCount = letters.length;
		this.usedLetters = new boolean[10];
		Arrays.fill(usedLetters, false);
		
		int[] configuration = new int[letterCount];
		
		boolean found = findRightConfiguration(configuration, 0);
		
		if(found){
			return configuration;
		} else {
			return null;
		}
		
	}
	
	private void initializeLetters(Map<Character, Letter> map){
		letters = new char[map.size()];
		
		int i = 0;
		for(Character c : map.keySet()){
			letters[i++] = c.charValue();
		}
	}
	
	private boolean findRightConfiguration(int[] configuration, int depth){
		if(depth == letterCount){
			if(va.isValid(configuration)){
				return true;
			} else {
				return false;
			}
		}
		
		Letter l = va.getUniqueLetters().get(letters[depth]);
		
		for(int i = 0; i < 10; i++){
			if(usedLetters[i] || (l.isFirstLetter() && i == 0)){
				continue;
			}
			configuration[depth] = i;
			usedLetters[i] = true;
			
			boolean found = findRightConfiguration(configuration, depth + 1);
			
			if(found){
				return true;
			} else {
				usedLetters[i] = false;
			}
		}
		
		return false;
	}

}
