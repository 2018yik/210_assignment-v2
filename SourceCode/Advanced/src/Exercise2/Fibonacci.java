package Exercise2;

public class Fibonacci {

	
	public double FibonacciCount(int i) {
			
		double result = 1;
		double oldresultdiff = 0;
		if (i == 1 || i == 2) {
			return 1;
		} else {
		
			for (int a = 2; a <= i; a++) {
				result = result + oldresultdiff;
				oldresultdiff = result - oldresultdiff;	
			}
			return result;
		}
		
	}
	
}

