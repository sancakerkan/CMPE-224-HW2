import java.util.ArrayList;
import java.util.List;

//-----------------------------------------------------
// Title: DirectGraph Class
// Author: Erkan Sancak
// ID: 44293566706
// Section: 2
// Assignment: 2
// Description: This class represents a directed graph using adjacency lists.
//-----------------------------------------------------

public class DirectGraph {
    // Adjacency list representation of the graph where each vertex has a list of its neighbors.
    private List<List<Integer>> adjList;

    //--------------------------------------------------------
    // Constructor: DirectGraph(int vertices)
    // Summary: Creates a new directed graph with the specified number of vertices.
    // Precondition: 'vertices' is an integer greater than 0.
    // Postcondition: A graph is initialized with 'vertices' number of vertices.
    //--------------------------------------------------------
    public DirectGraph(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    //--------------------------------------------------------
    // Method: addEdge(int src, int dest)
    // Summary: Adds a directed edge from vertex 'src' to vertex 'dest'.
    // Precondition: 'src' and 'dest' are existing vertices in the graph.
    // Postcondition: The edge is added to the graph.
    //--------------------------------------------------------
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    //--------------------------------------------------------
    // Method: findTwoStepPaths(int start)
    // Summary: Finds all paths of length two starting from the given vertex.
    // Precondition: 'start' is a vertex in the graph.
    // Postcondition: A list of two-step paths is returned.
    //--------------------------------------------------------
    public List<List<Integer>> findTwoStepPaths(int start) {
        List<List<Integer>> results = new ArrayList<>();
        if (start >= adjList.size()) return results; // out of bounds check

        List<Integer> firstStep = adjList.get(start);
        for (int node : firstStep) {
            for (int secondNode : adjList.get(node)) {
                results.add(List.of(start, node, secondNode));
            }
        }
        return results;
    }

    //--------------------------------------------------------
    // Method: printEdges()
    // Summary: Prints all the edges in the graph to the console.
    // Precondition: None.
    // Postcondition: The edges of the graph are printed to the console.
    //--------------------------------------------------------
    public void printEdges() {
        for (int i = 0; i < adjList.size(); i++) {
            for (int edge : adjList.get(i)) {
                System.out.println(i + " " + edge);
            }
        }
    }

    //--------------------------------------------------------
    // Method: getNumVertices()
    // Summary: Returns the number of vertices in the graph.
    // Precondition: None.
    // Postcondition: The number of vertices is returned.
    //--------------------------------------------------------
    public int getNumVertices() {
        return adjList.size();
    }
}