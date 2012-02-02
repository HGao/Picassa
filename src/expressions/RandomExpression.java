package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;

public class RandomExpression extends Expression {

    public RandomExpression() {
        super();
    }

    public RandomExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        return new RGBColor(Math.random(), Math.random(), Math.random());
    }

}
