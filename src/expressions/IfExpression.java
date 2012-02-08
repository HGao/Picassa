package expressions;

import java.util.*;

import model.Expression;
import model.ParserException;
import model.RGBColor;

public class IfExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public IfExpression() {
        super();
    }

    public IfExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        
        if (myOperands.size() != 3) {
            throw new ParserException("Unexpected number of operands",
                    ParserException.Type.INCORRECT_OPERANDS);
        }
        
        if (getValue(myOperands.get(0).evaluate()) > 0)
        {
            return myOperands.get(1).evaluate();
        }
        else
            return myOperands.get(2).evaluate();
    }
    
    private double getValue(RGBColor color)
    {           
        return (color.getBlue() + color.getGreen() + color.getRed() / 3);
    }

}
