package expressions;

import java.util.*;

import model.Expression;
import model.ParserException;
import model.RGBColor;
import model.util.ColorCombinations;

public class TangentExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public TangentExpression() {
        super();
    }

    public TangentExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        if (myOperands.size() != 1) {
            throw new ParserException("Unexpected number of operands",
                    ParserException.Type.INCORRECT_OPERANDS);
        }
        return ColorCombinations.tan(myOperands.get(0).evaluate());
    }

}
