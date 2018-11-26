package Exercise13;

public class Main {

	public static void main(String[] args) {
		
		Graph g = new Graph(6);
		
		g.addEdge(1, 2, 7);
		g.addEdge(1, 3, 2);
		g.addEdge(1, 4, 9);
		g.addEdge(1, 5, 3);
		g.addEdge(1, 6, 5);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 2, 9);
		g.addEdge(3, 4, 4);
		g.addEdge(3, 5, 9);
		g.addEdge(3, 6, 4);
		g.addEdge(5, 4, 5);
		g.addEdge(5, 6, 1);
		g.addEdge(6, 4, 10);

		g.printGraph();
		System.out.println("--------------------------");
		int[][] fullarray = g.converttwodarray();
		g.dijkstra(fullarray,1);
		
	}
	
	
	
}
