package Exercise13;
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
	
	//Dijkstra algorithm
	public int[][] converttwodarray() {
		int[][] darray = new int[v][v];
		//initize array all data to 0
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				darray[i][j] = 0;
			}
		}
		
		//end
		
	String title = "Node Number";
	for (int i = 0; i < v; i ++) {
		title = title +", "+ (i+1) + " "; 
	}
	System.out.println(title); // print title
		
	
	for (int i = 0; i < v; i++) {
		for (int j = 0; j < elist[i].size(); j++) {
			
			darray[i][elist[i].get(j).target-1] = elist[i].get(j).dis;
		}
		String text = "Node Num :" + (i+1);
		for (int k = 0; k < darray[i].length; k++) {
			text = text + ", " + darray[i][k] + " ";	
		}
		System.out.println(text);
	}
	
	return darray;
		
	}
	
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int x = 0; x < v; x++) 
            if (sptSet[x] == false && dist[x] <= min) 
            { 
                min = dist[x]; 
                min_index = x; 
            } 
  
        return min_index; 
    } 
  
    void printSolution(int dist[], int n,int startpoint) 
    { 
        System.out.println("Shortest path from vertex 1 to other vertex"); 
        for (int i = 0; i < v; i++) 
            System.out.println("To " + (i+1)+" need "+dist[i]); 
    } 
  
    void dijkstra(int graph[][], int src) 
    { 
        int dist[] = new int[v]; 
  
        
        Boolean sptSet[] = new Boolean[v]; 
  
        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < v; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        // Distance of source vertex from itself is always 0 
        dist[src-1] = 0; 
  
        // Find shortest path for all vertices 
        for (int count = 0; count < v-1; count++) 
        { 
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, sptSet); 
  
            // Mark the picked vertex as processed 
            sptSet[u] = true; 
  
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int x = 0; x < v; x++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[x] && graph[u][x]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][x] < dist[x]) 
                    dist[x] = dist[u] + graph[u][x]; 
        } 
  
        // print the constructed distance array 
        printSolution(dist, v,src); 
    } 
	
	
	
	
	
	
	
	
	
	
	//end of Dijkstra algorithm
	
	
	
	
	
	
	
	
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
		while (!checker) {
			boolean checker1 = false;
		if (vn.size() == v) {
			checker = true; //exit program if visited all node
			break;
		}
		LinkedList<Edge> newlist = elist[gogonode-1];
	
		for (int i = 0; i < newlist.size(); i++) {
			
			if (BFSchecker(vn,newlist.get(i).target) && BFSqueueChecker(q,newlist.get(i).target)){	
			q.add(newlist.get(i).target);
			checker1 = true;
		}
		}
		if (BFSchecker(vn,gogonode)) {
			vn.add(gogonode);
		}
			if (q.size() != 0 ) {
			gogonode= (int)q.poll();
			counter = 0;
			} else {
				if (vn.size() -1-counter <0 ) {
					checker = true;
					break;
				} else {
					gogonode = (int)vn.get(vn.size()-1-counter);
					counter = counter + 1;
					System.out.println("***Remove back***");
				}
			
			}
		returnBFSString(q,vn,gogonode);
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
	
	// End Of BFS Part
	
	
	
	
	
	
	
	
	
	
	//DFS part
	
	
	
	public void DFS(int startnode) {
		Stack s = new Stack();
		s.push(startnode);
		ArrayList vn = new ArrayList();
		boolean checker = false;
		int gogonode = startnode;
		int counter = 0;
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
						checker2 = false;
						break;
					}	
				}
				
				if (checker2 == true) {
					if (BFSchecker(vn,gogonode)) {
						vn.add(gogonode);
					}
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
				
					s.pop();
					if (s.size() != 0) {
						gogonode = (int)s.peek();
						} else {
							checker = true;
						}
				
			}
			returnDFSString(s,vn,gogonode);
			
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
	
	
	//ENd of DFS part
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
