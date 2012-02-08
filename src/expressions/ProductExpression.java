package expressions;

import java.util.*;

import model.Expression;
import model.RGBColor;

public class ProductExpression extends Expression {

    private ArrayList<Expression> myOperands;

    public ProductExpression() {
        super();
    }

    public ProductExpression(String command, ArrayList<Expression> operands) {
        super(command, operands);
    }

    public RGBColor evaluate() {
        myOperands = getOperands();
        double prodRed = 0;
        double prodGreen = 0;
        double prodBlue = 0;
        
        for (Expression op : myOperands)
        {
            prodRed *= op.evaluate().getRed();
            prodGreen *= op.evaluate().getGreen();
            prodBlue *= op.evaluate().getBlue();
        }
        return new RGBColor(prodRed, prodGreen, prodBlue);
    }

}
