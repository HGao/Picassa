package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class ArctangentExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public ArctangentExpression() {
        super();
    }

    public ArctangentExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.atan(myOperands.get(0).evaluate());
    }

}
