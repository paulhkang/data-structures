import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Dijkstra {

  // Keep a fast index to nodes in the map
  private Map<String, Vertex> vertexNames;

  /**
   * Construct an empty Dijkstra with a map. The map's key is the name of a vertex
   * and the map's value is the vertex object.
   */
  public Dijkstra() {
    vertexNames = new HashMap<String, Vertex>();
  }

  /**
   * Adds a vertex to the dijkstra. Throws IllegalArgumentException if two vertices
   * with the same name are added.
   * 
   * @param v
   *          (Vertex) vertex to be added to the dijkstra
   */
  public void addVertex(Vertex v) {
    if (vertexNames.containsKey(v.name))
      throw new IllegalArgumentException("Cannot create new vertex with existing name.");
    vertexNames.put(v.name, v);
  }

  /**
   * Gets a collection of all the vertices in the dijkstra
   * 
   * @return (Collection<Vertex>) collection of all the vertices in the dijkstra
   */
  public Collection<Vertex> getVertices() {
    return vertexNames.values();
  }

  /**
   * Gets the vertex object with the given name
   * 
   * @param name
   *          (String) name of the vertex object requested
   * @return (Vertex) vertex object associated with the name
   */
  public Vertex getVertex(String name) {
    return vertexNames.get(name);
  }

  /**
   * Adds a directed edge from vertex u to vertex v
   * 
   * @param nameU
   *          (String) name of vertex u
   * @param nameV
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addEdge(String nameU, String nameV, Double cost) {
    if (!vertexNames.containsKey(nameU))
      throw new IllegalArgumentException(nameU + " does not exist. Cannot create edge.");
    if (!vertexNames.containsKey(nameV))
      throw new IllegalArgumentException(nameV + " does not exist. Cannot create edge.");
    Vertex sourceVertex = vertexNames.get(nameU);
    Vertex targetVertex = vertexNames.get(nameV);
    Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
    sourceVertex.addEdge(newEdge);
  }

  /**
   * Adds an undirected edge between vertex u and vertex v by adding a directed
   * edge from u to v, then a directed edge from v to u
   * 
   * @param nameU
   *          (String) name of vertex u
   * @param nameV
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addUndirectedEdge(String nameU, String nameV, double cost) {
    addEdge(nameU, nameV, cost);
    addEdge(nameV, nameU, cost);
  }

  // STUDENT CODE STARTS HERE

  /**
   * Computes the euclidean distance between two points as described by their
   * coordinates
   * 
   * @param ux
   *          (double) x coordinate of point u
   * @param uy
   *          (double) y coordinate of point u
   * @param vx
   *          (double) x coordinate of point v
   * @param vy
   *          (double) y coordinate of point v
   * @return (double) distance between the two points
   */
  public double computeEuclideanDistance(double ux, double uy, double vx, double vy) {
        
	double distance = Math.sqrt(Math.pow((Math.abs(vx - ux)), 2) + Math.pow((Math.abs(vy - uy)), 2));
         
        return distance;
  }

  /**
   * Calculates the euclidean distance for all edges in the map using the
   * computeEuclideanCost method.
   */
  public void computeAllEuclideanDistances() {

 	for( Vertex v : getVertices() )
 	{
 		for( Edge e : v.adjacentEdges )
 		{
 			e.distance = computeEuclideanDistance(e.source.x, e.source.y, e.target.x, e.target.y);
 		}
 	}
  }

  /**
   * Dijkstra's Algorithm. 
   * 
   * @param s
   *          (String) starting city name
   */
  public void doDijkstra(String s) {


	LinkedList<Vertex> vertices = new LinkedList<>(getVertices());
        LinkedList<Vertex> known = new LinkedList<>();


        vertexNames.get(s).known = true;
        vertexNames.get(s).prev = null;
        vertexNames.get(s).distance = 0;

        
        int idx = vertices.indexOf(vertexNames.get(s));

	final int init_size = vertices.size();

        
        while(!vertices.isEmpty())
        {
		
		Vertex leastweight = new Vertex("initial", 0, 0);



		// "Base case" if this is the first element added, to mark the starting point as known.
		if(vertices.size() == init_size)
			known.addFirst(vertices.remove(idx));


//		System.out.println("known init size: " + known.size());
//		System.out.println("vertices init size: " + vertices.size());


		// add preliminary dv and pv for adjacent (unknown) edges
		for( Vertex v : known )
		{
			for( Edge e : v.adjacentEdges )
			{
				e.target.prev = v;
				if(e.target.distance == 0 || e.target.distance > v.distance + e.distance)
					e.target.distance = v.distance + e.distance;
			}
		
//			System.out.println("KNOWN VERTEX: " + v.name);
		}


		// check vertices linkedlist for smallest distance
		for( Vertex v : vertices )
		{
			for( Vertex k : known )
			{
				for( Edge e : k.adjacentEdges )
				{
					if(e.target.equals(v) && !e.target.equals(k))
					{

						if(leastweight.name.equals("initial"))
						{
//							System.out.println("leastweight base case");
							leastweight = v;
						}
						else if(v.distance < leastweight.distance)
						{
//							System.out.println("leastweight updated!");
							leastweight = v;
						}
					}
			

				}

			}
		}


//		System.out.println("LEASTWEIGHT VERTEX: " + leastweight.name);



		// moves leastweight vertex from vertices to known
		known.addFirst(leastweight);


//		System.out.println("known size: " + known.size());


//		System.out.println("contains? " + vertices.contains(leastweight));

		boolean res = vertices.remove(leastweight);
//		System.out.println("removed? " + res);


//		System.out.println("vertices size: " + vertices.size());

//		System.out.println("\n\n");

		// if it somehow fails to remove leastweight from vertices (meaning that vertices does not contain leastweight)
		if(res == false)
			break;







        }




  }

  /**
   * Returns a list of edges for a path from city s to city t. This will be the
   * shortest path from s to t as prescribed by Dijkstra's algorithm
   * 
   * @param s
   *          (String) starting city name
   * @param t
   *          (String) ending city name
   * @return (List<Edge>) list of edges from s to t
   */
  public List<Edge> getDijkstraPath(String s, String t) {
    doDijkstra(s);


	LinkedList<Edge> path = new LinkedList<>();

	Vertex end = vertexNames.get(t);
	Vertex current = end;

	while(current != vertexNames.get(s))
	{

		for( Edge e : current.adjacentEdges )
		{
			if(e.target.equals(current.prev))
				path.addFirst(e);
		}

		current = current.prev;
	}


    // TODO
    return path; // Replace this
  }

  // STUDENT CODE ENDS HERE

  /**
   * Prints out the adjacency list of the dijkstra for debugging
   */
  public void printAdjacencyList() {
    for (String u : vertexNames.keySet()) {
      StringBuilder sb = new StringBuilder();
      sb.append(u);
      sb.append(" -> [ ");
      for (Edge e : vertexNames.get(u).adjacentEdges) {
        sb.append(e.target.name);
        sb.append("(");
        sb.append(e.distance);
        sb.append(") ");
      }
      sb.append("]");
      System.out.println(sb.toString());
    }
  }



/*


	public void testMethod()
	{
		Vertex lv = vertexNames.get("LasVegas");
		for( Edge e : lv.adjacentEdges)
		{
			if(lv != e.target)
				System.out.println(e.target.name);
		}
	}
*/










  /** 
   * A main method that illustrates how the GUI uses Dijkstra.java to 
   * read a map and represent it as a graph. 
   * You can modify this method to test your code on the command line. 
   */
  public static void main(String[] argv) throws IOException {
    String vertexFile = "cityxy.txt"; 
    String edgeFile = "citypairs.txt";

    Dijkstra dijkstra = new Dijkstra();
    String line;

    // Read in the vertices
    BufferedReader vertexFileBr = new BufferedReader(new FileReader(vertexFile));
    while ((line = vertexFileBr.readLine()) != null) {
      String[] parts = line.split(",");
      if (parts.length != 3) {
        vertexFileBr.close();
        throw new IOException("Invalid line in vertex file " + line);
      }
      String cityname = parts[0];
      int x = Integer.valueOf(parts[1]);
      int y = Integer.valueOf(parts[2]);
      Vertex vertex = new Vertex(cityname, x, y);
      dijkstra.addVertex(vertex);
    }
    vertexFileBr.close();

    BufferedReader edgeFileBr = new BufferedReader(new FileReader(edgeFile));
    while ((line = edgeFileBr.readLine()) != null) {
      String[] parts = line.split(",");
      if (parts.length != 3) {
        edgeFileBr.close();
        throw new IOException("Invalid line in edge file " + line);
      }
      dijkstra.addUndirectedEdge(parts[0], parts[1], Double.parseDouble(parts[2]));
    }
    edgeFileBr.close();

    // Compute distances. 
    // This is what happens when you click on the "Compute All Euclidean Distances" button.
    dijkstra.computeAllEuclideanDistances();
    

    // print out an adjacency list representation of the graph
    dijkstra.printAdjacencyList();

    // This is what happens when you click on the "Draw Dijkstra's Path" button.

    // In the GUI, these are set through the drop-down menus.
    String startCity = "SanFrancisco";
    String endCity = "Boston";

    // Get weighted shortest path between start and end city. 
    List<Edge> path = dijkstra.getDijkstraPath(startCity, endCity);
    
    System.out.print("Shortest path between "+startCity+" and "+endCity+": ");
    System.out.println(path);


//	dijkstra.testMethod();








  }

}
