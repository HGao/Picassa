package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class MultiplyExpression extends Expression {
    private ArrayList<Expression> myOperands;

    public MultiplyExpression() {
        super();
    }

    public MultiplyExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.multiply(myOperands.get(0).evaluate(),
                myOperands.get(1).evaluate());
    }

}
