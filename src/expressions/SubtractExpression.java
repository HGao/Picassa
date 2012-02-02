package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class SubtractExpression extends Expression {
    private ArrayList<Expression> myOperands;

    public SubtractExpression() {
        super();
    }

    public SubtractExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.subtract(myOperands.get(0).evaluate(),
                myOperands.get(1).evaluate());
    }

}
