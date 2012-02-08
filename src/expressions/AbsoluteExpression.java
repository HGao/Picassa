package expressions;

import java.util.*;

import model.Expression;
import model.ParserException;
import model.RGBColor;
import model.util.ColorCombinations;

public class AbsoluteExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public AbsoluteExpression() {
        super();
    }

    public AbsoluteExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        if (myOperands.size() != 1) {
            throw new ParserException("Unexpected number of operands",
                    ParserException.Type.INCORRECT_OPERANDS);
        }
        return ColorCombinations.abs(myOperands.get(0).evaluate());
    }

}
