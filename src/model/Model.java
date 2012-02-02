package model;

import java.awt.Dimension;

/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 */
public class Model {
    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;

    private static double evalX;
    private static double evalY;

    /**
     * Evaluate an expression for each point in the image.
     */
    public Pixmap evaluate(String input, Dimension size) {
        Pixmap result = new Pixmap(size);
        // create expression to evaluate just once
        Expression toEval = new Parser().makeExpression(input);
        // evaluate at each pixel
        for (int imageY = 0; imageY < size.height; imageY++) {
            setEvalY(imageToDomainScale(imageY, size.height));
            for (int imageX = 0; imageX < size.width; imageX++) {
                setEvalX(imageToDomainScale(imageX, size.width));
                result
                        .setColor(imageX, imageY, toEval.evaluate()
                                .toJavaColor());
            }
        }
        return result;
    }

    /**
     * Convert from image space to domain space.
     */
    protected double imageToDomainScale(int value, int bounds) {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return ((double) value / bounds) * range + DOMAIN_MIN;
    }

    public static void setEvalX(double evalX) {
        Model.evalX = evalX;
    }

    public static double getEvalX() {
        return evalX;
    }

    public static void setEvalY(double evalY) {
        Model.evalY = evalY;
    }

    public static double getEvalY() {
        return evalY;
    }

}