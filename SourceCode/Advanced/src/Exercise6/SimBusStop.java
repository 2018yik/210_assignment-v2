/**
 * Title:        SimBusStop.java
 * Description:  A simple Bus Stop simulation using Queue
 * Company:      ICT HKIVE(TY)
 * @author       Patrick Tong
 */
package Exercise6;
import Exercise6.miscLib.*;

import java.util.*;
public class SimBusStop {

    public static void main(String[] args) {
//    ListQueue t = new ListQueue();
	ArrayQueue t = new ArrayQueue(50);
    int code, time, count;
    Integer item;
    int people = 0;
    int wait = 0;

    int buscount = 0;//(a)
    ArrayList avppl = new ArrayList(); //(b)
    ArrayList avseat = new ArrayList(); //(c)
    int lastinputtime = 0; //(d)
    
    
    
		do {
			code = SimpleInput.getInteger("Code (0 for people, 1 for bus, -1 to exit): ");
		} while (code < -1 || code > 1);
		
		int lastTime = 0;
		
		while (code!=-1) {
			do {
				time = SimpleInput.getInteger("Arrival time (>="+Integer.toString(lastTime)+"): ");
			} while (lastTime > time);
			lastTime = time;
			do {
				count = SimpleInput.getInteger("Arrival count (> 0): ");
			} while (count <= 0);
			
			if (code==0) {
				lastinputtime = time;
				people += count;
				while (count-- > 0)
					t.enqueue (new Integer(time));
			}
			
			else if (code==1) {
				lastinputtime = time;
				int counterpeople = 0;
				int count1 = count;
				while ( (count-- > 0) && !t.empty ()){
					item = (Integer) t.dequeue ();
					wait += time - item.intValue();
					counterpeople = counterpeople + 1;
					
				}
				avppl.add(counterpeople);
				avseat.add(count1-counterpeople);
				buscount = buscount + 1;
			}
			do {
				code = SimpleInput.getInteger("Code (0 for people, 1 for bus, -1 to exit): ");
			} while (code < -1 || code > 1);
		}

		if (people!=0)
		
			System.out.println("(a) The number of bus passed is:" + buscount);
			System.out.println("(b) Average number of people got on a bus is:" + avglist(avppl));
			System.out.println("(c) Average number of vacant seats  for bus levaving:" +avglist(avseat));
			System.out.println("(d) People still waiting is :" + t.returncount());
		
			if (t.empty ()) {
			System.out.println (people + " people waited for " +
					wait + " minutes, average waiting time = " +
					(float) wait/people + " minutes.");
			} else {
				System.out.println (people + " people waited for (" +
						wait + " minutes " + "and (d) still waiting * last input time is :" + t.returncount() * lastinputtime + " Total mins is " + (t.returncount() * lastinputtime + wait)+ " ), average waiting time = " +
						(wait + t.returncount() * lastinputtime)/people + " minutes.");
				
			}
			
			
	} // main
    
    public static double avglist(ArrayList a) {
    	
    	double b = 0;
    	for (int i = 0; i < a.size(); i++) {
    	b =b + (int)(a.get(i));
    	}
    	return b / a.size();
    	
    	}
    	
    	
    
    
    	

} // class SimBusStop