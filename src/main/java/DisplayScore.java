import model.Player;
import org.apache.log4j.Logger;

/**
 * Created by synerzip on 20/2/17.
 */
public class DisplayScore {
    /**
     * Function to display the model.Player Name & the total score of that player
     *
     * @param playerObject - model.Player object which contains overall information about player
     */
    public static void showScore(Player playerObject) {
        Logger logger = Logger.getLogger(DisplayScore.class);
        logger.info("model.Player Name : " + playerObject.getFname() + " Points : " + playerObject.getScores());
        System.out.println("\n" + playerObject.getFname() + " " + playerObject.getLname() + ", your game is over!" + "\nYou final score is " + playerObject.getScores() + " Points \nBetter luck next time!");
    }
}
