/**
 * 
 */
package cz.zcu.uir.sendmoremoney;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jan Dvorak A13B0293P
 *
 */
public class Letter {
	private static final int DEFAULT_INDEX = 0;
	
	private final char letter;
	private int index = DEFAULT_INDEX;
	private final Set<Integer> possibilities = new HashSet<Integer>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
	
	public Letter(char letter) {
		this.letter = letter;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public char getLetter() {
		return letter;
	}
	
	public Set<Integer> getPossibilities() {
		return possibilities;
	}

	public String toString(){
		return letter + "(" + index + ") ";
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
