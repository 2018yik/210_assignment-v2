package Exercise5;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
	
		System.out.println("For your own test");
		System.out.println("----------------------------");
		Scanner input = new Scanner(System.in);
		System.out.println("Size of arrayqueue integer");
		int a = input.nextInt();
		ArrayQueue ar = new ArrayQueue(a);
		
		boolean checker = true;
		
		while (checker) {
			System.out.println("1 = insert data, 2= exit program");
			
			int b = input.nextInt();
			
			if (b == 1) {
				try {
				System.out.println("Input whatever u want");
				String c = input.next();
				ar.enqueue(c);
				} catch (Exception QueueFullException) {
					System.out.println("queue is full do second step");
					System.out.println("------------------");
					checker = false;
				}
				
			}  else {		
				checker = false;
			}
			
			
		}
		
		System.out.println(ar.toString());
		
		System.out.println("-------------------Start dequene-----------");
		while (!ar.empty()) {
	
			System.out.println("Dequeue:" + ar.dequeue());
			
			System.out.println(ar.toString());
		
		}
		
		
		
		
	}
	
	
}
