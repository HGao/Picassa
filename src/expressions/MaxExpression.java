package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;

public class MaxExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public MaxExpression() {
        super();
    }

    public MaxExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        double max = -1000;
        
        for (Expression op : myOperands)
        {
            double tempValue = averageRGB(op.evaluate());
            if (tempValue > max)
                max = tempValue;
        }
        return new RGBColor(max);
    }
    
    public double averageRGB(RGBColor color)
    {
        return (color.getRed() + color.getGreen() + color.getBlue()) / 3;
    }

}
