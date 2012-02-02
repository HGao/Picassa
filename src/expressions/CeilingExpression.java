package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class CeilingExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public CeilingExpression() {
        super();
    }

    public CeilingExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.ceil(myOperands.get(0).evaluate());
    }

}
