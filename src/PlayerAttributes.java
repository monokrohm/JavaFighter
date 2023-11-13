/**
 * This class is used to alter and store the attributes of the players
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class PlayerAttributes
{
    private String name;
    private int health;
    private boolean bribed;
    private int moveChoice;
    private int moveValue;
    private int specChoice;
    private int specValue;

    /**
     * Default constructor which creates the object of the class PlayerAttributes.
     */
    public PlayerAttributes()
    {
        name = "CPU";
        health = 100;
        bribed = false;
        moveChoice = 0;
        moveValue = 0;
        specChoice = 0;
        specValue = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class PlayerAttributes.
     *
     * @param name    Accepts string value of the player's name
     */
    public PlayerAttributes(String name)
    {
        this.name = name;
        health = 100;
        bribed = false;
        moveChoice = 0;
        moveValue = 0;
        specChoice = 0;
        specValue = 0;
    }

    /**
     * Method to return the hp of the player
     *
     * @return    The string value containg the name and hp of the player
     */
    public String display()
    {
        String stats = "Fighter " + getName() + " HP: " + getHealth();
        return stats;
    }

    /**
     * Accessor method to return a boolean based on whether the player chose the special move Bribed Referee or not
     *
     * @return    The boolean status on whether the referee has been bribed 
     */
    public boolean getBribed()
    {
        return bribed;
    }

    /**
     * Accessor method to return the health value of the player
     *
     * @return    The current status of the player's health
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Accessor method to return the chosen move for the turn
     *
     * @return    The chosen move for the turn as an integer
     */
    public int getMoveChoice()
    {
        return moveChoice;
    }

    /**
     * Accessor method to return the damage value of the chosen move for the turn
     *
     * @return    The damage value of the chosen move for the turn as an integer
     */
    public int getMoveValue()
    {
        return moveValue;
    }

    /**
     * Accessor method to return the player name
     *
     * @return    The player name as string
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor method to return the chosen special move chosen at the start
     *
     * @return    The chosen special move chosen at the start as an integer
     */
    public int getSpecChoice()
    {
        return specChoice;
    }

    /**
     * Accessor method to return the damage value of the chosen special move
     *
     * @return    The damage value of the chosen special move as an integer
     */
    public int getSpecValue()
    {
        return specValue;
    }

    /**
     * Mutator method to set the status of whether the referee has been bribed
     *
     * @param    bribed    Accepts bribed boolean status
     */
    public void setBribed(boolean bribed)
    {
        this.bribed = bribed;
    }

    /**
     * Mutator method to set the health of the player
     *
     * @param    health    Accepts integer value of the new value for health
     */
    public void setHealth(int health)
    {
        this.health = health;
    }

    /**
     * Mutator method to store the chosen move of the player for each turn
     *
     * @param    moveChoice    Accepts integer value of the chosen move
     */
    public void setMoveChoice(int moveChoice)
    {
        this.moveChoice = moveChoice;
    }

    /**
     * Mutator method to store the randomly chosen move
     *
     * @param    specChoice    Accepts integer value of the chosen special move to be checked in the randomizer
     */
    public void setMoveRandom(int specChoice)
    {
        Randomizer randM = new Randomizer();
        this.moveChoice = randM.randomMove(specChoice);
    }

    /**
     * Mutator method to store the damage value of the chosen move for the turn
     *
     * @param    moveValue    Accepts damage value of the chosen move for the turn as an integer
     */
    public void setMoveValue(int moveValue)
    {
        this.moveValue = moveValue;
    }

    /**
     * Mutator method to set the player name
     *
     * @param    name    Accepts string of the new name to be used
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Mutator method to set and store the value of the chosen special move
     *
     * @param    specChoice    Accepts the integer value of the chosen special move
     */
    public void setSpecChoice(int specChoice)
    {
        this.specChoice = specChoice;
    }

    /**
     * Mutator method to set and store the value of the special move chosen at random
     *
     * @param    min    Accepts the minimum value to be used for the randomizer range
     * @param    max    Accepts the maximum value to be used for the randomizer range
     */
    public void setSpecRandom(int min, int max)
    {
        Randomizer randS = new Randomizer();
        this.specChoice = randS.randomGen(min, max);
    }

    /**
     * Mutator method to set and store the damage value of the special move
     *
     * @param    specValue    Accepts the damage value of the chosen special move 
     */
    public void setSpecValue(int specValue)
    {
        this.specValue = specValue;
    }
}