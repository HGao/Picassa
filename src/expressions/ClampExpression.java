package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class ClampExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public ClampExpression() {
        super();
    }

    public ClampExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.clamp(myOperands.get(0).evaluate());
    }

}
