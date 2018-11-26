package Exercise1;

public class factorial {

	public double factorialCount(int i) {
		double total = 1;
		if (i == 0 || i == 1) {
			return total;
		} else if (i > 1) {
			for (int j = 1; j <= i; j++) {
				total = total * j;
			}
			return total;
		} else {
			return -1;		
		}	
	}
}
