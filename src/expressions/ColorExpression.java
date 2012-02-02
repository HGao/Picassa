package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class ColorExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public ColorExpression() {
        super();
    }

    public ColorExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.color(myOperands.get(0).evaluate(), myOperands
                .get(1).evaluate(), myOperands.get(2).evaluate());
    }

}
