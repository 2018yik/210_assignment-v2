package Exercise7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;

public class Main {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fstream = new FileInputStream(System.getProperty("user.dir")+"/abc.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String text = "";
		String text1 = "";
		while ((text = br.readLine()) != null)   {
			  text1 = text1 + text;
			}
		
		text1 = text1.replace(".","").replace(",","");
		
		String[] textarray = text1.split(" ");
		
		DoublyLL dl = new DoublyLL();
		
		System.out.println("text : " + text1);
		
		
		for (int i =0; i < textarray.length; i++) {
				dl.addDatatoDoublyList(textarray[i]);
		}
		
		
		
		System.out.println("String is : " + dl.toString());
		System.out.println("ReverseString is : " + dl.reverseString());
		
		
	}
}
