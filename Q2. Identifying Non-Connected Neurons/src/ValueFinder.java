//-----------------------------------------------------
// Title: ValueFinder Class
// Author: Erkan Sancak
// ID: 44293566706
// Section: 2
// Assignment: 2
// Description: This class provides utility methods for converting string values to integers.
//-----------------------------------------------------

public class ValueFinder {
    
    //--------------------------------------------------------
    // Method: toInteger(String value)
    // Summary: Converts a string value to an integer.
    // Precondition: 'value' is a valid string representation of an integer.
    // Postcondition: Returns the integer value of the input string.
    //--------------------------------------------------------
    public static int toInteger(String value) {
        return Integer.parseInt(value);
    }
}
