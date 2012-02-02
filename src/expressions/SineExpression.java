package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class SineExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public SineExpression() {
        super();
    }

    public SineExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.sin(myOperands.get(0).evaluate());
    }

}
