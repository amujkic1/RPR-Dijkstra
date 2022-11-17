package ba.unsa.etf.rpr;

import java.util.Scanner;

/**
 * Main class
 * Function for parsing console input and its validation
 * @version 1.0
 */
public class App 
{
    /**
     * Main function
     * @param args
     */
    public static void main( String[] args )
    {
        String str = "( sqrt ( 25 ) + 10 )";
        ExpressionEvaluator exp = new ExpressionEvaluator(str);
        try {
            Double rez = exp.evaluate(str);
            System.out.println(rez);
        }catch(Exception e){
            System.out.println("Incorrect input!");
        }
    }
}
