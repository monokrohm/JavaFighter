/**
 * This class is used to create and store the move menu
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class MoveSet
{
    private String[] move;

    /**
     * Default constructor which creates the object of the class MoveSet.
     */
    public MoveSet()
    {
        move = new String[5];
        move[0] = "Punch";
        move[1] = "Kick";
        move[2] = "Block";
        move[3] = "Special Move";
        move[4] = "Cheat";
    }

    /**
     * Non-Default constructor which creates the object of the class MoveSet.
     *
     * @param move    Accepts a string array containing the move choices.
     */
    public MoveSet(String[] move)
    {
        this.move = move;
    }

    /**
     * Display method to display the menu after each turn
     */
    public void displayMenu()
    {
        System.out.println("-Move List-");
        for(int i = 0; i < move.length; i++)
        {
            System.out.println((i + 1) + ". " + move[i]);
        }
    }

    /**
     * Method to return the number of elements in the move array
     *
     * @return    the number of elements in the move array
     */
    public int getArraySize()
    {
        return move.length;
    }

    /**
     * Method to return the array containg all the moves
     *
     * @return    The array containg all the moves
     */
    public String[] getMove()
    {
        return move;
    }

    /**
     * Method to return a specific element in the move array
     *
     * @param i    Accepts integer value of the index of the desired element
     * @return     The element at the specified index
     */
    public String getSpecificMove(int i)
    {
        if (i < move.length)
        {
            return move[i];
        }
        else
        {
            return null;
        }
    }

    /**
     * Method to replace the current move array
     *
     * @param move    Accepts string array of move list
     */
    public void setMove(String[] move)
    {
        this.move = move;
    }

    /**
     * Method to replace the index for the special move with the actual name of the special move selected
     *
     * @param position    Accepts integer value of the index to be changed
     * @param choice      Accepts integer value of the chosen special move
     * @param specArr     Accepts the string array containing the attributes of the selected special move
     */
    public void setSpecialMove(int position, int choice, String[] specArr)
    {
        if (position < move.length)
        {
            if (choice == 3)
            {
                move[position] = specArr[0] + " - Heals " + specArr[2] + " " + specArr[1];
            }
            else
            {
                move[position] = specArr[0] + " - Deals " + specArr[2] + " " + specArr[1];
            }
        }
    }

    /**
     * Method to replace the element at the specified index
     *
     * @param position    Accepts integer value of the index to be changed
     * @param moveName    Accepts string value of the new move name
     */
    public void setSpecificMove(int position, String moveName)
    {
        if (position < move.length)
        {
            move[position] = moveName;
        }
    }
}