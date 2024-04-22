import java.io.*;
import java.util.ArrayList;
import java.util.List;

//-----------------------------------------------------
// Title: FileRead Utility Class
// Author:	Erkan Sancak
// ID: 44293566706
// Section: 2
// Assignment: 2
// Description: This class contains a method to read lines from a file. It is used to read 
// the graph data from a text file for further processing by the DirectGraph class.
//-----------------------------------------------------

public class FileRead {

    //--------------------------------------------------------
    // Function: readLines(String filePath)
    // Summary: Reads all lines from a file and returns them as a list of strings.
    // Precondition: filePath must be a valid path to a readable text file.
    // Postcondition: Returns a list containing all lines of the file as strings.
    //--------------------------------------------------------
    public static List<String> readLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        // Create a BufferedReader to read the file line by line.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read lines until the end of the file is reached.
            while ((line = reader.readLine()) != null) {
                // Add each line to the list of lines.
                lines.add(line);
            }
        } // The BufferedReader is automatically closed here because of the try-with-resources statement.
        return lines;  // Return the list of lines read from the file.
    }
}
