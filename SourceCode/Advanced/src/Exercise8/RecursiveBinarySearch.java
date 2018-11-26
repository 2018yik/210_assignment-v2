package Exercise8;

public class RecursiveBinarySearch {

	String finaltext = "";
	int counter = 1;
	public void initlizeSearch() {
		finaltext = "";
		counter = 1;
		
	}
	public String RecursiveBinarySearch1(int target, int[] intarray,int low, int high) {
		
		if (low > high) {
			finaltext = "";
			counter = 1;
			return "-1";
			
		}  else {
		
			int middle = (low + high) / 2;
			finaltext = finaltext + " " + counter + " Time Middle Index: " + middle + " Middle Result " + intarray[middle] + "\n";
			if (intarray[middle] == target) {
				return finaltext;
			} else {
					
				if (intarray[middle] > target) {
					counter = counter +1;
					return RecursiveBinarySearch1(target,intarray,0,middle-1);
				} else {
					counter = counter +1;
					return RecursiveBinarySearch1(target,intarray,middle+1,high);
				}		
			}
		}
		
	}
}
