import static org.junit.jupiter.api.Assertions.*;


import implementation.models.Question;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class addQuestion {

    implementation.controller.Test sistema;
    Question q1;

    @BeforeEach
    void init() {
        sistema = null;
        sistema = new  implementation.controller.Test();
        q1 = new QuestionYesNo("Q1", "Question1");
    }

    @Test
    public void testCase1() throws TestException {
        assertEquals(true,sistema.addQuestion(q1));
    }
}