package cz.zcu.uir.sendmoremoney;

public class Main {

	public static void main(String[] args) {		
		VerbalArithmetic va = new VerbalArithmetic("STAR+WARS=SPACE");
		System.out.println(va + "\n");
		
		VerbalArithmeticBacktrackingSolver vabs = new VerbalArithmeticBacktrackingSolver();
		
		int[] foundConfiguration = vabs.solveVerbalArithmetic(va);
		
		if(foundConfiguration != null){
			System.out.println("\n" + va.printConfigurationResult(foundConfiguration));
		}
	}

}
