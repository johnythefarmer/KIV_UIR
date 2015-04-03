/**
 * 
 */
package cz.zcu.uir.sendmoremoney;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jan Dvorak A13B0293P
 *
 */
public class VerbalArithmetic {
	private static final String PARSE_EXCEPTION_MESSAGE = "This exception is not valid.";
	
	private final Map<Character, Letter> uniqueLetters;
	
	private Letter[] leftOperand;
	private Letter[] rightOperand;
	private Letter[] result;
	
	public VerbalArithmetic(String expression){
		uniqueLetters = new TreeMap<Character, Letter>();
		parseExpression(expression);
		initializeIndexes();
	}
	
	public Map<Character, Letter> getUniqueLetters() {
		return uniqueLetters;
	}

	private void initializeIndexes(){
		int i = 0;
		
		for(Letter l : uniqueLetters.values()){
			l.setIndex(i++);
		}
	}
	
	private void parseExpression(String expression){
		String[] split = expression.toUpperCase().split("=");
		
		if(split.length != 2){
			throw new IllegalArgumentException(PARSE_EXCEPTION_MESSAGE);
		}
		
		this.result = createOperand(split[1].trim());
		
		String[] operands = split[0].split("\\+");
		
		if(operands.length != 2){
			throw new IllegalArgumentException(PARSE_EXCEPTION_MESSAGE);
		}
		
		this.leftOperand = createOperand(operands[0].trim());
		this.rightOperand = createOperand(operands[1].trim());
	}
	
	private Letter[] createOperand(String operand){
		int n = operand.length();
		Letter[] letters = new Letter[n];
		
		char tmp;
		for(int i = 0; i < n; i++){
			tmp = operand.charAt(i);
			
			if(tmp == ' '){
				throw new IllegalArgumentException(PARSE_EXCEPTION_MESSAGE);
			}
			
			if(uniqueLetters.containsKey(tmp)){
				letters[i] = uniqueLetters.get(tmp);
			}else{
				Letter newLetter = new Letter(tmp);
				
				letters[i] = newLetter;
				uniqueLetters.put(tmp, newLetter);
			}
		}
		
		//first letter cant be zero
		letters[0].setFirstLetter(true);
		
		return letters;
	}
	
	private int valueOfOperand(Letter[] operand, int[] configuration){
		int sum = 0;
		
		int n = operand.length;
		for(int i = 0; i < n; i++){
			sum *= 10;
			sum += configuration[operand[i].getIndex()];
		}
		
		return sum;
	}
	
	public int fitting(int[] configuration){
		int leftOpValue = valueOfOperand(leftOperand, configuration);
		int rightOpValue = valueOfOperand(rightOperand, configuration);
		int resultValue = valueOfOperand(result, configuration);
		
//		System.out.println(leftOpValue + " + " + rightOpValue + " = " + resultValue);
		
		return leftOpValue + rightOpValue - resultValue;
	}
	
	public boolean isValid(int[] configuration){
		return fitting(configuration) == 0;
	}
	
	private String printLetters(Letter[] letters){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < letters.length; i++){
			sb.append(letters[i]);
		}
		
		return sb.toString();
	}
	
	public String printConfigurationResult(int[] configuration){
		int leftOpValue = valueOfOperand(leftOperand, configuration);
		int rightOpValue = valueOfOperand(rightOperand, configuration);
		int resultValue = valueOfOperand(result, configuration);
		
		return leftOpValue + "+" + rightOpValue + "=" + resultValue;
	}
	
	public String toString(){
		return printLetters(leftOperand) + "+" + printLetters(rightOperand)
				+ "=" + printLetters(result);
	}
}
