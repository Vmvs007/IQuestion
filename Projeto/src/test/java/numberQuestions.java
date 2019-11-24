import static org.junit.jupiter.api.Assertions.*;
import implementation.models.Question;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class numberQuestions {

    implementation.controller.Test sistema;
    Question q1;
    Question q2;

    @BeforeEach
    void init() throws TestException {
        sistema = null;
        sistema = new  implementation.controller.Test();
        q1 = new QuestionYesNo("Q1", "Question1");

    }

    @Test// Numero de questões quando o teste não tem questões
    void testCase1() {

        assertEquals(0,sistema.numberQuestions());
    }

    @Test// Numero de questões quando o teste tem 1 questão
    void testCase2() throws TestException {
        sistema.addQuestion(q1);
        assertEquals(1,sistema.numberQuestions());
    }

    @Test// Numero de questões quando o teste tem 99 questões
    void testCase3() throws TestException {
        int i;
        for(i=0;i<99;i++) {
            sistema.addQuestion(q1);
        }
        assertEquals(99,sistema.numberQuestions());
    }

    @Test// Numero de questões quando o teste tem 100 questões
    void testCase4() throws TestException {
        int i;
        for(i=0;i<100;i++) {
            sistema.addQuestion(q1);
        }
        assertEquals(100,sistema.numberQuestions());
    }


}
