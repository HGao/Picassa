package parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import expressions.CoordinateExpression;
import model.*;

public class CoordinateExpressionParser extends AbstractExpressionParser {
    private final Pattern COORDINATE = Pattern.compile("\\-?[xy]");
    private int myPosition;

    public Expression parse(String myInput, int myCurrentPosition, Parser ps) {
        Matcher coordMatcher = COORDINATE.matcher(myInput);
        coordMatcher.find(myCurrentPosition);
        String coordMatch = myInput.substring(coordMatcher.start(),
                coordMatcher.end());
        myCurrentPosition = coordMatcher.end();
        myPosition = myCurrentPosition;
        return new CoordinateExpression(coordMatch);
    }

    public int updatePosition() {
        return myPosition;
    }
}
