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


public class answer {

    implementation.controller.Test sistema;
    Question q1;
    Question q2;

    @BeforeEach
    void init() {
        sistema = null;
        sistema = new  implementation.controller.Test();
        q1 = new QuestionNumeric("Q1", "Question1");
    }

    @Test //Teste com um valor diferente de [0-9] na answer
    void testCase1(){
        ((QuestionNumeric)q1).setCorrect_anwser(1);
          //assertEquals("",q1.answer("1"));
          assertThrows(QuestionException.class, () -> {q1.answer("Teste");});
    }

    @Test//Teste para verificar se atribuiu corretamente a user_answer
    void testCase2(){

        ((QuestionNumeric)q1).setCorrect_anwser(1);
        q1.answer("1");
        assertEquals(1.0,((QuestionNumeric) q1).getUser_answer());

    }

    @Test//Teste para verificar se meteu a question como Done
    void testCase3(){
        ((QuestionNumeric)q1).setCorrect_anwser(1);
        q1.answer("1");
        assertEquals(true,((QuestionNumeric) q1).isDone());
    }


}
