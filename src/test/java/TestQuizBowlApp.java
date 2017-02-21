import model.Question;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by synerzip on 21/2/17.
 */
public class TestQuizBowlApp {
    Question question = new Question();

    @Before
    public void before() {
        question.setAnswers("E");
    }

    @Test
    public void testcheckAnswer() {
        boolean actual = question.checkAnswer("E", 10);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testCheckAnswerNegative() {
        boolean actual = question.checkAnswer("A", 10);
        boolean expected = false;
        assertEquals(actual, expected);
    }

}
