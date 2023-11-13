/**
 * This class is used to alter and store the attribute of the referee
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class Ref
{
    private boolean looking;

    /**
     * Default constructor which creates the object of the class Ref.
     *
     */
    public Ref()
    {
        looking = false;
    }

    /**
     * Non-Default constructor which creates the object of the class Ref.
     *
     * @param looking    Accepts the boolean value for whether the referee is looking or not
     */
    public Ref(boolean looking)
    {
        looking = false;
    }

    /**
     * Method to get the boolean value for whether the referee is looking or not
     *
     * @return    The boolean value for whether the referee is looking or not
     */
    public boolean getLooking()
    {
        return looking;
    }

    /**
     * Method to randomly set the looking status of the referee
     *
     */
    public void randomLook()
    {
        Randomizer random = new Randomizer();
        int randLook = random.randomGen(0, 1);
        if (randLook == 1)
        {
            looking = true;
        }
        else
        {
            looking = false;
        }
        //System.out.println(getLooking());
    }

    /**
     * Method to change the boolean value for whether the referee is looking or not
     *
     * @return    The boolean value for whether the referee is looking or not
     */
    public void setLooking(boolean looking)
    {
        this.looking = looking;
    }
}