package expressions;

import java.util.Map;
import java.util.Stack;

import model.Expression;
import model.Model;
import model.Parser;
import model.ParserException;
import model.RGBColor;
import model.util.ColorCombinations;

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
        
        if (myValue.equals("x"))
            return ColorCombinations.color(new RGBColor(Model.getEvalX()));
        else if (myValue.equals("y"))
            return ColorCombinations.color(new RGBColor(Model.getEvalY()));
        else if (myValue.equals("-x"))
            return ColorCombinations.color(new RGBColor(-Model.getEvalX()));
        else if (myValue.equals("-y"))
            return ColorCombinations.color(new RGBColor(-Model.getEvalY()));
        else if (myValue.equals("t"))
            return new RGBColor(Model.getTime()*2 - 1);

        
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