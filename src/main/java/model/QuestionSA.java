package model;

import questionData.SA;

/**
 * Created by synerzip on 20/2/17.
 */
public class QuestionSA extends Question {

    public QuestionSA(SA saObject) {
        super(saObject.getQuestion(), "SA");
        this.setAnswers(saObject.getAnswer());
    }

}
