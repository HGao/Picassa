package parsers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.*;

public class ParenExpressionParser extends AbstractExpressionParser {
    private final Pattern EXPRESSION_BEGIN_REGEX = Pattern
            .compile("\\(([a-z]+)");

    private int myPosition;
    private String input;
    private static Map<String, Stack<Expression>> myLetExpressions;

    public Expression parse(String myInput, int myCurrentPosition, Parser ps) {
        myPosition = myCurrentPosition;
        input = myInput;
        myLetExpressions = Parser.getLetExpressions();

        Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(myInput);
        expMatcher.find(myPosition);
        String commandName = expMatcher.group(1);
        myPosition = expMatcher.end();

        ArrayList<Expression> operands = new ArrayList<Expression>();
        checkForErrors(myInput, commandName);

        while (true) {
            skipWhiteSpace();
            if (currentCharacter() == '(') {
                String exp = getEmbeddedExpression();
                operands.add(ps.makeExpression(exp));
                skipWhiteSpace();
            } else if (currentCharacter() != ')') {
                String exp = currentWord();
                operands.add(ps.makeExpression(exp));
                skipWhiteSpace();
            }
            if (currentCharacter() == ')') {
                myPosition++;
                Parser.refreshExpressions();
                Expression myExp = Parser.getPossibleExpressions().get(
                        commandName);
                myExp.setOperands(operands);
                return myExp;
            }
        }
    }

    private void checkForErrors(String myInput, String commandName) {
        if (Parser.getPossibleExpressions().get(commandName) == null) {
            throw new ParserException("Command " + commandName
                    + " is not recognized!",
                    ParserException.Type.UNKNOWN_COMMAND);
        }
        if (!isValidExpression(myInput)) {
            throw new ParserException("Imbalanced parentheses!",
                    ParserException.Type.BAD_SYNTAX);
        }
    }

    private void skipWhiteSpace() {
        while (notAtEndOfString() && Character.isWhitespace(currentCharacter())) {
            myPosition++;
        }
    }

    private String currentWord() {
        String ret = "";
        while (notAtEndOfString()) {
            if ((currentCharacter() == ')' || currentCharacter() == ' ')) {
                break;
            }
            ret = ret + currentCharacter();
            myPosition++;
        }
        return ret;
    }

    private char currentCharacter() {
        return input.charAt(myPosition);
    }

    private boolean notAtEndOfString() {
        return myPosition < input.length();
    }

    public int updatePosition() {
        return myPosition;
    }

    public String getEmbeddedExpression() {
        String ret = "";
        while (notAtEndOfString()) {
            if (currentCharacter() == ')' && isValidExpression(ret + ')')) {
                ret += ')';
                myPosition++;
                break;
            }
            ret = ret + currentCharacter();
            myPosition++;
        }
        return ret;
    }
    
    private boolean isValidExpression(String currentExpression)
 {
        int leftParen = 0;
        int rightParen = 0;

        for (int i = 0; i < currentExpression.length(); i++) {
            if (currentExpression.charAt(i) == ')')
                rightParen++;
            if (currentExpression.charAt(i) == '(')
                leftParen++;
        }
        return (leftParen == rightParen);
    }

    public static void addToMap(String letVariable, Expression letExpression) {
        if (!myLetExpressions.containsKey(letVariable)) {
            myLetExpressions.put(letVariable, new Stack<Expression>());
        }
        myLetExpressions.get(letVariable).push(letExpression);
    }

    public static void removeFromMap(String letVariable) {
        myLetExpressions.get(letVariable).pop();
        if (myLetExpressions.get(letVariable).size() == 0) {
            myLetExpressions.remove(letVariable);
        }
    }
    
}