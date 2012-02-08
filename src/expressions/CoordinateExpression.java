package expressions;

import model.Expression;
import model.Model;
import model.RGBColor;
import model.util.ColorCombinations;

public class CoordinateExpression extends Expression {
    private String myValue;

    public CoordinateExpression() {
        super();
    }

    public CoordinateExpression(String axis) {
        myValue = axis;
    }

    public RGBColor evaluate() {
        if (myValue.equals("x"))
            return ColorCombinations.color(new RGBColor(Model.getEvalX()));
        else if (myValue.equals("y"))
            return ColorCombinations.color(new RGBColor(Model.getEvalY()));
        else if (myValue.equals("-x"))
            return ColorCombinations.color(new RGBColor(-Model.getEvalX()));
        else if (myValue.equals("-y"))
            return ColorCombinations.color(new RGBColor(-Model.getEvalY()));
        
        return new RGBColor(0);
    }    
}
