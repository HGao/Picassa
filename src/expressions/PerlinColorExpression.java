package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class PerlinColorExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public PerlinColorExpression() {
        super();
    }

    public PerlinColorExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.perlinColor(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
    }

}
