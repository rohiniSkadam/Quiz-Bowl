package model;

/**
 * Created by synerzip on 20/2/17.
 */
public class Question {

    private String question, questionType, answers;
    private int points = 0;

    public Question(String question, String questionType) {
        this.question = question;
        this.questionType = questionType;
    }

    public Question() {
    }

    public Boolean checkAnswer(String answer, int points) {
        if (answer.equals(this.answers)) {
            this.points = points;
            return true;
        }
        this.points = -points;
        return false;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getPoints() {

        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getAnswers() {
        return this.answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

}
