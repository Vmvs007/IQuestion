import static org.junit.jupiter.api.Assertions.*;
import implementation.models.Question;
import implementation.models.QuestionMultipleChoice;
import implementation.models.QuestionNumeric;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;
import interfaces.models.IQuestion;
import interfaces.models.IQuestionYesNo;
import interfaces.controller.*;
import interfaces.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import interfaces.exceptions.QuestionException;


public class evaluateAnswer {

    implementation.controller.Test sistema;
    Question q1;
    Question q2;

    @BeforeEach
    void init() throws TestException {
        String[] opt = new String[]{"opt1","opt2","opt3"};
        q1 = new QuestionYesNo("Q1", "Question1");
        ((QuestionYesNo)q1).setCorrect_answer("yes");
    }


    @Test //Teste em que a user answer é null
    void testCase1(){

        assertThrows(QuestionException.class, () -> {q1.evaluateAnswer();});
    }

    @Test //Test em que a user answer é igual à correct answer
    void testCase2(){
        ((QuestionYesNo)q1).setUser_answer("yes");
        assertEquals(true,q1.evaluateAnswer());
    }

    @Test //Test em que a user answer é diferente à correct answer
    void testCase3(){
        ((QuestionYesNo)q1).setUser_answer("no");
        assertEquals(false,q1.evaluateAnswer());
    }
}
