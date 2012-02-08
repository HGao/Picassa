package parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import expressions.StringExpression;
import model.*;

public class StringExpressionParser extends AbstractExpressionParser {
    private final Pattern STRING_REGEX = Pattern.compile("\\-?[a-zA-Z]+");
    private int myPosition;

    public Expression parse(String myInput, int myCurrentPosition, Parser ps) {
        Matcher stringMatcher = STRING_REGEX.matcher(myInput);
        stringMatcher.find(myCurrentPosition);
        String stringMatch = myInput.substring(stringMatcher.start(),
                stringMatcher.end());
        myCurrentPosition = stringMatcher.end();
        myPosition = myCurrentPosition;
        return new StringExpression(stringMatch);
    }

    public int updatePosition() {
        return myPosition;
    }

}
