package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class TangentExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public TangentExpression() {
        super();
    }

    public TangentExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.tan(myOperands.get(0).evaluate());
    }

}
