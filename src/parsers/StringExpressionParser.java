package parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import expressions.CoordinateExpression;
import expressions.StringExpression;
import expressions.TimeExpression;
import model.*;

public class StringExpressionParser extends AbstractExpressionParser {
    private final Pattern TIME = Pattern.compile("\\-?[t]+");
    private final Pattern COORDINATE = Pattern.compile("\\-?[xy]+");
    private final Pattern STRING_REGEX = Pattern.compile("\\-?[a-zA-Z]+");
    private int myPosition;

    public Expression parse(String myInput, int myCurrentPosition, Parser ps) {
        Matcher stringMatcher = STRING_REGEX.matcher(myInput);
        Matcher coordMatcher = COORDINATE.matcher(myInput);
        Matcher timeMatcher = TIME.matcher(myInput);
        if (timeMatcher.find(myCurrentPosition)){
            myCurrentPosition = timeMatcher.end();
            myPosition = myCurrentPosition;
            return new TimeExpression();
        }else if (coordMatcher.find(myCurrentPosition)) {
            String coordMatch = myInput.substring(coordMatcher.start(),
                    coordMatcher.end());
            myCurrentPosition = coordMatcher.end();
            myPosition = myCurrentPosition;
            return new CoordinateExpression(coordMatch);
        } else if (stringMatcher.find(myCurrentPosition)) {
            String stringMatch = myInput.substring(stringMatcher.start(),
                    stringMatcher.end());
            myCurrentPosition = stringMatcher.end();
            myPosition = myCurrentPosition;
            return new StringExpression(stringMatch);
        }

        return null;
    }

    public int updatePosition() {
        return myPosition;
    }

}
