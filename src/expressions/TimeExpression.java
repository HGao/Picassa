package expressions;

import model.Expression;
import model.Model;
import model.RGBColor;

public class TimeExpression extends Expression {

    public TimeExpression() {
        super();
    }

    public RGBColor evaluate() {
        
        return new RGBColor(Model.getTime()*2 - 1);
    }    
}
