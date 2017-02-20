package model;

import org.apache.log4j.Logger;

/**
 * Created by synerzip on 20/2/17.
 */
public abstract class Question {

    private String question, questionType, answer;
    private int points = 0;

    public Question(String question, String questionType) {
        this.question = question;
        this.questionType = questionType;
    }

    public final Boolean checkAnswer(String answer, int points) {
        if (answer.equals(this.answer)) {
            this.points = points;
            return true;
        }
        this.points = -points;
        return false;
    }

    public final String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public final int getPoints() {

        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

}
