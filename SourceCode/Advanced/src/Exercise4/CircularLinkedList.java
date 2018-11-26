package Exercise4;

public class CircularLinkedList {

	protected ListNode head;   // <== chnage to protected for inheriting
	protected ListNode tail;      // <== change to protected for inheriting

	protected  int length;		// the length of the list   <== chnage to protected for inheriting

	public CircularLinkedList() {
		head = tail = null;
		length = 0;
	}

	public boolean isEmpty() { return head == null; }

	public void addToHead(Object item) {
		ListNode nd = new ListNode(item);
		if (isEmpty()) {
			head = nd;
			tail = nd;
			nd.setNext(head);
		} else {
			ListNode temp = head;
			head = nd;
			head.setNext(temp);
			tail.setNext(head);	 
		}
			
		length++;
	}

	public void addToTail(Object item) {
		if (isEmpty()) {
			addToHead(item);
		}else {
			ListNode nd = new ListNode(item);
			 tail.setNext(nd);
			tail = nd;
			nd.setNext(head);	
		}
		length++;
	}

	public Object removeFromHead() throws EmptyListException {
		Object item = null;
		if (isEmpty())
			throw new EmptyListException();
		item = head.getData();
		if (head == tail) {
			head = tail = null;
		}else{
			head = head.getNext();
			tail.setNext(head);
		}
		length--;
		return item;
	}

	public Object removeFromTail() throws EmptyListException {
		Object item = null;
		if (isEmpty())
			throw new EmptyListException();
		item = tail.getData();
		if (head == tail)
			head = tail = null;
		else {
			ListNode current = head;
			while (current.getNext() != tail) {
				current = current.getNext(); 
			}
			tail = current;
			
			current.setNext(head);
		}
		length--;
		return item;
	}

	public String toString() {
		String str = "Circular list [ ";
		ListNode current = head;
		int counter = 0;
		boolean checker = true;
		while (checker == true) {
			
			if (current == head && counter != 0) {
				checker = false;	
			}
			if (checker == false) {
				str = str + current.getData();
			} else {
			str = str + current.getData() + " -> ";
			}
			current = current.getNext();
			
			counter = counter +1;
		}
		return str + " ]";
	}

	public int count() {
		return length;
	}

	public Object remove(int n) {
		Object item = null;
		if (n <= length) { // make sure there is nth node to remove
			// special treatment for first and last nodes
			if (n == 1) return removeFromHead();
			if (n == length) return removeFromTail();
			// removal of nth node which has nodes in front and behind
			ListNode current = head;
			ListNode previous = null;
			for (int i = 1; i < n; i++) { // current will point to nth node
				previous = current;
				current = current.getNext();
			}
			// data to be returned
			item = current.getData();
			// remove the node by adjusting two pointers (object reference)
			previous.setNext(current.getNext());
		}
		length--;
		return item;
	}

	public void add(int n, Object item) {
		// special treatment for insert as first node
		if (n == 1) {
			addToHead(item);
			return;
		}
		// special treatment for insert as last node
		if (n > length) {
			addToTail(item);
			return;
		}
		// locate the n-1th node
		ListNode current = head;
		for (int i = 1; i < n-1; i++)	// current will point to n-1th node
			current = current.getNext();
		// create new node and insert at nth position
		current.setNext(new ListNode(item, current.getNext()));
		length++;
	}

	public Object get(int n) {
		// n is too big, no item can be returned
		if (length < n) return null;
		// locate the nth node
		ListNode current = head;
		for (int i = 1; i < n; i++)
			current = current.getNext();
		return current.getData();
	}

} // class LinkedList

