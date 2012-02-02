package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class ChromToRGBExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public ChromToRGBExpression() {
        super();
    }

    public ChromToRGBExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.yToRGB(myOperands.get(0).evaluate());
    }

}
