package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class ExponentExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public ExponentExpression() {
        super();
    }

    public ExponentExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.exp(myOperands.get(0).evaluate(), myOperands
                .get(1).evaluate());
    }

}
