import QuestionData.MCQ;
import QuestionData.Question;
import QuestionData.SA;
import QuestionData.TF;
import controller.QuizController;
import model.QuestionMCQ;
import model.QuestionSA;
import model.QuestionTF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuizBowlApp {

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
        String fname = br.readLine();
        System.out.print("Last Name : ");
        String lname = br.readLine();
        System.out.print("Filename : ");
        String filename = br.readLine();
        player = new Player(lname, fname);
        filedriver = new QuizController(filename);
    }

    void quizBowl() throws Exception {
        Question object;
        String answer;
        while (questionnumbers-- > 0) {
            answer = null;
            object = filedriver.getRandomQuestion();
            System.out.println(object.getType());
            switch (object.getType()) {
                case tf:
                    TF tfstore = (TF) object.getQuestion();
                    QuestionTF tfobj = new QuestionTF(tfstore);
                    System.out.println(tfobj.getQuestion());
                    answer =br.readLine();
                    if (answer.equals("skip"))
                        break;
                    if (tfobj.checkAnswer(answer, tfstore.getPoints())) {
                        player.setPoints(tfobj.getPoints());
                        System.out.println("Correct Answer.. \nPoints Gain : "+tfobj.getPoints()+"\n");
                    } else {
                        player.setPoints(tfobj.getPoints());
                        System.out.println("Wrong Answer.. \nPoints Lose : "+tfobj.getPoints()+"\n");
                    }
                    object = null;
                    break;
                case mc:
                    MCQ mcqstore = (MCQ) object.getQuestion();
                    QuestionMCQ mcqobj = new QuestionMCQ(mcqstore);
                    System.out.println(mcqobj.getQuestion());
                    String[] choices = mcqstore.getChoices();
                    for (String val : choices)
                        System.out.println(val);
                    answer = br.readLine();
                    if (answer.equals("skip"))
                        break;
                    if (mcqobj.checkAnswer(answer, mcqstore.getPoints())) {
                        player.setPoints(mcqobj.getPoints());
                        System.out.println("Correct Answer.. \nPoints Gain : "+mcqobj.getPoints()+"\n");
                    } else {
                        player.setPoints(mcqobj.getPoints());
                        System.out.println("Wrong Answer.. \nPoints Lose : "+mcqobj.getPoints()+"\n");
                    }
                    object = null;
                    break;
                case sa:
                    SA sastore = (SA) object.getQuestion();
                    QuestionSA saobj = new QuestionSA(sastore);
                    System.out.println(saobj.getQuestion());
                    answer = br.readLine();;
                    if (answer.equals("skip"))
                        break;
                    if (saobj.checkAnswer(answer, sastore.getPoints())) {
                        player.setPoints(saobj.getPoints());
                        System.out.println("Correct Answer.. \nPoints Gain : "+saobj.getPoints()+"\n");
                    } else {
                        player.setPoints(saobj.getPoints());
                        System.out.println("Wrong Answer.. \nPoints Lose : "+saobj.getPoints()+"\n");

                    }
                    object = null;
                    break;
            }
        }
        DisplayScore.showScore(player);
    }

}
