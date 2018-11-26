package Exercise10;

public class Main {
	
	public static void main(String[] args) {
		
		int[] array = {89,83,39,33,12,6,36,18,23};
		int[] array1 = {89,83,39,33,12,6,36,18,23};
		HeapSort hp = new HeapSort(array);
		
		hp.maxextract();
		System.out.println("DESC ORDER");
		System.out.println(hp.tostring());
		
		HeapSort hp1 = new HeapSort(array1);
		hp1.minextract();

		System.out.println("ASC ORDER");
		System.out.println(hp1.tostring());
		
		
		
		
	}
}
