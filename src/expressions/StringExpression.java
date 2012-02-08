package expressions;

import java.util.Map;
import java.util.Stack;

import model.Expression;
import model.Parser;
import model.ParserException;
import model.RGBColor;

public class StringExpression extends Expression {
    private String myValue;
    private Map<String, Stack<Expression>> myLetExpressions;

    public StringExpression() {
        super();
    }

    public StringExpression(String value) {
        myValue = value;
    }

    public RGBColor evaluate() {
        myLetExpressions = Parser.getLetExpressions();
        if (!myLetExpressions.containsKey(myValue)) {
            throw new ParserException("Command " + myValue
                    + " is not recognized!",
                    ParserException.Type.UNKNOWN_COMMAND);
        } else
            return myLetExpressions.get(myValue).peek().evaluate();

    }

    public String getString() {
        return myValue;
    }
}