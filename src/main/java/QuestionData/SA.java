package QuestionData;

/**
 * Created by synerzip on 20/2/17.
 */
public class SA {

    private String question, answer;
    private int points;

    public SA(String question, String answer, int points) {
        this.question = question;
        this.answer = answer;
        this.points = points;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public int getPoints() {
        return this.points;
    }

}
