package Exercise7;

	class DoublyNode {
		Object data;
		DoublyNode next;
		DoublyNode previous;
		DoublyNode(Object o) {
			data = o; next=previous=null;
		}
		DoublyNode(Object o, DoublyNode nextNode,DoublyNode previousNode) {
				data = o;
				next = nextNode;
				previous = previousNode;
		
	}
			Object getData() {
				return data;
			}
			DoublyNode getNext() {
				return next;
			}
			DoublyNode getPrevious() {
				return previous;
			}
	}
public class DoublyLL {
	private DoublyNode head;
	private DoublyNode tail;
	public DoublyLL() { 
		head=tail=null; 
		}
	public boolean isEmpty() { 
		return head==null;
		}
	
	public void addToHead(Object item) {
		if (isEmpty()) {
			head=tail=new DoublyNode(item);
		} else {
			head = head.previous = new DoublyNode(item,head,null);			
		}
	}
	
	
	public void addToTail(Object item) {
		if (isEmpty()) {
			addToHead(item);
			
		} else {
			tail = tail.next = new DoublyNode(item,null,tail);
		}
		}
	public Object removeFromHead() throws EmptyListException {
		Object item = null;
		if (isEmpty())
			throw new EmptyListException();
		item = head.data;
		if (head == tail)
			head = tail = null;
		else
		{
			head = head.next;
		}
		head.previous = null;
		return item;
	}
	
	public Object removeFromTail() throws EmptyListException {
			Object item = null;
			if (isEmpty())
				throw new EmptyListException();
			item = tail.data;
			if (head == tail)
				head = tail = null;
			else
			{
				tail = tail.previous;
			}
			tail.next = null;
			return item;
				}	
	
	
	//doubly linked list add data
	
	public void addDatatoDoublyList(Object item) {
		boolean checker = true;
		if (isEmpty()) {
			addToHead(item);
		} else {
			DoublyNode current = head; 
			int counter = 0 ;
			while (current != null) {
				Object co = current.data;
				if (!((String)co).equals((String)item)) {
				if (!comparetwoobject(co,item)) {
					if (counter == 0) {			
						addToHead(item);
						checker = false;
					} else {
						DoublyNode newc = new DoublyNode(item,null,null);
						DoublyNode old = current.previous;
						old.next = newc;
						newc.previous = old;
						newc.next = current;
						current.previous = newc;
						
						
						checker = false;	
					}
					break;
				} else {
					current = current.next;	
					
				}
			} else {
				checker = false;
				break;
				
			}
				counter = counter + 1;
			}

			if (checker == true) {
				addToTail(item);
			}
			
	}
	}

	
	public boolean comparetwoobject(Object current, Object newo) {
		boolean checker = true;
		int counter = 0;
		int length1 = ((String) current).length();
		int length2 = ((String)newo).length();
		int length3 = 0;
		if (length1 >= length2) {
			length3 =  length2;
		} else {
			length3 = length1;
		}
		
		for (int i =0; i < length3; i++) {
			if (lettertoindex(((String) current).substring(i,i+1)) < lettertoindex(((String)newo).substring(i,i+1))) {
				counter = counter + 1;
				break;
			} else if (lettertoindex(((String) current).substring(i,i+1)) > lettertoindex(((String)newo).substring(i,i+1))) {
				counter = counter + 1;
				checker = false;
				break;
			}
		}
		
		
		if (counter == 0 && checker == true) {
			if (length1 > length2) {
				checker = false;
			} else {
				checker = true;
			}
		
		}
		
		return checker;
		
	}
	
	public int lettertoindex(String a) {
		String[] letter = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		int counter = 0;
		for (int i =0; i < letter.length; i++){
			if (letter[i].equals(a.toUpperCase())) {
				counter = i;
				break;
			}
		}
		return counter;
		
	}
	
	
	//doubly linked list add data
	
	
	
	public String toString() { 
		String s = "[ "; 
		DoublyNode current = head; 
		while (current != null) {
		s += current.data + " ";
		  current = current.next;
		}
		  return s + "]";
		}
	
	public String reverseString() { 
		String s = "[ ";
	DoublyNode current = tail; 
	while (current != null) {
	s += current.data + " ";
	current = current.previous; 
	}
	  return s + "]";
	}
	
	
	class EmptyListException extends RuntimeException {
		public EmptyListException ()
			{ super("List is empty"); }
	} // class EmptyListException
	
	

}
