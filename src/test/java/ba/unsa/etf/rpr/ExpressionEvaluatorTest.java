package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for different input possibilities
 */
class ExpressionEvaluatorTest {

    @Test
     void evaluate1() {
        String str = "( 1.0 + ( ( 2.0 + 3.0 ) * ( 4.0 * 5.0 ) ) )";
        ExpressionEvaluator exp = new ExpressionEvaluator(str);
        Double rez = exp.evaluate(str);
        assertEquals(101.0, rez);
    }

    @Test
    void evaluate2(){
        String str = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        ExpressionEvaluator exp = new ExpressionEvaluator(str);
        Double rez = exp.evaluate(str);
        assertEquals(101.0, rez);
    }

    @Test
    void evaluate3(){
        String str = "( sqrt ( 25 ) + 10 )";
        ExpressionEvaluator exp = new ExpressionEvaluator(str);
        Double rez = exp.evaluate(str);
        assertEquals(15.0, rez);
    }

    @Test
    void evaluate4(){
        String str = "(sqrt(25)+10)";
        ExpressionEvaluator e = new ExpressionEvaluator(str);
        assertThrows(ValidateInputException.class, ()->{
            e.ValidateInput(str);
        });
    }

    @Test
    void ValidateInputIncorrect(){
        String str = new String("abc");
        ExpressionEvaluator e = new ExpressionEvaluator(str);
        assertThrows(ValidateInputException.class, ()->{
            e.ValidateInput(str);
        });
    }

}