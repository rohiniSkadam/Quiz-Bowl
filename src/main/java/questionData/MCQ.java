package questionData;

/**
 * Created by synerzip on 20/2/17.
 */
public class MCQ {
    private String question, answer;
    private String[] choice;
    private int points;

    public MCQ(String question, String answer, String[] choice, int points) {
        this.question = question;
        this.answer = answer;
        this.choice = choice;
        this.points = points;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String[] getChoice() {
        return this.choice;
    }

    public int getPoints() {
        return this.points;
    }

}
