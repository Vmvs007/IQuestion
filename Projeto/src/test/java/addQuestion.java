import static org.junit.jupiter.api.Assertions.*;
import implementation.models.Question;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class addQuestion {

    implementation.controller.Test sistema;
    Question q1;
    Question q2;

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

    @Test// Adicionar uma pergunta inválida(nula) ao teste
    public void testCase2() throws TestException{
        assertThrows(TestException.class, () -> {sistema.addQuestion(q2);} );
    }

    @Test// Adicionar uma pergunta válida a um teste com 100 perguntas
    public void testCase3() throws TestException {
        int i;
        for(i = 0; i< 100;i++){
            sistema.addQuestion(q1);
        }
        assertEquals(false, sistema.addQuestion(q1));
    }

    @Test//Adicionar uma pergunta válida a um teste com 99 perguntas
    public void testCase4() throws TestException {
        int i;
        for (i=0;i<99;i++){
            sistema.addQuestion(q1);
        }

        assertEquals(true, sistema.addQuestion(q1));
    }

    @Test//Adicionar uma pergunta válida a um teste com 1 pergunta
    public void testCase5() throws TestException {

        sistema.addQuestion(q1);

        assertEquals(true, sistema.addQuestion(q1));
    }
}