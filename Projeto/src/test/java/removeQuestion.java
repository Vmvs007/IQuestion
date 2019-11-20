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
    public void testCase1() throws TestException {
        sistema.addQuestion(q1);
        assertEquals(true,sistema.removeQuestion(0));
    }


}
