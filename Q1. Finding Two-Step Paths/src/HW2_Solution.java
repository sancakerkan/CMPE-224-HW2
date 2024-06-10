import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//-----------------------------------------------------
// Title: HW2_Solution Main Program
// Author: Erkan Sancak
// ID: 44293566706
// Section: 2
// Assignment: 2
// Description: This program reads a graph from a text file and allows the user to find all two-step 
// paths from a user-specified start point. It utilizes the DirectGraph class to manage the graph and 
// perform the required operations.
//-----------------------------------------------------

public class HW2_Solution {

    //--------------------------------------------------------
    // Function: main(String[] args)
    // Summary: Entry point for the program that handles file reading and graph operations.
    // Precondition: HW2_Q1_text.txt must exist and be formatted correctly.
    // Postcondition: The graph is printed and two-step paths from the user-chosen start point are displayed.
    //--------------------------------------------------------
    public static void main(String[] args) {
        try {
            // Read lines from the graph data file
            List<String> lines = FileRead.readLines("src/HW2_Q1_text.txt");
            // Initialize the graph with the specified number of vertices
            DirectGraph graph = new DirectGraph(10); // Correct number of vertices considering vertex '9' exists

            // Skip the first two lines which contain metadata, not actual edges
            for (int i = 2; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split("\\s+");
                int src = Integer.parseInt(parts[0]);  // source vertex
                int dest = Integer.parseInt(parts[1]);  // destination vertex
                graph.addEdge(src, dest);  // Add edge to the graph
            }

            // Output the number of vertices and edges 
            System.out.println("V=" + (graph.getNumVertices() - 1)); 
            System.out.println("E=" + (lines.size() - 2));  
            graph.printEdges();  

            // Scanner for user input to determine the start point for path finding
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nStart point:");
            int startPoint = scanner.nextInt();  // Read user input for start vertex
            List<List<Integer>> twoStepPaths = graph.findTwoStepPaths(startPoint);  // Find two-step paths from the start point
            
            // Display all found two-step paths
            for (List<Integer> path : twoStepPaths) {
                System.out.println(path.get(0) + " " + path.get(1) + " " + path.get(2));
            }
            scanner.close();  // Close scanner to free resources

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());  // Handle potential IO errors
        } catch (NumberFormatException e) {
            System.out.println("Error in number format: " + e.getMessage());  // Handle potential formatting errors
        }
    }
}