package model;

import QuestionData.MCQ;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuestionMCQ extends Question {
    private String[] choice;
    private String answer;

    public QuestionMCQ(MCQ mcqObject) {
        super(mcqObject.getQuestion(), "MCQ");
        this.answer = mcqObject.getAnswer();
        this.choice = mcqObject.getChoice();
        this.setAnswers(this.answer);
    }
}
