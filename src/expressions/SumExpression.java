package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;

public class SumExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public SumExpression() {
        super();
    }

    public SumExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        double sumRed = 0;
        double sumGreen = 0;
        double sumBlue = 0;
        
        for (Expression op : myOperands)
        {
            sumRed += op.evaluate().getRed();
            sumGreen += op.evaluate().getGreen();
            sumBlue += op.evaluate().getBlue();
        }
        return new RGBColor(sumRed, sumGreen, sumBlue);
    }

}
