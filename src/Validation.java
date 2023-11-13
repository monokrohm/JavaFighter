/**
 * This class is used to check if the user input meets requirements 
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class Validation
{
    /**
     * Default constructor which creates the object of the class Validation.
     */
    public Validation()
    {
    }

    /**
     * Method to check if user input is blank
     *
     * @param input    Accepts string of input from user
     * @return         The boolean value for whether the input is blank or not
     */
    public boolean blank(String input)
    {
        boolean blank = true;
        if (input.length() > 0)
        {
            blank = false;
        }
        return blank;
    }

    /**
     * Method to check if user input is within a certain number of characters
     *
     * @param input    Accepts string of input from user
     * @param min      Accepts the minimum value of the range
     * @param max      Accepts the maximum value of the range
     * @return         The boolean value for whether the input is within range or not
     */
    public boolean withinLength(String input, int min, int max)
    {
        boolean within = false;
        if (input.length() >= min && input.length() <= max)
        {
            within = true;
        }
        return within;
    }
}