package Exercise11;

public class Main {
		
	
	
	public static void main(String[] args) {
		
		int[] ar = {89,83,39,33,12,6,36,18,23};
		int[] ar1 = {89,83,39,33,12,6,36,18,23};
		
		
		
		
		bubblesort bs = new bubblesort(ar);
		
		bs.asc();
		
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		bs = new bubblesort(ar1); // initlized
		
		bs.desc();
		
		
	}
}
