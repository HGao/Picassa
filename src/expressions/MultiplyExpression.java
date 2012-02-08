package expressions;

import java.util.*;

import model.Expression;
import model.ParserException;
import model.RGBColor;
import model.util.ColorCombinations;

public class MultiplyExpression extends Expression {
    private ArrayList<Expression> myOperands;

    public MultiplyExpression() {
        super();
    }

    public MultiplyExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        if (myOperands.size() != 2) {
            throw new ParserException("Unexpected number of operands",
                    ParserException.Type.INCORRECT_OPERANDS);
        }
        return ColorCombinations.multiply(myOperands.get(0).evaluate(),
                myOperands.get(1).evaluate());
    }

}
