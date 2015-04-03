package cz.zcu.uir.sendmoremoney;

public class Main {

	public static void main(String[] args) {		
		VerbalArithmetic va = new VerbalArithmetic("SEND+MORE=MONEY");
		System.out.println(va);
		System.out.println(va.isValid(new int[]{7,5,1,6,0,8,9,2}));
		System.out.println(va.getUniqueLetters());
	}

}
