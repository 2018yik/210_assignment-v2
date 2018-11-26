package Exercise11;

public class bubblesort {

	int[] arr;
	int counter = 0;
	int counter1 = 0;
	public bubblesort(int[] ar) {
		arr = ar;
		
	}
	
	public void asc() {
		counter = 0;
		boolean checker = false;
		while (checker == false) {
			for (int i =0; i < arr.length; i++) {
				boolean checker1 = true;
				for (int j = 0; j < arr.length-1-i; j++) {
			
					if (arr[j] > arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						counter = counter + 1;
						checker1 = false;
					}
				
				}
				
			
				
				
				
				if (checker1 ==true) {
					checker = true;
				}
				
				System.out.println("------------" + (i+1) + " Time ------------");
				System.out.println("Continuous Asc order count:" + returncounter());
				System.out.println("String is: "+ tostring());
			}
			
			
			
			
			
		}
		}
	
	public void desc() {
		counter1 = 0;
		boolean checker = false;
		while (checker == false) {
			for (int i =0; i < arr.length; i++) {
				boolean checker1 = true;
				for (int j = 0; j < arr.length-1-i; j++) {
			
					if (arr[j] < arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						counter1 = counter1 + 1;
						checker1 = false;
					}
				
				}
				if (checker1 ==true) {
					checker = true;
				}
				System.out.println("------------" + (i+1) + " Time ------------");
				System.out.println("Continuous DESC order count:" + returncounter1());
				System.out.println("String is: "+ tostring());
			}
			
			
			
			
		}	
		}
	
	
		public int returncounter() {
			return counter;
		}
	
		public int returncounter1() {
			return counter1;
		}
		
		public String tostring() {
		
		String text = "";
		for (int i =0; i < arr.length; i++) {
			text = text + arr[i] + " ";
		}
		return text;
			
			
		}
}
