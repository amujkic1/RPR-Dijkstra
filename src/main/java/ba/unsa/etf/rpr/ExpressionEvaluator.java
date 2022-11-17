package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Class for evaluating expressions of String type using Dijsktra's two stack method
 */
public class ExpressionEvaluator {
    private String str;
    public ExpressionEvaluator(String str) {
        this.str = str;
    }

    /**
     * @param str String that we want to evaluate
     * @throws ValidateInputException
     */
    public void ValidateInput(String str) throws ValidateInputException{
        char[] tokens = str.toCharArray();
        for(int i=0; i<str.length(); i++){
            if(tokens[i]!='0' && tokens[i]!='1' && tokens[i]!='2' && tokens[i]!='3' &&
               tokens[i]!='4' && tokens[i]!='5' && tokens[i]!='6' && tokens[i]!='7' && tokens[i]!='8'
                && tokens[i] != '9' && tokens[i]!=' ' && tokens[i]!='+' && tokens[i]!='-'
                && tokens[i]!='*' && tokens[i]!='/' && tokens[i]!='s' && tokens[i]!='q' && tokens[i]!='r'
                && tokens[i]!='t' && tokens[i]!=')' && tokens[i]!='(' && tokens[i]!='.'){
                throw new ValidateInputException("Incorrect arithmetic expression input");
            }
            if(!str.contains(" ")){
                throw new ValidateInputException("Incorrect arithmetic expression input");
            }
        }
    }

    /**
     * @param expression mathematical expression that needs evaluation
     * @return Result of all the oprations in the expression
     */
    Double evaluate(String expression) {

        ValidateInput(str);

        Stack<Double> values = new Stack<Double>();
        Stack<String> operators = new Stack<String>();

        String[] arrOfStrings = expression.split(" ");

        for (String s : arrOfStrings) {
            if (s.equals("(")) continue;
            else if (s.equals("+")) operators.push("+");
            else if (s.equals("-")) operators.push("-");
            else if (s.equals("*")) operators.push("*");
            else if (s.equals("/")) operators.push("/");
            else if(s.contains("sqrt")) operators.push("sqrt");
            else if (s.equals(")")) {
                String operator_ = operators.pop();
                Double val = values.pop();
                if (operator_.equals("+")) val = values.pop() + val;
                else if (operator_.equals("-")) val = values.pop() - val;
                else if (operator_.equals("*")) val = values.pop() * val;
                else if (operator_.equals("/")) val = values.pop() / val;
                else if (operator_.equals("sqrt")) val = Math.sqrt(val);
                values.push(val);
            }
            else if (s.equals(" ")) continue;
            else if (s.contains("0") || s.contains("1") || s.contains("2") || s.contains("3")
                    ||  s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9")) {
                StringBuffer sbuf = new StringBuffer();
                int i = 0;
                while (i < s.length()) {
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i)=='.')
                        sbuf.append(s.charAt(i));
                    i++;
                }
                values.push(Double.parseDouble(sbuf.toString()));
            }
            else throw new ValidateInputException("Incorrect input");
        }
        return values.pop();
    }
}
