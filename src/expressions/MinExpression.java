package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;

public class MinExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public MinExpression() {
        super();
    }

    public MinExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        double min = 1000;
        
        for (Expression op : myOperands)
        {
            double tempValue = averageRGB(op.evaluate());
            if (tempValue < min)
                min = tempValue;
        }
        return new RGBColor(min);
    }
    
    public double averageRGB(RGBColor color)
    {
        return (color.getRed() + color.getGreen() + color.getBlue()) / 3;
    }

}
