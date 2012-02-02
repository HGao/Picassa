package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class LetExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public LetExpression() {
        super();
    }

    public LetExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        Expression varname = myOperands.get(0);
        System.out.println(varname + " is the varname");
        Expression value = myOperands.get(1);
        System.out.println(value + " is the value");
        Expression exp = myOperands.get(2);
        System.out.println(exp + " is the expression");

        return ColorCombinations.ceil(myOperands.get(0).evaluate());
    }

}
