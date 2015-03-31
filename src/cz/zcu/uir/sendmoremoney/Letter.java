/**
 * 
 */
package cz.zcu.uir.sendmoremoney;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jan Dvorak A13B0293P
 *
 */
public class Letter {
	private static final int DEFAULT_VALUE = 0;
	
	private final char letter;
	private int value = DEFAULT_VALUE;
	private final List<Integer> possibilities = Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
	
	public Letter(char letter) {
		this.letter = letter;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public char getLetter() {
		return letter;
	}
	
	public List<Integer> getPossibilities() {
		return possibilities;
	}

	public String toString(){
		return letter + "(" + value + ") ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + letter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (letter != other.letter)
			return false;
		return true;
	}
}
