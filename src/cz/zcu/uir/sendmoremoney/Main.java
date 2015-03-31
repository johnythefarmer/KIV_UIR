package cz.zcu.uir.sendmoremoney;

public class Main {

	public static void main(String[] args) {		
		VerbalArithmetic va = new VerbalArithmetic("SEND+MORE=MONEY");
		System.out.println(va);
		System.out.println(va.fitting());
		System.out.println(va.isValid());
	}

}
