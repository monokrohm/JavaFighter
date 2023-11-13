/**
 * This class is used to alter the values of the special moves in the input file
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class SpecialMoves
{
    private String moveName;
    private String moveType;
    private int moveValue;

    /**
     * Default constructor which creates the object of the class SpecialMoves.
     */
    public SpecialMoves()
    {
        moveName = "name";
        moveType = "type";
        moveValue = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class Fighter.
     *
     * @param name     Accepts string value of the name of the special move
     * @param type     Accepts string value of the type of special move 
     * @param value    Accepts integer value of the damage from the special move
     */
    public SpecialMoves(String name, String type, int value)
    {
        moveName = name;
        moveType = type;
        moveValue = value;
    }

    /**
     * Display method to return each special move from the file as a string
     *
     * @return    The special move as a string from the input file
     */
    public String display()
    {
        return moveName + ", " + moveType + ", " + moveValue;
    }

    /**
     * Accessor method to get the name of the special move
     *
     * @return    The name of the current special move object as a string
     */
    public String getName()
    {
        return moveName;
    }

    /**
     * Accessor method to get the move type of the special move
     *
     * @return    The move type of the current special move object as a string
     */
    public String getType()
    {
        return moveType;
    }

    /**
     * Accessor method to get the damage value of the special move
     *
     * @return    The damage value of the current special move object as an integer
     */
    public int getValue()
    {
        return moveValue;
    }

    /**
     * Mutator method to set a new name to the current special move  
     *
     * @param name    String of the new name for the special move
     */
    public void setName(String name)
    {
        moveName = name;
    }

    /**
     * Mutator method to set a new move type to the current special move  
     *
     * @param type    String of the new move type for the special move
     */
    public void setType(String type)
    {
        moveType = type;
    }

    /**
     * Mutator method to set a new damage value to the current special move  
     *
     * @param value    Integer of the new damage value for the special move
     */
    public void setValue(int value)
    {
        moveValue = value;
    }
}