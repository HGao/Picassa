package expressions;

import model.Expression;
import model.Model;
import model.RGBColor;
import model.util.ColorCombinations;

public class CoordinateExpression extends Expression {
    private String myAxis;

    public CoordinateExpression() {
        super();
    }

    public CoordinateExpression(String axis) {
        myAxis = axis;
    }

    public RGBColor evaluate() {
        if (myAxis.equals("x"))
            return ColorCombinations.color(new RGBColor(Model.getEvalX()));
        if (myAxis.equals("y"))
            return ColorCombinations.color(new RGBColor(Model.getEvalY()));
        if (myAxis.equals("-x"))
            return ColorCombinations.color(new RGBColor(-Model.getEvalX()));
        else
            // myAxis.equals("-y")
            return ColorCombinations.color(new RGBColor(-Model.getEvalY()));
    }
}
