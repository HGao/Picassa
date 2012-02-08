package expressions;

import java.util.ArrayList;

import parsers.ParenExpressionParser;
import model.Expression;
import model.ParserException;
import model.RGBColor;

public class LetExpression extends Expression {
    private String myValue;
    private ArrayList<Expression> myOperands;

    public LetExpression() {
        super();
    }

    public LetExpression(String value) {
        myValue = value;
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        
        if (myOperands.size() != 3) {
            throw new ParserException("Unexpected number of operands",
                    ParserException.Type.INCORRECT_OPERANDS);
        }

        Expression letVariable = myOperands.get(0);
        Expression letExpression = myOperands.get(1);
        Expression myExpression = myOperands.get(2);

        ParenExpressionParser.addToMap(letVariable.getString(), letExpression);

        RGBColor myExp = myExpression.evaluate();

        ParenExpressionParser.removeFromMap(letVariable.getString());
        return myExp;

    }

    public String getString() {
        return myValue;
    }
}