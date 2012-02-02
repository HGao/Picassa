package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class LogarithmExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public LogarithmExpression() {
        super();
    }

    public LogarithmExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        return ColorCombinations.log(myOperands.get(0).evaluate());
    }

}
