package parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import expressions.*;
import model.*;

public class NumberExpressionParser extends AbstractExpressionParser {
    private final Pattern DOUBLE_REGEX = Pattern
            .compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
    private int myPosition;

    public Expression parse(String myInput, int myCurrentPosition, Parser ps) {
        Matcher doubleMatcher = DOUBLE_REGEX.matcher(myInput);
        doubleMatcher.find(myCurrentPosition);
        String numberMatch = myInput.substring(doubleMatcher.start(),
                doubleMatcher.end());
        myCurrentPosition = doubleMatcher.end();
        // this represents the color gray of the given intensity
        double value = Double.parseDouble(numberMatch);
        RGBColor gray = new RGBColor(value);
        myPosition = myCurrentPosition;
        return new NumberExpression(gray);
    }

    public int updatePosition() {
        return myPosition;
    }

}
