package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class NegateExpression extends Expression {
    private ArrayList<Expression> myOperands;

    public NegateExpression() {
        super();
    }

    public NegateExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.neg(myOperands.get(0).evaluate());
    }

}
