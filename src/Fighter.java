import java.util.ArrayList;

/**
 * This class is used to operate the game
 * 
 * @author Raymond Fung
 * @version ver 1.0.0
 */

public class Fighter {
    public final String fileN = "specialmoves.txt";
    public final String outputN = "outcome.txt";
    private ArrayList<String> movePrompts;
    private ArrayList<String> special;

    /**
     * Default constructor which creates the object of the class Fighter.
     *
     */
    public Fighter() {
        movePrompts = new ArrayList<>();
        special = new ArrayList<>();
    }

    /**
     * Non-Default constructor which creates the object of the class Fighter.
     *
     * @param movePrompts Accepts the history log of all the moves executed as a
     *                    String ArrayList.
     * @param special     Accepts the list of all the special moves as a String
     *                    ArrayList.
     */
    public Fighter(ArrayList<String> movePrompts, ArrayList<String> special) {
        this.movePrompts = movePrompts;
        this.special = special;
    }

    /**
     * Display method to display the history log of all the moves executed
     */
    public void displayLog() {
        System.out.println("-Log-");
        for (int i = 0; i < movePrompts.size(); i++) {
            System.out.println(movePrompts.get(i));
        }
    }

    /**
     * Display method to display the special ArrayList as a menu
     */
    public void displaySpecMenu() {
        System.out.println("-Special Moves-");
        for (int i = 0; i < special.size(); i++) {
            System.out.println((i + 1) + ". " + special.get(i));
        }
    }

    /**
     * Display method to display the name and hp of the players and returns it as a
     * string
     *
     * @param playerStat  Accepts player 1's status as a string
     * @param player2Stat Accepts player 2's status as a string
     * @return Returns the players' status as a string
     */
    public String displayStats(String playerStat, String player2Stat) {
        String stats = playerStat + "  |  " + player2Stat;
        System.out.println(stats);
        return stats;
    }

    /**
     * Display method to display the outcome of the game
     *
     * @param loser  Accepts the loser's name as a string
     * @param winner Accepts the winner's name as a string
     * @param hp     Accepts the winner's remaining hp
     */
    public void displayWinner(String loser, String winner, int hp) {
        String str = "A Winner Has Been Decided!!!";
        System.out.println(str);
        movePrompts.add(str);
        str = winner + " Has Conquered " + loser + " With " + hp + " HP Remaining!";
        System.out.println(str);
        movePrompts.add(str);
        System.out.println("The Fight Has Been Logged...");
        System.out.println("Thanks For Playing!");
    }

    /**
     * Accessor method to get the history log of all the moves executed
     *
     * @return The history log of all the moves executed as a String ArrayList.
     */
    public ArrayList<String> getMovePrompts() {
        return movePrompts;
    }

    /**
     * Accessor method to get list of all the special moves
     *
     * @return The list of all the special moves as a String ArrayList.
     */
    public ArrayList<String> getSpecial() {
        return special;
    }

    /**
     * Main method which begins the program execution
     * 
     * @param args An array of string passed in as command line parameters
     */
    public static void main(String[] args) {
        Fighter fight = new Fighter();
        System.out.println(String.format("\t-Welcome to Java Fighter-"));
        System.out.println("Defeat Your Opponent And Rise To The Top!");
        System.out.println("Thrown Into This Corrupt Tournament,");
        System.out.println("Will You Be Able To Overcome Your Opponent In An All Out Brawl!?\n");

        fight.start();
        // fight.displayLog();
    }

    /**
     * Reads the specialmoves.txt file for the list of special moves and adds the
     * list to the special ArrayList
     */
    public void readFile() {
        try {
            FileIO data = new FileIO(fileN);
            String[] specIn = data.readFile().split("\\n");

            for (int i = 0; i < specIn.length; i++) {
                String[] specialIn = specIn[i].split(",");
                SpecialMoves specMoves = new SpecialMoves(specialIn[0], specialIn[1], Integer.parseInt(specialIn[2]));

                special.add(specMoves.display());
            }
        } catch (Exception e) {
            System.out.println("-Error Reading File-");
        }
    }

    /**
     * Mutator method to set a new move history log to the current one
     *
     * @param movePrompts String ArrayList of all the moves executed
     */
    public void setMovePrompts(ArrayList<String> movePrompts) {
        this.movePrompts = movePrompts;
    }

    /**
     * Mutator method to set a new list of special moves to the current one
     *
     * @param special String ArrayList of all the special moves
     */
    public void setSpecial(ArrayList<String> special) {
        this.special = special;
    }

