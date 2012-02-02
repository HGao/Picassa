package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class RGBToChromExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public RGBToChromExpression() {
        super();
    }

    public RGBToChromExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.rgbToY(myOperands.get(0).evaluate());
    }

}
