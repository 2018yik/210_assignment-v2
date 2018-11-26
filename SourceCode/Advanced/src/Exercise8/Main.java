package Exercise8;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		RecursiveBinarySearch a = new RecursiveBinarySearch();
		
		int[] testing = {1,2,3,4,5,6,7,8,9,10,123,115161617,737373737};
		
		System.out.println("int array is : {1,2,3,4,5,6,7,8,9,10,123,115161617,737373737} , Input index = 115161617"  );
		
		System.out.println(a.RecursiveBinarySearch1(115161617, testing, 0, testing.length-1));
		
		a.initlizeSearch();
		
		testing = new int[]{5,7,11,13,26,37,88,99,111};
		
		System.out.println("int array is : {5,7,11,13,26,37,88,99,111} , Input index = 111"  );
		
		System.out.println(a.RecursiveBinarySearch1(111, testing, 0, testing.length-1));
		
		
		
		System.out.println("-----------------------");
		System.out.println("For Your Own Test");
		
		boolean firststep = false; // checker first input;
		
		ArrayList<Integer> ai = new ArrayList<Integer>();
		
		Scanner input = new Scanner(System.in);
		
		while(firststep == false) {
			System.out.println("1:Add integer to int array , 2:End");
				String checker = input.nextLine();
			if (checker.equals("2")) {
				firststep = true;
				System.out.println("Program Exit");
			} else if (checker.equals("1")) {
				System.out.println("Number?");
				String result = input.nextLine();
				if (checkernumber(result)) {
					ai.add(Integer.parseInt(result));
				} else {
					System.out.println("Can not be string type");
				}
			}
		
	}
			System.out.println("non sorted :"+ listtostring(ai));
			Collections.sort(ai);
			System.out.println("sorted :"+  listtostring(ai));
		
			int[] finalarray = arraylisttoint(ai);
			
			System.out.println("Which number u want to search");
			
			int number = input.nextInt();
			a.initlizeSearch();
			System.out.println(a.RecursiveBinarySearch1(number, finalarray, 0, finalarray.length-1));
		
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
	
	public static String listtostring(ArrayList a) {
		String text = "[";
		for (int i =0; i < a.size();i ++) {
			text = text + a.get(i) + " ";
		}
		text = text + "]";
		return text;
	}
	
		public static int[] arraylisttoint(ArrayList a) {
			int[] result = new int[a.size()];
			for (int i =0; i < a.size(); i++) {
			result[i] = (int) a.get(i);
			}
			return result;
			}
	}
	
