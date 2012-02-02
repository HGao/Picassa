package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class CosineExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public CosineExpression() {
        super();
    }

    public CosineExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.cos(myOperands.get(0).evaluate());
    }

}
