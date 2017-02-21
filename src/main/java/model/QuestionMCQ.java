package model;

import QuestionData.MCQ;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuestionMCQ extends Question {
    private String[] answer;
    private String answer1;

    public QuestionMCQ(MCQ object) {
        super(object.getQuestion(), "MCQ");
        this.answer1 = object.getAnswer();
        this.answer = object.getChoices();
        this.setAnswer(this.answer1);
    }
}
