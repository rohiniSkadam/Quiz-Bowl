package model;

import QuestionData.SA;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuestionSA extends Question {

    public QuestionSA(SA object) {
        super(object.getQuestion(), "SA");
        this.setAnswer(object.getAnswer());
    }
}
