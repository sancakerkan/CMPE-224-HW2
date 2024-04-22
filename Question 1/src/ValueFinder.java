//-----------------------------------------------------
// Title: ValueFinder Utility Class
// Author: Erkan Sancak
// ID: 44293566706
// Section: 2
// Assignment: 2
// Description: This class provides a utility method to convert a string to an integer.
// It handles formatting errors and reports them to the user.
//-----------------------------------------------------

public class ValueFinder {

    //--------------------------------------------------------
    // Function: convertToInt(String input)
    // Summary: Converts a string input to an integer.
    // Precondition: input is a string that potentially represents an integer.
    // Postcondition: Returns the integer value of the string, or -1 if the string cannot be parsed.
    //--------------------------------------------------------
    public static int convertToInt(String input) {
        try {
            // Attempt to parse the input string as an integer
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            // Handle the case where input is not a valid integer
            System.out.println("Invalid integer format: " + input);
            return -1; // Return default error value indicating conversion failure
        }
    }
}
