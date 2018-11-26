package Exercise4;

public class Main {

	public static void main(String[] args) {
		
		CircularLinkedList a = new CircularLinkedList();
		LinkedList b = new LinkedList();
		
		String[] test = {"Test","LinkedLIst","is","Circular","or","not"};
		for (int i = 0; i < test.length; i++) {
			System.out.println("Add to Tail:" + test[i]);
			a.addToTail(test[i]);
			b.addToTail(test[i]);
			
			System.out.println(a);
			System.out.println(b);
			System.out.println("------------------------");
		}
		
		System.out.println("Add to Head:" + "HI");
		a.addToHead("HI");
		b.addToHead("HI");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println("------------------------");
		
		
		
		System.out.println("Remove index 2:");
		a.remove(2);
		b.remove(2);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println("------------------------");	
		
		
		System.out.println("Remove From Head :");
		a.removeFromHead();
		b.removeFromHead();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println("------------------------");	
		
		
		
		System.out.println("Remove From Tail :");
		a.removeFromTail();
		b.removeFromTail();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println("------------------------");	
		
		
		
		
		
		
		
		
		
	}
}
