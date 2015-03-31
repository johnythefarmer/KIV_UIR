package cz.zcu.uir.sendmoremoney;

public class Main {

	public static void main(String[] args) {
		Letter[] tmp = new Letter[4];
		
		Letter l;
		for(int i = 0; i < 4; i++){
			l = new Letter((char)('A' + i));
			l.setValue(4 - i);
			
			tmp[i] = l;
		}
		
		VerbalArithmetic va = new VerbalArithmetic("SEND+MORE=MONEY");
		System.out.println(va);
		System.out.println(va.fitting());

	}

}
