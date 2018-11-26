package Exercise1;
import java.util.*;



public class Main {

	
		public static void main(String[] args) {
			
			factorial f = new factorial();
			
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter m");
			String data1 = input.nextLine();
			
			System.out.println("Enter n");
			String data2 = input.nextLine();
			
			if (checkernumber(data1) && checkernumber(data2)) {
			int m = Integer.parseInt(data1);
			int n = Integer.parseInt(data2);
			
			if (m <0 || n <0) {
				System.out.println("can not be negative");
				
			} else if (m > 231 || n > 231){
				System.out.println("can not larger than 231");
			
			} else {
				double c = f.factorialCount(n);
				if (c % m == 0) {
					System.out.println("m is " + m);
					System.out.println("n is " + n);
					System.out.println("n! is " + c);
					System.out.println("n!/m is " + c/m);
					System.out.println("is integer");
					
				} else {
					System.out.println("m is " + m);
					System.out.println("n is " + n);
					System.out.println("n! is " + c);
					System.out.println("n!/m is " + c/m);
					System.out.println("Not integer");
					
				}
			}
			} else {
				System.out.println("Input data should be Integer");
				
			}			
}
		public static boolean checkernumber(String a) {
			boolean checker = true;
			try {
				int num = Integer.parseInt(a);
			} catch (NumberFormatException ex){
				checker = false;			
		}
			return checker;
			}
}
