import java.util.*;
import java.io.*;
import java.nio.file.*;

//-----------------------------------------------------
// Title: FileRead Class
// Author: Erkan Sancak
// ID: 44293566706
// Section: 2
// Assignment: 2
// Description: This class reads graph data from a text file and constructs an adjacency list.
//              It skips the first two lines and processes
//              each subsequent line as an edge between two vertices.
//-----------------------------------------------------

public class FileRead {
    private Map<String, List<String>> graph; // Stores the graph as an adjacency list

    //--------------------------------------------------------
    // Constructor: FileRead(String filename)
    // Summary: Initializes a new FileRead object and loads a graph from a specified file.
    // Precondition: 'filename' is a valid path to a text file containing graph data.
    // Postcondition: The graph is populated based on the file content.
    //--------------------------------------------------------
    public FileRead(String filename) throws IOException {
        graph = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(filename));

        // Skips the first two lines and processes each subsequent line as an edge
        for (String line : lines.subList(2, lines.size())) {
            String[] parts = line.split(" ");
            String src = parts[0];  // Source vertex
            String dest = parts[1]; // Destination vertex

            graph.putIfAbsent(src, new ArrayList<>());
            graph.get(src).add(dest);
        }
    }

    //--------------------------------------------------------
    // Method: getGraph()
    // Summary: Returns the graph constructed from the file.
    // Precondition: The graph has been initialized and loaded.
    // Postcondition: Returns the graph as a Map.
    //--------------------------------------------------------
    public Map<String, List<String>> getGraph() {
        return graph;
    }
}
