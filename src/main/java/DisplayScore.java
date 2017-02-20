/**
 * Created by synerzip on 20/2/17.
 */
public class DisplayScore {
    public static void showScore(Player player) {
        System.out.println(player.getPoints());
        System.out.println("Game Over..\nPlayer Name : " + player.getFname()+" "+player.getLname() + "\nFinal Score : " + player.getPoints());
    }
}
