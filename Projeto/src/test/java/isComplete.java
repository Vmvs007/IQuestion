import static org.junit.jupiter.api.Assertions.*;
import implementation.models.Question;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class isComplete {

    implementation.controller.Test sistema;
    Question q1;
    Question q2;

    @BeforeEach
    void init() throws TestException {
        sistema = null;
        sistema = new  implementation.controller.Test();
        q1 = new QuestionYesNo("Q1", "Question1");

    }

    @Test // Pergunta q1 não está feita
    public void testCase1() throws TestException {
        sistema.addQuestion(q1);
        assertEquals(false,sistema.isComplete());
    }

    @Test // Pergunta q1 está feita
    public void testCase2() throws TestException{
        sistema.addQuestion(q1);
        sistema.getQuestion(0).setDone(true);
        assertEquals(true,sistema.isComplete());
    }


}