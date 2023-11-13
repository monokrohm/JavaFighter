/**
 * This class is used to calculate and apply the move values to the players
 * 
 * @author Raymond Fung
 * @version ver 1.0.0
 */
public class DmgCalc {
    /**
     * Default constructor which creates the object of the class DmgCalc.
     */
    public DmgCalc() {
    }

    /**
     * Display method to display the outcome of each turn and returns the message as
     * a String
     *
     * @param attacker Accepts the object reference of PlayerAttributes of the
     *                 player attacking
     * @param defender Accepts the object reference of PlayerAttributes of the
     *                 player defending
     * @param move     Accepts the object reference of MoveSet containg information
     *                 of the move list
     * @param looking  Accepts the boolean value of whether the referee is looking
     *                 or not
     * @return The string value of the outcome of the turn
     */
    public String displayMovePrompt(PlayerAttributes attacker, PlayerAttributes defender, MoveSet move,
            boolean looking) {
        String prompt = "";
        switch (attacker.getMoveChoice()) {
            case 1:
            case 2: {
                if (attacker.getMoveChoice() == defender.getMoveChoice()) {
                    prompt = "Both fighters " + move.getSpecificMove(attacker.getMoveChoice() - 1)
                            + " each other dealing " + attacker.getMoveValue() + " damage each";
                    break;
                }
                if (defender.getMoveChoice() != 3) {
                    prompt = attacker.getName() + " used " + move.getSpecificMove(attacker.getMoveChoice() - 1)
                            + " to deal " + attacker.getMoveValue() + " damage";
                } else {
                    prompt = attacker.getName() + " used " + move.getSpecificMove(attacker.getMoveChoice() - 1)
                            + " to deal " + attacker.getMoveValue() + " damage but damage was halved because "
                            + defender.getName() + " was blocking";
                }
                break;
            }
            case 3: {
                if (attacker.getMoveChoice() == defender.getMoveChoice()) {
                    prompt = "Both fighters have taken a defensive stance";
                } else {
                    prompt = attacker.getName() + " has taken a defensive stance";
                }
                break;
            }
            case 4: {
                if (attacker.getSpecChoice() < 3 && defender.getMoveChoice() != 3) {
                    prompt = attacker.getName() + " used their special move to deal " + attacker.getMoveValue();
                } else if (attacker.getSpecChoice() < 3 && defender.getMoveChoice() == 3) {
                    prompt = attacker.getName() + " used their special move to deal " + attacker.getMoveValue()
                            + " damage but damage was halved because " + defender.getName() + " was blocking";
                } else if (attacker.getSpecChoice() == 3) {
                    if (attacker.getHealth() != 100) {
                        prompt = attacker.getName() + " used their special move to heal " + attacker.getMoveValue()
                                + " HP";
                    } else {
                        prompt = attacker.getName() + " used their special move to heal and is now at full HP";
                    }
                }
                break;
            }
            case 5: {
                if (attacker.getBribed() || !looking) {
                    if (defender.getMoveChoice() != 3) {
                        prompt = attacker.getName() + " decided to "
                                + move.getSpecificMove(attacker.getMoveChoice() - 1) + " and was successful in dealing "
                                + attacker.getMoveValue() + " damage";
                    } else {
                        prompt = attacker.getName() + " decided to "
                                + move.getSpecificMove(attacker.getMoveChoice() - 1)
                                + " and was successful but damage was halved because " + defender.getName()
                                + " was blocking";
                    }
                } else {
                    prompt = attacker.getName() + " was dealt 20 damage by the referee after being caught cheating";
                }
                break;
            }
        }
        System.out.println(prompt);
        return prompt;
    }

    /**
     * Method to calculate the values to apply to each player and applies them
     *
     * @param attacker Accepts the object reference of PlayerAttributes of the
     *                 player attacking
     * @param defender Accepts the object reference of PlayerAttributes of the
     *                 player defending
     * @param looking  Accepts the boolean value of whether the referee is looking
     *                 or not
     */
    public void calculateDmg(PlayerAttributes attacker, PlayerAttributes defender, boolean looking) {
        switch (attacker.getMoveChoice()) {
            case 1:
            case 2: {
                if (defender.getMoveChoice() != 3) {
                    defender.setHealth(defender.getHealth() - attacker.getMoveValue());
                    break;
                } else {
                    defender.setHealth(defender.getHealth() - (attacker.getMoveValue() / defender.getMoveValue()));
                    break;
                }
            }

            case 3: {
                break;
            }
            case 4: {
                if (attacker.getSpecChoice() < 3) {
                    if (defender.getMoveChoice() != 3) {
                        defender.setHealth(defender.getHealth() - attacker.getMoveValue());
                        break;
                    } else {
                        defender.setHealth(defender.getHealth() - (attacker.getMoveValue() / defender.getMoveValue()));
                        break;
                    }
                } else if (attacker.getSpecChoice() == 3) {
                    attacker.setHealth(attacker.getHealth() + attacker.getMoveValue());
                    if (attacker.getHealth() > 100) {
                        attacker.setHealth(100);
                    }
                    break;
                }
            }
            case 5: {
                if (attacker.getBribed() || !looking) {
                    if (defender.getMoveChoice() != 3) {
                        defender.setHealth(defender.getHealth() - attacker.getMoveValue());
                        break;
                    } else {
                        defender.setHealth(defender.getHealth() - (attacker.getMoveValue() / defender.getMoveValue()));
                        break;
                    }
                } else {
                    attacker.setHealth(attacker.getHealth() - 20);
                    break;
                }
            }
            default: {
                System.out.println("-Error...Try Again-");
                break;
            }
        }
    }
}