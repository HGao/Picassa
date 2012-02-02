package model;

import java.util.*;

import parsers.*;
import expressions.*;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser is
 * used http://en.wikipedia.org/wiki/Recursive_descent_parser
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser {

    // state of the parser
    private int myCurrentPosition;
    private String myInput;
    private static HashMap<String, Expression> myPossibleExpressions = new HashMap<String, Expression>();

    private ParserClassifier pc = new ParserClassifier();

    /**
     * Converts given string into expression tree.
     * 
     * @param input
     *            expression given in the language to be parsed
     * @return expression tree representing the given formula
     */
    public Expression makeExpression(String input) {
        myInput = input;
        myCurrentPosition = 0; // NEW LINE
        Expression result = parse();
        skipWhiteSpace();
        if (notAtEndOfString()) {
            throw new ParserException(
                    "Unexpected characters at end of the string: "
                          + myInput.substring(myCurrentPosition),
                    ParserException.Type.EXTRA_CHARACTERS);
        }
        return result;
    }

    private Expression parse() {
        refreshExpressions();
        AbstractExpressionParser correctParser = pc.getType(myInput,
                myCurrentPosition);
        Expression myExp = correctParser
                .parse(myInput, myCurrentPosition, this);
        myCurrentPosition = correctParser.updatePosition();
        return myExp;
    }

    private void skipWhiteSpace() {
        while (notAtEndOfString() && Character.isWhitespace(currentCharacter())) {
            myCurrentPosition++;
        }
    }

    private char currentCharacter() {
        return myInput.charAt(myCurrentPosition);
    }

    private boolean notAtEndOfString() {
        return myCurrentPosition < myInput.length();
    }

    public static Map<String, Expression> getPossibleExpressions() {
        return myPossibleExpressions;
    }

    public static void refreshExpressions() {
        {
            myPossibleExpressions.clear();
            myPossibleExpressions.put("plus", new AddExpression());
            myPossibleExpressions.put("minus", new SubtractExpression());
            myPossibleExpressions.put("mul", new MultiplyExpression());
            myPossibleExpressions.put("div", new DivisionExpression());
            myPossibleExpressions.put("mod", new ModuloExpression());
            myPossibleExpressions.put("exp", new ExponentExpression());
            myPossibleExpressions.put("neg", new NegateExpression());
            myPossibleExpressions.put("color", new ColorExpression());
            myPossibleExpressions.put("random", new RandomExpression());
            myPossibleExpressions.put("floor", new FloorExpression());
            myPossibleExpressions.put("ceil", new CeilingExpression());
            myPossibleExpressions.put("abs", new AbsoluteExpression());
            myPossibleExpressions.put("clamp", new ClampExpression());
            myPossibleExpressions.put("wrap", new WrapExpression());
            myPossibleExpressions.put("sin", new SineExpression());
            myPossibleExpressions.put("cos", new CosineExpression());
            myPossibleExpressions.put("tan", new TangentExpression());
            myPossibleExpressions.put("atan", new ArctangentExpression());
            myPossibleExpressions.put("log", new LogarithmExpression());
            myPossibleExpressions.put("rgbToYCrCb", new RGBToChromExpression());
            myPossibleExpressions.put("yCrCbtoRGB", new ChromToRGBExpression());
            myPossibleExpressions.put("perlinColor", new PerlinColorExpression());
            myPossibleExpressions.put("perlinBW", new PerlinBWExpression());
            myPossibleExpressions.put("let", new LetExpression());

        }
    }

}
