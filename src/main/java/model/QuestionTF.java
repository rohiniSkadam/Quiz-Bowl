package model;

import questionData.TF;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuestionTF extends Question {
    public QuestionTF(TF tfObject) {
        super(tfObject.getQuestion(), "TF");
        this.setAnswers(tfObject.getAnswer());
    }

}
