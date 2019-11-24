
import static org.junit.jupiter.api.Assertions.*;
import implementation.models.Question;
import implementation.models.QuestionYesNo;
import implementation.controller.TestStatistics;
import interfaces.controller.ITestStatistics;
import interfaces.exceptions.TestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class incorrectAnswersPercentage {

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

    }

    @Test // Test sem questões
    public void testCase1() throws TestException {
        statistics=(TestStatistics)sistema.getTestStatistics();
        assertEquals(0.0,statistics.incorrectAnswerPecentage());
    }

    @Test // Test com 2questões 1 correta e uma errada
    public void testCase2() throws TestException{
        ((QuestionYesNo) q1).setUser_answer("Yes");
        ((QuestionYesNo) q2).setUser_answer("No");
        sistema.addQuestion(q1);
        sistema.addQuestion(q2);
        statistics=(TestStatistics)sistema.getTestStatistics();
        assertEquals(0.5,statistics.incorrectAnswerPecentage());
    }

    @Test // Test com 2 questões e ambas erradas
    public void testCase3() throws TestException{
        ((QuestionYesNo) q1).setUser_answer("No");
        ((QuestionYesNo) q2).setUser_answer("No");
        sistema.addQuestion(q1);
        sistema.addQuestion(q2);
        statistics=(TestStatistics)sistema.getTestStatistics();
        assertEquals(1.0,statistics.incorrectAnswerPecentage());
    }

    @Test // Test com 2 questões e ambas certas
    public void testCase4() throws TestException{
        ((QuestionYesNo) q1).setUser_answer("Yes");
        ((QuestionYesNo) q2).setUser_answer("Yes");
        sistema.addQuestion(q1);
        sistema.addQuestion(q2);
        statistics=(TestStatistics)sistema.getTestStatistics();
        assertEquals(0.0,statistics.incorrectAnswerPecentage());
    }

    @Test //Test com 100 questoes, 1 certa e 99 erradas
    public void testCase5() throws TestException {
        int i;
        ((QuestionYesNo) q1).setUser_answer("No");
        ((QuestionYesNo) q2).setUser_answer("Yes");
        for(i=0;i<99;i++){
            sistema.addQuestion(q1);
        }
        sistema.addQuestion(q2);
        statistics=(TestStatistics)sistema.getTestStatistics();
        assertEquals(0.99,statistics.incorrectAnswerPecentage());
    }

    @Test //Test com 100 questoes, 99 certas e 1 errada
    public void testCase6() throws TestException {
        int i;
        ((QuestionYesNo) q1).setUser_answer("Yes");
        ((QuestionYesNo) q2).setUser_answer("No");
        for(i=0;i<99;i++){
            sistema.addQuestion(q1);
        }
        sistema.addQuestion(q2);
        statistics=(TestStatistics)sistema.getTestStatistics();
        assertEquals(0.01,statistics.incorrectAnswerPecentage());
    }

}