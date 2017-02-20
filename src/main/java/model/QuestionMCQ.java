package model;

import QuestionData.MCQ;
import org.apache.log4j.Logger;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuestionMCQ extends Question {
    private String[] answer;
    private String genAnswer;
    private String keys;

    public QuestionMCQ(MCQ object) {
        super(object.getQuestion(), "MCQ");
        this.keys = object.getAnswer();
        this.answer = object.getChoices();
        this.setAnswer(this.genAnswer);
    }

}