    /**
     * Execution instructions to play the game
     */
    public void start() {
        readFile();
        InputCheck input = new InputCheck();
        Validation valid = new Validation();
        boolean cont = false;

        String name = "";
        do {
            name = input.strInput("Enter Your Name Challenger");
            if (!valid.blank(name) && valid.withinLength(name, 3, 12)) {
                cont = true;
            } else {
                System.out.println("-Name Must Must Be At Least 3 Characters Long & No More Than 12-");
            }
        } while (!cont);
        cont = false;

        PlayerAttributes player = new PlayerAttributes(name);

        String mChoice = "0";
        MoveSet move = new MoveSet();
        do {
            displaySpecMenu();
            try {
                mChoice = input.strInput("Select Your Special Move");
                if (!valid.blank(mChoice)) {
                    player.setSpecChoice(Integer.parseInt(mChoice));
                    if (player.getSpecChoice() > 0 && player.getSpecChoice() <= special.size()) {
                        if (player.getSpecChoice() == 4) {
                            move.setSpecificMove(3, "[Bribed Referee Is Active]");
                            player.setHealth(player.getHealth() - 50);
                            player.setBribed(true);
                        } else {
                            String[] specArr = special.get(player.getSpecChoice() - 1).split(", ");
                            player.setSpecValue(Integer.parseInt(specArr[2]));
                            move.setSpecialMove(3, player.getSpecChoice(), specArr);
                        }
                        cont = true;
                    } else {
                        System.out.println("-Invalid Input...Please Enter A Number That Is Displayed-");
                    }
                }
            } catch (Exception e) {
                System.out.println("-Invalid Input...Please Enter A Number-");
            }
        } while (!cont);

        PlayerAttributes player2 = new PlayerAttributes();
        player2.setSpecRandom(1, special.size());
        if (player2.getSpecChoice() == 4) {
            player2.setHealth(player.getHealth() - 50);
            player2.setBribed(true);
        } else {
            String[] specArr = special.get(player2.getSpecChoice() - 1).split(", ");
            player2.setSpecValue(Integer.parseInt(specArr[2]));
        }

        Ref ref = new Ref();

        MoveSelect mSelect = new MoveSelect();
        DmgCalc dmg = new DmgCalc();
        String dmgPrompt = "";
        int temp = player.getMoveChoice();
        do {
            temp = player.getMoveChoice();
            dmgPrompt = displayStats(player.display(), player2.display());
            move.displayMenu();
            try {
                mChoice = input.strInput("Select Your Move");
                if (!valid.blank(mChoice)) {
                    player.setMoveChoice(Integer.parseInt(mChoice));
                    if (player.getMoveChoice() > 0 && player.getMoveChoice() <= move.getArraySize()
                            && player.getMoveChoice() != temp) {
                        if (player.getBribed() && player.getMoveChoice() == 4) {
                            System.out.println("-Bribed Referee Is Currently In Effect, Pick Another Move-");
                            continue;
                        } else {
                            player.setMoveValue(mSelect.actionValue(player.getMoveChoice(), player.getSpecValue()));
                            player2.setMoveRandom(player2.getSpecChoice());
                            player2.setMoveValue(mSelect.actionValue(player2.getMoveChoice(), player2.getSpecValue()));
                            movePrompts.add(dmgPrompt);
                            // System.out.println(player2.getSpecChoice() +" "+ player2.getSpecValue() +" "+
                            // player2.getMoveChoice() +" "+ player2.getMoveValue()); //check cpu
                        }
                    } else if (player.getMoveChoice() == temp) {
                        System.out.println(
                                "-Same Move Cannot Be Used Twice In A Row...Please Enter A Different Number That Is Displayed-");
                        continue;
                    } else {
                        System.out.println("-Invalid Input...Please Enter A Number That Is Displayed-");
                        continue;
                    }
                } else {
                    System.out.println("-Invalid Input...Please Enter A Number That Is Displayed-");
                }
                ref.randomLook();
                dmg.calculateDmg(player, player2, ref.getLooking());
                dmgPrompt = dmg.displayMovePrompt(player, player2, move, ref.getLooking());
                movePrompts.add(dmgPrompt);

                if (player.getHealth() > 0 && player2.getHealth() > 0) {
                    dmg.calculateDmg(player2, player, ref.getLooking());
                }

                if (player2.getHealth() > 0) {
                    if (player.getMoveChoice() != player2.getMoveChoice() && player2.getMoveChoice() != 3) {
                        dmgPrompt = dmg.displayMovePrompt(player2, player, move, ref.getLooking());
                        movePrompts.add(dmgPrompt);
                    } else if (player.getMoveChoice() == 4 && player2.getMoveChoice() == 4) {
                        dmgPrompt = dmg.displayMovePrompt(player2, player, move, ref.getLooking());
                        movePrompts.add(dmgPrompt);
                    } else if (player.getMoveChoice() == 4 && player.getSpecChoice() > 2 && player2.getMoveChoice() == 3
                            || player.getMoveChoice() == 5 && player.getSpecChoice() != 4
                                    && player2.getMoveChoice() == 3 && ref.getLooking()) {
                        dmgPrompt = dmg.displayMovePrompt(player2, player, move, ref.getLooking());
                        movePrompts.add(dmgPrompt);
                    }
                }
            } catch (Exception e) {
                System.out.println("-Invalid Input...Please Enter A Number-");
            }
        } while (player.getHealth() > 0 && player2.getHealth() > 0);

        if (player.getHealth() <= 0) {
            displayWinner(player.getName(), player2.getName(), player2.getHealth());
        } else {
            displayWinner(player2.getName(), player.getName(), player.getHealth());
        }

        writeFile();
    }

    /**
     * Writes the movePrompts ArrayList to a file named outcome.txt
     */
    public void writeFile() {
        StringBuffer str = new StringBuffer("");
        FileIO io = new FileIO(outputN);

        for (int i = 0; i < movePrompts.size(); i++) {
            str.append(movePrompts.get(i));
            str.append("\n");
        }
        io.writeFile(str.toString());
    }
}
