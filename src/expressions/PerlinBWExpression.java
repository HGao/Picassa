package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class PerlinBWExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public PerlinBWExpression() {
        super();
    }

    public PerlinBWExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.perlinBW(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
    }

}
