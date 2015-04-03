/**
 * 
 */
package cz.zcu.uir.sendmoremoney;


/**
 * @author Jan Dvorak A13B0293P
 *
 */
public class Letter {
	private static final int DEFAULT_INDEX = 0;
	
	private final char letter;
	private int index = DEFAULT_INDEX;
	private boolean isFirstLetter = false;

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

	public boolean isFirstLetter() {
		return isFirstLetter;
	}

	public void setFirstLetter(boolean isFirstLetter) {
		this.isFirstLetter = isFirstLetter;
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
