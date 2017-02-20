package QuestionData;

/**
 * Created by synerzip on 20/2/17.
 */
public class Question {
    private Object question;
    private String type;

    public Question(Object question, String type) {
        this.question = question;
        this.type = type;
    }

    public Object getQuestion() {
        return this.question;
    }

    public String getType() {
        return this.type;
    }

}
