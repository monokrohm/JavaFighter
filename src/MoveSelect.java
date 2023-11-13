/**
 * This class is used to decides the player damage value for the turn based on the chosen move
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class MoveSelect
{
    /**
     * Default constructor which creates the object of the class MoveSelect.
     */
    public MoveSelect()
    {
    }

    /**
     * Decides the player damage value for the turn based on the chosen move
     *
     * @param    select       Accepts integer value of the move selected for the turn
     * @param    specValue    Accepts integer value of the damage value of the chosen special move
     * @return                The integer value of the damage to be dealt for the turn
     */
    public int actionValue(int select, int specValue)
    {
        int value = 0;
        switch (select)
        {
            case 1:
            {
                value = 10;
                break;
            }
            case 2:
            {
                value = 20;
                break;
            }
            case 3:
            {
                value = 2;
                break;
            }
            case 4:
            {
                value = specValue;
                break;
            }
            case 5:
            {
                value = 40;
                break;
            }
            default:
            {
                System.out.println("-Unknown Selection...Try Again-");
                break;
            }
        }
        return value;
    }
}
