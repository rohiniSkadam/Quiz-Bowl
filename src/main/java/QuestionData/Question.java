package QuestionData;

/**
 * Created by synerzip on 20/2/17.
 */
public class Question {
    private Object question;
    private String questionType;

    public Question(Object question, String type) {
        this.question = question;
        this.questionType = type;
    }

    public Object getQuestion() {
        return this.question;
    }

    public String getQuestionType() {
        return this.questionType;
    }
}
