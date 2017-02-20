import QuestionData.MCQ;
import QuestionData.Question;
import QuestionData.SA;
import QuestionData.TF;
import controller.QuizController;
import model.QuestionMCQ;
import model.QuestionSA;
import model.QuestionTF;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuizBowlApp {

    Logger logger=Logger.getLogger(QuizBowlApp.class);
    public final static String sa = "SA";
    public final static String mc = "MC";
    public final static String tf = "TF";
    private int questionnumbers;
    private BufferedReader br;
    private QuizController filedriver;
    private Player player;

    public static void main(String[] args) throws Exception {
        QuizBowlApp obj = new QuizBowlApp();
        obj.getInput();
        if (obj.getNumberOfQuestions()) {
            obj.quizBowl();
        }
    }

    private boolean getNumberOfQuestions() throws IOException {
        boolean flag = false;
        do {
            System.out.print("How many questions would you like (out of 3)?  : ");
            int number = Integer.parseInt(br.readLine());
            if (filedriver.getQuestionCount() >= number && number > 0) {
                questionnumbers = number;
                flag = false;
            } else {
                flag = true;
            }
        } while (flag);
        return true;
    }

    void getInput() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("First Name : ");
        String fname = br.readLine().toUpperCase();
        System.out.print("Last Name : ");
        String lname = br.readLine().toUpperCase();
        System.out.print("Filename : ");
        String filename = br.readLine().toLowerCase();
        player = new Player(lname, fname);
        filedriver = new QuizController(filename);
    }

    void quizBowl() throws Exception {
        Question object;
        String answer;
        while (questionnumbers-- > 0) {
            object = filedriver.getRandomQuestion();
            System.out.println(object.getType());
            switch (object.getType()) {
                case tf:
                    logger.info("In True False Type Question");
                    TF tfstore = (TF) object.getQuestion();
                    QuestionTF tfobj = new QuestionTF(tfstore);
                    System.out.println(tfobj.getQuestion());
                    answer =br.readLine().toUpperCase();
                    if (answer.equals("SKIP"))
                        break;
                    if (tfobj.checkAnswer(answer, tfstore.getPoints())) {
                        player.setPoints(tfobj.getPoints());
                        logger.debug("TF Points : "+player.getPoints());
                        System.out.println("Correct Answer.. \nPoints Gain : "+tfobj.getPoints()+"\n");
                    } else {
                        player.setPoints(tfobj.getPoints());
                        logger.debug("TF Points : "+player.getPoints());
                        System.out.println("Wrong Answer.. \nPoints Lose : "+tfobj.getPoints()+"\n");
                    }
                    break;
                case mc:
                    logger.info("In MCQ Type Question");
                    MCQ mcqstore = (MCQ) object.getQuestion();
                    QuestionMCQ mcqobj = new QuestionMCQ(mcqstore);
                    System.out.println(mcqobj.getQuestion());
                    String[] choices = mcqstore.getChoices();
                    for (String val : choices)
                        System.out.println(val);
                    answer = br.readLine().toUpperCase();
                    if (answer.equals("SKIP"))
                        break;
                    if (mcqobj.checkAnswer(answer, mcqstore.getPoints())) {
                        player.setPoints(mcqobj.getPoints());
                        logger.debug("MCQ Points : "+player.getPoints());
                        System.out.println("Correct Answer.. \nPoints Gain : "+mcqobj.getPoints()+"\n");
                    } else {
                        player.setPoints(mcqobj.getPoints());
                        logger.debug("MCQ Points : "+player.getPoints());
                        System.out.println("Wrong Answer.. \nPoints Lose : "+mcqobj.getPoints()+"\n");
                    }
                    break;
                case sa:
                    logger.info("In Short Answer Type Question");
                    SA sastore = (SA) object.getQuestion();
                    QuestionSA saobj = new QuestionSA(sastore);
                    System.out.println(saobj.getQuestion());
                    answer = br.readLine().toUpperCase();
                    if (answer.equals("SKIP"))
                        break;
                    if (saobj.checkAnswer(answer, sastore.getPoints())) {
                        player.setPoints(saobj.getPoints());
                        logger.debug("SA Points : "+player.getPoints());
                        System.out.println("Correct Answer.. \nPoints Gain : "+saobj.getPoints()+"\n");
                    } else {
                        player.setPoints(saobj.getPoints());
                        logger.debug("SA Points : "+player.getPoints());
                        System.out.println("Wrong Answer.. \nPoints Lose : "+saobj.getPoints()+"\n");
                    }
                    break;
            }
        }
        DisplayScore.showScore(player);
    }

}
