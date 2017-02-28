import questionData.MCQ;
import questionData.Question;
import questionData.SA;
import questionData.TF;
import controller.QuizController;
import model.Player;
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

    Logger logger = Logger.getLogger(QuizBowlApp.class);
    private int questionNum;
    private BufferedReader br;
    private QuizController quizController;
    private Player player;

    /**
     * Main method that start calling other methods
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        QuizBowlApp obj = new QuizBowlApp();
        obj.getInput();
    }

    /**
     * Function to take player information & input file name
     *
     * @throws Exception
     */
    void getInput() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("First Name : ");
        String fname = br.readLine().toUpperCase();
        System.out.print("Last Name : ");
        String lname = br.readLine().toUpperCase();
        System.out.print("Filename : ");
        String filename = br.readLine().toLowerCase();
        initializeGame(fname, lname, filename);
    }

    /**
     * Function to initialize the player information & to start the quiz bowl
     *
     * @param fname    - first name of player
     * @param lname    - last name of player
     * @param filename - name of file which contain questions & answers
     * @throws Exception
     */
    void initializeGame(String fname, String lname, String filename) throws Exception {
        player = new Player(lname, fname);
        quizController = new QuizController(filename);
        if (getNumberOfQuestions()) {
            quizBowl();
        }
    }

    /**
     * Function to ask user that how many question he/she want to attend.
     *
     * @return - return boolean flag
     * @throws IOException
     */
    private boolean getNumberOfQuestions() throws IOException {
        boolean flag = false;
        do {
            System.out.print("How many questions would you like (out of 3)?  : ");
            int number = Integer.parseInt(br.readLine());
            if (quizController.getQuestionCount() >= number) {
                questionNum = number;
                flag = false;
            } else {
                flag = true;
                System.out.println("Question count must be less than " + quizController.getQuestionCount());
            }
        } while (flag);
        return true;
    }

    /**
     * Function to start quiz & to call the display for player information
     *
     * @throws Exception
     */
    void quizBowl() throws Exception {
        final String sa = "SA";
        final String mc = "MC";
        final String tf = "TF";
        Question object;
        while (questionNum > 0) {
            object = quizController.getRandomQuestion();
            System.out.println(object.getQuestionType());
            switch (object.getQuestionType()) {
                case tf:
                    checkTFQuestion(object);
                    break;
                case mc:
                    checkMCQquestion(object);
                    break;
                case sa:
                    checkSAQuestion(object);
                    break;
            }
            questionNum--;
        }
        DisplayScore.showScore(player);
    }

    /**
     * Function to get the True False type of question
     *
     * @param object - object of type Question
     * @throws IOException
     */
    public void checkTFQuestion(Question object) throws IOException {
        logger.info("In True False Type Question");
        TF tfData = (TF) object.getQuestion();
        QuestionTF tfobj = new QuestionTF(tfData);
        System.out.println("Points : " + ((TF) object.getQuestion()).getPoint() + "\n" + tfobj.getQuestion());
        checkAnswerAndSetPoint(tfData.getPoint(), tfobj);
    }

    /**
     * Function to get the MCQ type of question & to display the choices
     *
     * @param object - object of type Question
     * @throws IOException
     */
    public void checkMCQquestion(Question object) throws IOException {
        logger.info("In MCQ Type Question");
        MCQ mcqData = (MCQ) object.getQuestion();
        model.Question mcqobj = new QuestionMCQ(mcqData);
        System.out.println("Points : " + ((MCQ) object.getQuestion()).getPoints() + "\n" + mcqobj.getQuestion());
        String[] choices = mcqData.getChoice();
        for (String val : choices)
            System.out.println(val);
        checkAnswerAndSetPoint(mcqData.getPoints(), mcqobj);
    }

    /**
     * Function to get the Short Answer type of question
     *
     * @param object - object of type Question
     * @throws IOException
     */
    public void checkSAQuestion(Question object) throws IOException {
        logger.info("In Short Answer Type Question");
        SA saData = (SA) object.getQuestion();
        model.Question saobj = new QuestionSA(saData);
        System.out.println("Points : " + ((SA) object.getQuestion()).getPoint() + "\n" + saobj.getQuestion());
        checkAnswerAndSetPoint(saData.getPoint(), saobj);
    }

    /**
     * Function to check whether the user input is correct or wrong also to check that user want to skip that question or not
     *
     * @param points      - Current Points of model.Player
     * @param questionObj - Object of type Question to call the checkAnswer method of Question class
     * @throws IOException
     */
    public void checkAnswerAndSetPoint(int points, model.Question questionObj) throws IOException {
        String answer;
        answer = br.readLine().toUpperCase();
        if (answer.equals("SKIP")) {
            System.out.println("You have elected to skip that question.");
            return;
        }
        if (questionObj.checkAnswer(answer, points)) {
            player.setScores(questionObj.getPoints());
            logger.debug("Points : " + player.getScores());
            System.out.println("Correct Answer.. \nPoints Gain : " + questionObj.getPoints() + "\n");
        } else {
            player.setScores(questionObj.getPoints());
            logger.debug("Points : " + player.getScores());
            System.out.println("Wrong Answer.. \nPoints Lose : " + questionObj.getPoints() + "\n");
        }
    }
}
