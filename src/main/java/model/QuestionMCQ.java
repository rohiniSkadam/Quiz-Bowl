package model;

import QuestionData.MCQ;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuestionMCQ extends Question {
    private String[] answer;
    private String genAnswer;

    public QuestionMCQ(MCQ object) {
        super(object.getQuestion(), "MCQ");
        this.genAnswer = object.getAnswer();
        this.answer = object.getChoices();
        this.setAnswer(this.genAnswer);
    }

}
