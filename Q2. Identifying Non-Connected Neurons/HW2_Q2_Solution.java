import java.util.*;
import java.io.*;

//-----------------------------------------------------
// Title: HW2_Q2_Solution Class
// Author: Erkan Sancak
// ID: 44293566706
// Section: 2
// Assignment: 2
// Description: This class is the main solution for HW2 Question 2. It reads graph data from a file,
//              identifies non-connected neurons, and prints all relevant graph information including
//              vertices, edges, and results for non-connected neurons.
//-----------------------------------------------------

public class HW2_Q2_Solution {
    private static Map<String, List<String>> graph;  // Stores the adjacency list representation of the graph
    private static Set<String> allNeurons;           // Stores all unique neurons identified in the graph
    private static List<String> nonConnectedNeurons; // List of neurons that do not have outgoing connections

    //--------------------------------------------------------
    // Method: main(String[] args)
    // Summary: Entry point for the program. Manages file reading and initiates processing.
    // Precondition: None.
    // Postcondition: The graph data is read, processed, and results are printed.
    //--------------------------------------------------------
    public static void main(String[] args) {
        try {
            FileRead fileReader = new FileRead("HW2_Q2_text.txt");
            graph = fileReader.getGraph();
            allNeurons = findAllNeurons(graph);
            nonConnectedNeurons = findNonConnectedNeurons();
            printResults();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------------------
    // Method: findAllNeurons(Map<String, List<String>> graph)
    // Summary: Collects all unique neurons from the graph.
    // Precondition: 'graph' is not null.
    // Postcondition: Returns a set of all unique neurons.
    //--------------------------------------------------------
    private static Set<String> findAllNeurons(Map<String, List<String>> graph) {
        Set<String> allNeurons = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            allNeurons.add(entry.getKey());
            allNeurons.addAll(entry.getValue());
        }
        return allNeurons;
    }

    //--------------------------------------------------------
    // Method: findNonConnectedNeurons()
    // Summary: Identifies neurons that are destinations but not sources in the graph.
    // Precondition: 'graph' must be populated.
    // Postcondition: Returns a list of non-connected neurons.
    //--------------------------------------------------------
    private static List<String> findNonConnectedNeurons() {
        Set<String> sources = graph.keySet();
        Set<String> destinations = new HashSet<>();
        for (List<String> values : graph.values()) {
            destinations.addAll(values);
        }
        destinations.removeAll(sources);
        return new ArrayList<>(destinations);
    }

    //--------------------------------------------------------
    // Method: printResults()
    // Summary: Prints the graph data including vertices, edges, and non-connected neurons.
    // Precondition: 'graph', 'allNeurons', and 'nonConnectedNeurons' are properly initialized.
    // Postcondition: Graph data is printed to the console.
    //--------------------------------------------------------
    private static void printResults() {
        System.out.println("V=" + allNeurons.size());
        System.out.println("E=" + graph.values().stream().mapToInt(List::size).sum());

        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            String source = entry.getKey().equals("00") ? "0" : entry.getKey();
            for (String dest : entry.getValue()) {
                System.out.println(source + " " + dest);
            }
        }

        System.out.println("Result is");
        for (String neuron : nonConnectedNeurons) {
            System.out.println("0 " + neuron);
        }
    }
}
