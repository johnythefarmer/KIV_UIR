package cz.zcu.uir.sendmoremoney;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {		
		VerbalArithmetic va = new VerbalArithmetic("heart+math=rhyme");
		int[] correctConf = new int[]{7,5,1,6,0,8,9,2};
		System.out.println(va);
		System.out.println(va.isValid(correctConf));
		
		VerbalArithmeticBacktrackingSolver vabs = new VerbalArithmeticBacktrackingSolver();
		
		int[] foundConfiguration = vabs.solveVerbalArithmetic(va);
		System.out.println(va.isValid(foundConfiguration));
		System.out.println(Arrays.toString(foundConfiguration));
	}

}
