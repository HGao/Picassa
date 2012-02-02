package parsers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.*;

public class ParenExpressionParser extends AbstractExpressionParser {
    private final Pattern EXPRESSION_BEGIN_REGEX = Pattern
            .compile("\\(([a-zA-Z]+)");

    private int myPosition;
    private String input;

    public Expression parse(String myInput, int myCurrentPosition, Parser ps) {
        myPosition = myCurrentPosition;
        input = myInput;

        Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(myInput);
        expMatcher.find(myPosition);
        String commandName = expMatcher.group(1);
        myPosition = expMatcher.end();

        ArrayList<Expression> operands = new ArrayList<Expression>();
        if (Parser.getPossibleExpressions().get(commandName) == null) {
            throw new ParserException("Command " + commandName
                    + " is not recognized!",
                    ParserException.Type.UNKNOWN_COMMAND);
        }

        while (true) {
            skipWhiteSpace();
            if (currentCharacter() == '(') {
                operands.add(ps.makeExpression(getEmbeddedExpression()));
                skipWhiteSpace();
            } else if (currentCharacter() != ')') {
                operands.add(ps.makeExpression(currentWord()));
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
        System.out.println(ret + " was the normal expression");
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
        System.out.println(ret + " was the embedded expression");
        return ret;
    }

    private boolean isValidExpression(String currentExpression)
    {
        int leftParen = 0;
        int rightParen = 0;
        
        for (int i = 0; i < currentExpression.length(); i++)
        {
            if (currentExpression.charAt(i)==')') rightParen++;
            if (currentExpression.charAt(i)=='(') leftParen++;
        }
        return (leftParen == rightParen);
    }
}
