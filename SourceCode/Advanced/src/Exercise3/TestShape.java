package Exercise3;
import java.util.*;
public class TestShape {
	   public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
		   System.out.println("How many shape u want to create? Number should be > 0");
		   String counttext = sc.nextLine();
		   if (checkernumber(counttext)) {
			   int count = Integer.parseInt(counttext);
		   if (count <= 0) {
			   System.out.println(" can not be negative or zero");
		   } else {
		   
		 ArrayList<Shape> a = new ArrayList<Shape>();		 
		  
		  for (int i = 0; i < count; i++) {
			  int randomnumber = (int)Math.floor(Math.random()*2);
			  if (randomnumber == 0) {
				  int randomradius = (int)Math.floor(Math.random()*1000);
				  a.add(new Circle((int)Math.floor(Math.random()*1000),(int)Math.floor(Math.random()*1000),randomradius));
				  
				  
			  } else if (randomnumber == 1) {
				  int length = (int)Math.floor(Math.random()*1000);
				  int width = (int)Math.floor(Math.random()*1000);
				  a.add(new Rectangle((int)Math.floor(Math.random()*1000),(int)Math.floor(Math.random()*1000),length,width));
			  }
		  }
	   
		   for (int i =0; i <a.size(); i++) {
			
	      System.out.print(a.get(i).getName() +
	                            ": " + a.get(i).toString());
	      System.out.println("; Area = " + a.get(i).getArea());
		   }
		   }
	   } else {
		   System.out.println("can not insert non negative number");
	   }
	   }

	   public static boolean checkernumber(String a) {
			boolean checker = true;
			try {
				int num = Integer.parseInt(a);
			} catch (NumberFormatException ex){
				checker = false;			
		}
			return checker;
			}
	}
