package expressions;

import java.util.*;

import model.Expression;
import model.ParserException;
import model.RGBColor;
import model.util.ColorCombinations;

public class AddExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public AddExpression() {
        super();
    }

    public AddExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        if (myOperands.size() != 2) {
            throw new ParserException("Unexpected number of operands",
                    ParserException.Type.INCORRECT_OPERANDS);
        }
        return ColorCombinations.add(myOperands.get(0).evaluate(), myOperands
                .get(1).evaluate());
    }

}
