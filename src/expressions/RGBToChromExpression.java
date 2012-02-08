package expressions;

import java.util.*;

import model.Expression;
import model.ParserException;
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
        if (myOperands.size() != 1) {
            throw new ParserException("Unexpected number of operands",
                    ParserException.Type.INCORRECT_OPERANDS);
        }
        return ColorCombinations.rgbToY(myOperands.get(0).evaluate());
    }

}
