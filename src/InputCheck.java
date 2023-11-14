import java.util.Scanner;

/**
 * This class is used to check if the user input is of the correct data type
 * 
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class InputCheck {
    /**
     * Default constructor which creates the object of the class InputCheck.
     *
     */
    public InputCheck() {
    }

    /**
     * Checks if the user input can be returned as a string type
     *
     * @param prompt Accepts a string message asking for input
     * @return The input from the user as a string
     */
    public String strInput(String prompt) {
        Scanner console = new Scanner(System.in);
        System.out.println(prompt);
        return console.nextLine();
    }

    /**
     * Checks if the user input can be returned as an integer type
     *
     * @param prompt Accepts a string message asking for input
     * @return The input from the user as an integer
     */
    public int intInput(String prompt) {
        Scanner console = new Scanner(System.in);
        System.out.println(prompt);
        return Integer.parseInt(console.nextLine().trim());
    }
}