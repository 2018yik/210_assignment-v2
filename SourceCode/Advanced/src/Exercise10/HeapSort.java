package Exercise10;

import java.util.Arrays;

public class HeapSort {
	
	int[] heap;
	int[] heap2;
	
	int counter2 = 0;
	int counter3 = 0;
	public HeapSort(int[] a) {
		heap = a;
	}
	
	public void maxconstruct() {
		
	for (int i = (heap.length-2) / 2; i >= 0; i--) {
	     int current = i;
	     
	     int current1 = i; // record the larger child;
	     
	     boolean done = false;
	     while (!done) {
	    	 if (current *2 +1 > heap.length-1 && current*2+2 > heap.length-1){
	    		 done= true;
	    	 } else {
	    		 if (current*2+2 > heap.length-1) {
	    			 current1 = current*2+1;
	    		 } else {
	    			 if (heap[current*2+2] > heap[current*2+1]) {
	    				 current1 = current*2+2;
	    			 } else {
	    				 current1 = current*2+1; 
	    			 }
	    		 }
	    		 	if (heap[current] < heap[current1]) {
	    		 		int temp = heap[current];
	    		 		heap[current] = heap[current1];
	    		 		heap[current1] = temp;
	    		 		current = current1;
	    		 		counter2 = counter2 + 1;
	    		 	} else {
	    		 		done = true;
	    		 	}
	    	 }
	     }
	}
	
	}
	
	public void minconstruct() {
		
		for (int i = (heap.length-2) / 2; i >= 0; i--) {
		     int current = i;
		     
		     int current1 = i; // record the larger child;
		     
		     boolean done = false;
		     while (!done) {
		    	 if (current *2 +1 > heap.length-1 && current*2+2 > heap.length-1){
		    		 done= true;
		    	 } else {
		    		 if (current*2+2 > heap.length-1) {
		    			 current1 = current*2+1;
		    		 } else {
		    			 if (heap[current*2+2] < heap[current*2+1]) {
		    				 current1 = current*2+2;
		    			 } else {
		    				 current1 = current*2+1; 
		    			 }
		    		 }
		    		 	if (heap[current] > heap[current1]) {
		    		 		int temp = heap[current];
		    		 		heap[current] = heap[current1];
		    		 		heap[current1] = temp;
		    		 		current = current1;
		    		 		counter3 = counter3 + 1;
		    		 	} else {
		    		 		done = true;
		    		 	}
		    	 }
		     }
		}
		
		}
	
			public void maxextract() {
				
				heap2 = new int[heap.length];
				int counter = 1;
				for (int size = heap.length-1; size >= 0; size--) {
					System.out.println("Before extract:" + tostring());
					maxconstruct();
					System.out.println("After extract:" + tostring());
					
					
					int temp = heap[0];
					heap[0] = heap[heap.length-1];
					int[] heap1;
					boolean done = false;
					heap2[counter-1] = temp;
						System.out.println("--------------" + counter + " Time ------------------" );
						System.out.println("Remove node:" + temp);
					heap1  = Arrays.copyOf(heap, heap.length -1);
					heap = heap1;
					
					
					
					counter = counter + 1;
				}
				System.out.println("--------------");
				System.out.println("Final Sorted Array is :" + tostring1());
				System.out.println("Final swap Count is :" + returncounter2());
			}
			
			public void minextract() {

				heap2 = new int[heap.length];
				int counter = 1;
				for (int size = heap.length-1; size >= 0; size--) {
					System.out.println("Before extract:" + tostring());
					minconstruct();
					System.out.println("After extract:" + tostring());
					
					int temp = heap[0];
					heap[0] = heap[heap.length-1];
					int[] heap1;
					boolean done = false;
					heap2[counter-1] = temp;
						System.out.println("--------------" + counter + " Time ------------------" );
						System.out.println("Remove node:" + temp);
					heap1  = Arrays.copyOf(heap, heap.length -1);
					heap = heap1;
					
					
					
					counter = counter + 1;
				}
				System.out.println("--------------");
				System.out.println("Final Sorted Array is :" + tostring1());
				System.out.println("Final swap Count is :" + returncounter3());
			}
			
	
			
			
			public String tostring() {
				String text = "";
				
				for (int i =0; i < heap.length; i++) {
					text = text + heap[i] + " ";	
				}
				return text;
				}	
			
			public String tostring1() {
				String text = "";
				
				for (int i =0; i < heap2.length; i++) {
					text = text + heap2[i] + " ";	
				}
				return text;
				}
			public int returncounter2() {
				return counter2;
			}
			
			public int returncounter3() {
				return counter3;
				
			}
}
