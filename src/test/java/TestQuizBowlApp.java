import model.Question;
import model.QuestionTF;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by synerzip on 21/2/17.
 */
public class TestQuizBowlApp {
    Question q =new Question();

    @Before
    public void before() {
        q.setAnswer("E");
    }

    @Test
    public void testcheckAnswer() {
        boolean actual = q.checkAnswer("E", 10);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testCheckAnswerNegative() {
        boolean actual = q.checkAnswer("A", 10);
        boolean expected = false;
        assertEquals(actual, expected);
    }
}
