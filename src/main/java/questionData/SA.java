package questionData;

/**
 * Created by synerzip on 20/2/17.
 */
public class SA {

    private String question, answer;
    private int point;

    public SA(String question, String answer, int points) {
        this.question = question;
        this.answer = answer;
        this.point = points;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public int getPoint() {
        return this.point;
    }
}
