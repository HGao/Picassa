package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class DivisionExpression extends Expression {
    private ArrayList<Expression> myOperands;

    public DivisionExpression() {
        super();
    }

    public DivisionExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.divide(myOperands.get(0).evaluate(),
                myOperands.get(1).evaluate());
    }

}
