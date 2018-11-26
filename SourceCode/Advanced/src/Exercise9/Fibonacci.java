package Exercise9;

public class Fibonacci {

	
	public double FibonacciCount(int i) {
		double total = 1;
		if (i == 1 || i == 2) {
			return total;
			
		} else {
			for (int j = 3; j <= i; j++) {
				
				total = total + FibonacciCount(j-2);
			}
			return total;
		}
		}
	}

