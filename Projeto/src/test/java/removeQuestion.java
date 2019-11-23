import static org.junit.jupiter.api.Assertions.*;
import implementation.models.Question;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class removeQuestion {

    implementation.controller.Test sistema;
    Question q1;
    Question q2;

    @BeforeEach
    void init() {
        sistema = null;
        sistema = new  implementation.controller.Test();
        q1 = new QuestionYesNo("Q1", "Question1");
    }

    @Test // remover uma pergunta na posição 0 do Test
    public void testCase2() throws TestException {
        sistema.addQuestion(q1);
        assertEquals(true, sistema.removeQuestion(0));
    }

    @Test // remover uma pergunta na posição 1 do Test
    public void testCase3() throws TestException {
        sistema.addQuestion(q1);
        sistema.addQuestion(q1);
        assertEquals(true, sistema.removeQuestion(1));

    }

    @Test // remover uma pergunta na posição 98
    public void testCase4() throws TestException {
        int i;
        for (i = 0; i < 99; i++) {
            sistema.addQuestion(q1);
        }

        assertEquals(true, sistema.removeQuestion(98));
    }

    @Test // remover uma pergunta na posição 99
    public void testCase5() throws TestException {
        int i;
        for (i = 0; i < 100; i++) {
            sistema.addQuestion(q1);


        }

        assertEquals(true, sistema.removeQuestion(99));
    }

    @Test
    // Remover uma pergunta na posição 0 mas a posição está vazia
    public void testCase7() throws TestException{
        assertEquals(false, sistema.removeQuestion(0));
    }

    @Test
    // Remover uma pergunta na posição 0 mas a posição está vazia
    public void testCase8() throws TestException{
        sistema.addQuestion(q1);
        assertEquals(false, sistema.isComplete());
    }

}
