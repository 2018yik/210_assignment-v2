package Exercise12;
import java.util.*;
public class Graph {

	int v;
	LinkedList<Edge> [] elist;
	
	public Graph(int size) {
		v = size;
		elist = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			elist[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int s, int t, int d) {
		Edge e = new Edge(s,t,d);
		elist[s-1].addLast(e);
		
	}
	
	public void printGraph(){
        for (int i = 0; i <v ; i++) {
            LinkedList<Edge> list = elist[i];
            for (int j = 0; j <list.size() ; j++) {
                System.out.println("v-" + (i+1) + " to " + list.get(j).target + " weight is : " +  list.get(j).dis);
            }
        }
    }
	
	
	
	
	//BFS part
	
	
	
	public void BFS(int startnode) {
		Queue q = new LinkedList();
		ArrayList vn = new ArrayList();
		boolean checker = false;
		int gogonode = startnode;
		int counter = 0;
		
		System.out.println("Node visited ¡@¡@¡@¡@Queue");
		String nodevisited = startnode + "";
		System.out.println(nodevisited + "¡@ ¡@¡@¡@¡@ ¡@¡@¡@¡@  ¡@¡@¡@¡@¡@¡@" + nodevisited);
		
		
		while (!checker) {
		if (vn.size() == v) {
			checker = true; //exit program if visited all node
			break;
		}
		LinkedList<Edge> newlist = elist[gogonode-1];
	
		for (int i = 0; i < newlist.size(); i++) {
			
			if (BFSchecker(vn,newlist.get(i).target) && BFSqueueChecker(q,newlist.get(i).target)){	
			q.add(newlist.get(i).target);
			System.out.println("--------------------------------");
			System.out.println(BFSString(newlist.get(i).target+"",q));
		}
		}
		
		if (BFSchecker(vn,gogonode)) {
			vn.add(gogonode);
		}
			if (q.size() != 0 ) {
			gogonode= (int)q.poll();
			nodevisited ="";
			counter = 0;
			} else {
				if (vn.size() -1-counter <0 ) {
					checker = true;
					break;
				} else {
					gogonode = (int)vn.get(vn.size()-1-counter);
					counter = counter + 1;
					nodevisited="";
				}
			
			}
			System.out.println("--------------------------------");
		System.out.println(BFSString(nodevisited,q));

		}
	}

	public boolean BFSchecker(ArrayList vn,int nodeindex) {
		boolean checker = true;
		for (int i = 0; i < vn.size(); i++) {
			if (vn.get(i).equals(nodeindex)) {
				checker = false;
			}
			
		}
		return checker;
	}
	
	public boolean BFSqueueChecker(Queue aq,int node) {
		boolean checker = true;
		for (Object x : aq ){
			if ((int)x == node) {
				checker = false;
			}
		}
		return checker;		
	}
	
	
	public void returnBFSString(Queue aq, ArrayList vn, int startnode) {
		String queue = aq.toString();
		String visited = "";
		for (int i =0; i < vn.size(); i++) {
			if (i ==0) {
				visited = visited + vn.get(i);
			} else {
			visited = visited +","+ vn.get(i);
			}
		}
		System.out.println("Now queue:" + queue);
		System.out.println("Now visited:" + visited);
		System.out.println("Now staynode:" + startnode);
		System.out.println("--------------------------");
		
	}
	
	public String BFSString(String node, Queue a) {
		return node + "¡@ ¡@¡@¡@¡@ ¡@¡@¡@¡@  ¡@¡@¡@¡@¡@¡@" + a.toString();
	
	}
	
	// End Of BFS Part
	
	
	
	
	
	
	
	
	
	
	//DFS part
	
	
	
	public void DFS(int startnode) {
		Stack s = new Stack();
		s.push(startnode);
		ArrayList vn = new ArrayList();
		boolean checker = false;
		int gogonode = startnode;
		int counter = 0;
		
		System.out.println("Node visited ¡@¡@¡@¡@Stack");
		String nodevisited = startnode + "";
		System.out.println(nodevisited + "¡@ ¡@¡@¡@¡@ ¡@¡@¡@¡@  ¡@¡@¡@¡@¡@¡@" + nodevisited);
		
		while (!checker) {
			
			if (vn.size() == v && s.size() == 0) {
				checker = true; //exit program if visited all node
				break;
			}
			
			LinkedList<Edge> newlist = elist[gogonode-1];
			
			if (newlist.size() != 0) {
				boolean checker2 = true;
				for (int i =0; i < newlist.size(); i++) {
					if (BFSchecker(vn,newlist.get(i).target) && DFSstackChecker(s,newlist.get(i).target)) {
						if (BFSchecker(vn,gogonode)) {
						vn.add(gogonode);
						}
						gogonode = newlist.get(i).target;
						s.push(gogonode);
						nodevisited = gogonode+"";
						checker2 = false;
						break;
					}	
				}
				
				if (checker2 == true) {
					if (BFSchecker(vn,gogonode)) {
						vn.add(gogonode);
					}
					nodevisited ="Back";
						s.pop();
						if (s.size() != 0) {
						gogonode = (int)s.peek();
						} else {
							checker = true;
						}
				}
				
			} else {
			
				if (BFSchecker(vn,gogonode)) {
					vn.add(gogonode);
				}
					nodevisited ="Back";
					s.pop();
					if (s.size() != 0) {
						gogonode = (int)s.peek();
						} else {
							checker = true;
						}
				
			}
			System.out.println("--------------------------------");
			System.out.println(DFSString(nodevisited,s));
			
	}
	}
	
	public boolean DFSstackChecker(Stack aq,int node) {
		boolean checker = true;
	
		for (int i =0; i < aq.size(); i++) {
			if ((int)aq.get(i) == node) {
				checker = false;
				}
			
		}
		return checker;		
	}
	
	public void returnDFSString(Stack aq, ArrayList vn, int startnode) {
		String stack = aq.toString();
		String visited = "";
		for (int i =0; i < vn.size(); i++) {
			if (i ==0) {
				visited = visited + vn.get(i);
			} else {
			visited = visited +","+ vn.get(i);
			}
		}
		System.out.println("Now stack:" + stack);
		System.out.println("Now visited:" + visited);
		System.out.println("Now staynode:" + startnode);
		System.out.println("--------------------------");
		
	}
	
	
	public String DFSString(String node, Stack a) {
		return node + "¡@ ¡@¡@¡@¡@ ¡@¡@¡@¡@  ¡@¡@¡@¡@¡@¡@" + a.toString();
	
	}
	
	
	//ENd of DFS part
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
