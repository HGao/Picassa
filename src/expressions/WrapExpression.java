package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class WrapExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public WrapExpression() {
        super();
    }

    public WrapExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.wrap(myOperands.get(0).evaluate());
    }

}
