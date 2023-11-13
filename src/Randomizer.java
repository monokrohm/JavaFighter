/**
 * This class is used to randomize values
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class Randomizer
{
    /**
     * Default constructor which creates the object of the class Randomizer.
     *
     */
    public Randomizer()
    {
    }

    /**
     * Method to generate a random number within a range
     *
     * @param min    Accepts the minimum value of the range
     * @param max    Accepts the maximum value of the range
     * @return       The generated random integer
     */
    public int randomGen(int min, int max)
    {
        int range = (max - min) + 1;
        int random = (int)((Math.random() * (range) + min));
        return random;
    }

    /**
     * Method to randomly select a move from the move list
     *
     * @param specChoice    Accepts the chosen special move as an integer
     * @return              The randomly selected move for the turn as an integer
     */
    public int randomMove(int specChoice)
    {
        int percentage = 0;
        int choice = 0;

        do
        {
            percentage = randomGen(1, 100);
            if (percentage > 0 && percentage <= 25)
            {
                choice = 1;
            }
            else if (percentage > 25 && percentage <= 50)
            {
                choice = 2;
            }
            else if (percentage > 50 && percentage <= 70)
            {
                choice = 3;
            }
            else if (percentage > 70 && percentage <= 90)
            {
                if (specChoice == 4)
                {
                    choice = 0;
                }
                else
                {
                    choice = 4;
                }
            }
            else if (percentage > 90 && percentage <= 100)
            {
                choice = 5;
            }
        } while (choice == 0);

        return choice;
    }
}
