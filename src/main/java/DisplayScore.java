import org.apache.log4j.Logger;

/**
 * Created by synerzip on 20/2/17.
 */
public class DisplayScore {
    public static void showScore(Player player) {
        Logger logger=Logger.getLogger(DisplayScore.class);
        logger.info("Player Name : "+player.getFname()+"Points : "+player.getPoints());
        System.out.println("Game Over..\nPlayer Name : " + player.getFname()+" "+player.getLname() + "\nFinal Score : " + player.getPoints());
    }
}
