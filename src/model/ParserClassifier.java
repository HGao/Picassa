package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parsers.*;

public class ParserClassifier {

    private static final Pattern DOUBLE_REGEX = Pattern
            .compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
    private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
            .compile("\\(([a-zA-Z]+)");
    private static final Pattern COORDINATE = Pattern.compile("\\-?[xy]");

    public AbstractExpressionParser getType(String myInput,
            int myCurrentPosition) {
        Matcher coordMatcher = COORDINATE.matcher(myInput
                .substring(myCurrentPosition));
        Matcher doubleMatcher = DOUBLE_REGEX.matcher(myInput
                .substring(myCurrentPosition));
        Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(myInput
                .substring(myCurrentPosition));

        if (doubleMatcher.lookingAt()) {
            return new NumberExpressionParser();
        } else if (coordMatcher.lookingAt()) {
            return new CoordinateExpressionParser();
        } else if (expMatcher.lookingAt()) {
            return new ParenExpressionParser();
        }
        return new ParenExpressionParser();
    }
}
