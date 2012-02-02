package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class AbsoluteExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public AbsoluteExpression() {
        super();
    }

    public AbsoluteExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.abs(myOperands.get(0).evaluate());
    }

}
