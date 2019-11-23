
import static org.junit.jupiter.api.Assertions.*;
import implementation.models.Question;
import implementation.models.QuestionYesNo;
import implementation.controller.TestStatistics;
import interfaces.controller.ITestStatistics;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class incorrectAnswers {

    implementation.controller.Test sistema;
    Question q1;
    Question q2;
    TestStatistics statistics;
    @BeforeEach
    void init() {
        sistema = null;
        sistema = new  implementation.controller.Test();
        q1 = new QuestionYesNo("Q1", "Question1");
        q2= new QuestionYesNo("Q2","Questao2");
       ((QuestionYesNo) q1).setCorrect_answer("Yes");
        ((QuestionYesNo) q2).setCorrect_answer("Yes");
        statistics=(TestStatistics)sistema.getTestStatistics();
    }

    @Test // Test sem questões
    public void testCase1() throws TestException {
        assertEquals(0,statistics.incorrectAnswers().length);
    }

    @Test // Test com 2questões 1 correta e uma errada
    public void testCase2() throws TestException{
        ((QuestionYesNo) q1).setUser_answer("Yes");
        ((QuestionYesNo) q2).setUser_answer("No");
        sistema.addQuestion(q1);
        sistema.addQuestion(q2);

        assertEquals(1,statistics.incorrectAnswers().length);
    }

    @Test // Test com 2 questões e ambas erradas
    public void testCase3() throws TestException{
        ((QuestionYesNo) q1).setUser_answer("No");
        ((QuestionYesNo) q2).setUser_answer("No");
        sistema.addQuestion(q1);
        sistema.addQuestion(q2);

        assertEquals(2,statistics.incorrectAnswers().length);
    }

    @Test // Test com 2 questões e ambas certas
    public void testCase4() throws TestException{
        ((QuestionYesNo) q1).setUser_answer("Yes");
        ((QuestionYesNo) q2).setUser_answer("Yes");
        sistema.addQuestion(q1);
        sistema.addQuestion(q2);

        assertEquals(0,statistics.incorrectAnswers().length);
    }
}