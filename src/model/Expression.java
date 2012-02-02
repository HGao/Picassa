package model;

import java.util.*;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical functions and the
 * leaves represent constant values.
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 */
public abstract class Expression {
    private RGBColor myValue;
    private String myCommand;
    private ArrayList<Expression> myOperands;

    public Expression() {
        myValue = null;
        myCommand = null;
        myOperands = null;
    }

    /**
     * Create expression representing the given constant value
     */
    public Expression(RGBColor value) {
        myValue = value;
        myCommand = null;
        myOperands = null;
    }

    public Expression(String axis) {
        myCommand = axis;
        myOperands = null;
        myValue = null;
    }

    /**
     *Create expression representing the given operation with one
     * sub-expression.
     */
    public Expression(String command, ArrayList<Expression> operands) {
        myCommand = command;
        myValue = null;
        myOperands = operands;
    }

    /**
     * @return string representation of expression
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        if (myCommand == null) {
            result.append(myValue);
        } else {
            result.append("(");
            result.append(" " + myCommand + " ");
            result.append(myOperands.get(0).toString());
            result.append(myOperands.get(1).toString());
            result.append(")");
        }
        return result.toString();
    }

    public void setOperands(ArrayList<Expression> operands) {
        myOperands = operands;
    }

    public ArrayList<Expression> getOperands() {
        return myOperands;
    }

    public abstract RGBColor evaluate();

}
