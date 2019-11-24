import static org.junit.jupiter.api.Assertions.*;
import implementation.models.Question;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class incorrectAnswerPercentage {

    @BeforeEach
    void init() {
        sistema = null;
        sistema = new  implementation.controller.Test();
        q1 = new QuestionYesNo("Q1", "Question1");
    }

    @Test // Adicionar uma pergunta Válida ao teste
    public void testCase1() throws TestException {
        assertEquals(true,sistema.addQuestion(q1));
    }

}

