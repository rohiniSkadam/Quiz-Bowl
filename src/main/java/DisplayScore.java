import org.apache.log4j.Logger;

/**
 * Created by synerzip on 20/2/17.
 */
public class DisplayScore {
    /**
     *  Function to display the Player Name & the total score of that player
     * @param player - Player object which contains overall information about player
     */
    public static void showScore(Player player) {
        Logger logger = Logger.getLogger(DisplayScore.class);
        logger.info("Player Name : " + player.getFname() + " Points : " + player.getPoints());
        System.out.println("\n" + player.getFname() + " " + player.getLname() + ", your game is over!" + "\nYou final score is " + player.getPoints() + " Points \nBetter luck next time!");
    }
}
