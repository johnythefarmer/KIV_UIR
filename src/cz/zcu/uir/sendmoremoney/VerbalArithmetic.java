/**
 * 
 */
package cz.zcu.uir.sendmoremoney;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jan Dvorak A13B0293P
 *
 */
public class VerbalArithmetic {
	private final Map<Character, Letter> uniqueLetters = new HashMap<Character, Letter>();
	
	private Letter[] leftOperand;
	private Letter[] rightOperand;
	private Letter[] result;
	
	public VerbalArithmetic(String expression){
		parseExpression(expression);
	}
	
	private void parseExpression(String expression){
		String[] split = expression.toUpperCase().split("=");
		
		if(split.length != 2){
			throw new IllegalArgumentException("Not valid expression");
		}
		
		this.result = createOperand(split[1].trim());
		
		String[] operands = split[0].split("\\+");
		
		this.leftOperand = createOperand(operands[0].trim());
		this.rightOperand = createOperand(operands[1].trim());
	}
	
	private Letter[] createOperand(String operand){
		int n = operand.length();
		Letter[] letters = new Letter[n];
		
		char tmp;
		for(int i = 0; i < n; i++){
			tmp = operand.charAt(i);
			
			if(uniqueLetters.containsKey(tmp)){
				letters[i] = uniqueLetters.get(tmp);
			}else{
				Letter newLetter = new Letter(tmp);
				
				letters[i] = newLetter;
				uniqueLetters.put(tmp, newLetter);
			}
		}
		
		return letters;
	}
	
	private int valueOfOperand(Letter[] operand){
		int sum = 0;
		
		int n = operand.length;
		for(int i = 0; i < n; i++){
			sum *= 10;
			sum += operand[i].getValue();
		}
		
		return sum;
	}
	
	public int fitting(){
		return valueOfOperand(leftOperand) + valueOfOperand(rightOperand)
				- valueOfOperand(result);
	}
	
	private String printLetters(Letter[] letters){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < letters.length; i++){
			sb.append(letters[i]);
		}
		
		return sb.toString();
	}
	
	public String toString(){
		return printLetters(leftOperand) + "\t+ \t" + printLetters(rightOperand)
				+ "\t= \t" + printLetters(result);
	}
}
