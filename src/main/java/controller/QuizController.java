package controller;

import questionData.MCQ;
import questionData.Question;
import questionData.SA;
import questionData.TF;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuizController {

    public ArrayList<Question> questionObj = new ArrayList<>();
    public int[] randomNum = null;
    Logger logger = Logger.getLogger(QuizController.class);

    /**
     * Function to Open the File
     *
     * @param filename - Name of file
     * @throws Exception
     */
    public void getFile(String filename) throws Exception
    {
        File file = new File(getClass().getClassLoader().getResource(filename + ".txt").getFile());
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        questionObj = openFile(br);
        logger.info("File Opened Successfully");
        randomNum = new int[questionObj.size()];
    }

    /**
     * Function to get count of questions
     *
     * @return - integer count of question
     */
    public int getQuestionCount() {
        return this.questionObj.size();
    }

    /**
     * Function to fech the questions randomely
     *
     * @return - random questions
     */
    public Question getRandomQuestion() {
        Random random = new Random();
        Question question = null;
        int flag = 0;
        do {
            int temp = random.nextInt(questionObj.size());
            if (randomNum[temp] == 0) {
                question = questionObj.get(temp);
                randomNum[temp] = 1;
                break;
            } else
                flag = 1;
        } while (flag == 1);
        return question;
    }

    /**
     * Function to fech the data from file & insert it into the respective type of Storage classes
     *
     * @param br -bufferReader to read the lines
     * @return - Arraylist of type question which contains objects of respective type of question
     * @throws Exception
     */
    public ArrayList<Question> openFile(BufferedReader br) throws Exception {
        ArrayList<Question> data = new ArrayList<>();
        final String TrueFalse= "TF";
        final String MultipleChoice = "MC";
        final String ShortAnswer = "SA";

        int number = Integer.parseInt(br.readLine());
        while (number > 0) {
            String[] choice = br.readLine().split(" ");
            int points = Integer.parseInt(choice[1]);
            String question = br.readLine();
            logger.info("Question : " + question);
            Question questionObject;
            switch (choice[0]) {
                case TrueFalse:
                    String answertf = br.readLine().toUpperCase();
                    logger.info("Answer : " + answertf);
                    TF tfData = new TF(question, answertf, points);
                    questionObject = new Question(tfData, TrueFalse);
                    data.add(questionObject);
                    break;
                case MultipleChoice:
                    int ChoiceNumber = Integer.parseInt(br.readLine());
                    String[] choices = new String[ChoiceNumber];
                    int i = 0;
                    char ch = 'A';
                    while (ChoiceNumber > 0) {
                        choices[i] = ch + ") " + br.readLine();
                        ch++; i++;
                        ChoiceNumber--;
                    }
                    String answerMCQ = br.readLine().toUpperCase();
                    logger.info("Answer : " + answerMCQ);
                    MCQ mcqData = new MCQ(question, answerMCQ, choices, points);
                    questionObject = new Question(mcqData, MultipleChoice);
                    data.add(questionObject);
                    break;
                case ShortAnswer:
                    String answerSA = br.readLine().toUpperCase();
                    logger.info("Answer : " + answerSA);
                    SA saData = new SA(question, answerSA, points);
                    questionObject = new Question(saData, ShortAnswer);
                    data.add(questionObject);
                    break;
                default:
                    System.out.println("Wrong Choice.");
            }
            number--;
        }
        return data;
    }
}