package model;

import QuestionData.TF;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuestionTF extends Question {
    public QuestionTF(TF obj) {
        super(obj.getQuestion(), "TF");
        this.setAnswer(obj.getAnswer());
    }
}
