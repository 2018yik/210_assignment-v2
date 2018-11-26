package Exercise2;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Fibonacci fa = new Fibonacci();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("F(x) to F(y) x = ?");
		String x1 = sc.nextLine();
		
		System.out.println("F(x) to F(y) y = ?");
		String y1 = sc.nextLine();
		
		if (checkernumber(x1) && checkernumber(y1)) {
			int x = Integer.parseInt(x1);
			int y = Integer.parseInt(y1);
			
			if (x > y || x <0 || y < 0 ) {
			System.out.println("Wrong input, x and y should be positive and x > y");
		} else {
			System.out.println("F"+ x + " To " + "F" + y);
			String text = "";
			
		for (int i = x; i <= y; i++) {
				text = text + fa.FibonacciCount(i) + ",";
		}
		System.out.println(text.substring(0,text.length()-1));
		}
		
		} else {
			System.out.println("Input type should be integer");
		
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
