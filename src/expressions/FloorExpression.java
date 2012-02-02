package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class FloorExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public FloorExpression() {
        super();
    }

    public FloorExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.floor(myOperands.get(0).evaluate());
    }

}
