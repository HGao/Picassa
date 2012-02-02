package expressions;

import model.Expression;
import model.RGBColor;

public class NumberExpression extends Expression {
    private RGBColor myValue;

    public NumberExpression() {
        super();
    }

    public NumberExpression(RGBColor gray) {
        myValue = gray;
    }

    public RGBColor evaluate() {
        return myValue;
    }
}
