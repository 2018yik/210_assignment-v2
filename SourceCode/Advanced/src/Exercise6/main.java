package Exercise6;

public class main {

	public static void main(String[] args) {
		
		ArrayQueue aq = new ArrayQueue(50);
		
		
		aq.enqueue("1");
		System.out.println(aq.toString());
		
		aq.enqueue("2");
		System.out.println(aq.toString());
		
		
		aq.enqueue("3");
		System.out.println(aq.toString());
		
		aq.dequeue();
		System.out.println(aq.toString());
		
	}
	
	
}
