package model.util;

import model.RGBColor;

/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of ways to
 * combine colors, many may exist and we do not want to keep modifying the
 * RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorCombinations {
    /**
     * Combine two colors by adding their components.
     */
    public static RGBColor add(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() + right.getRed(), left.getGreen()
                + right.getGreen(), left.getBlue() + right.getBlue());
    }

    /**
     * Combine two colors by subtracting their components.
     */
    public static RGBColor subtract(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() - right.getRed(), left.getGreen()
                - right.getGreen(), left.getBlue() - right.getBlue());
    }

    /**
     * Combine two colors by multiplying their components.
     */
    public static RGBColor multiply(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() * right.getRed(), left.getGreen()
                * right.getGreen(), left.getBlue() * right.getBlue());
    }

    /**
     * Combine two colors by dividing their components.
     */
    public static RGBColor divide(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() / right.getRed(), left.getGreen()
                / right.getGreen(), left.getBlue() / right.getBlue());
    }

    /**
     * Combine two colors by modding their components.
     */
    public static RGBColor mod(RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() % right.getRed(), left.getGreen()
                % right.getGreen(), left.getBlue() % right.getBlue());
    }

    /**
     * Combine two colors by taking the value to an exponent.
     */
    public static RGBColor exp(RGBColor left, RGBColor right) {
        return new RGBColor(Math.pow(left.getRed(), right.getRed()), Math.pow(
                left.getGreen(), right.getGreen()), Math.pow(left.getBlue(),
                right.getBlue()));
    }

    /**
     * Combine two colors by taking the negative of the components.
     */
    public static RGBColor neg(RGBColor left) {
        return new RGBColor(-left.getRed(), -left.getGreen(), -left.getBlue());
    }

    /**
     * Combine three parameters into a new RGB color.
     */
    public static RGBColor color(RGBColor red, RGBColor green, RGBColor blue) {
        return new RGBColor(red.getRed(), green.getGreen(), blue.getBlue());
    }

    /**
     * Combine three parameters into a new RGB color.
     */
    public static RGBColor color(RGBColor value) {
        return new RGBColor(value.getRed(), value.getGreen(), value.getBlue());
    }
    
    /**
     * Floor three parameters into a new RGB color.
     */
    public static RGBColor floor(RGBColor value) {
        return new RGBColor(Math.floor(value.getRed()), Math.floor(value.getGreen()), Math.floor(value.getBlue()));
    }
    
    /**
     * Ceiling three parameters into a new RGB color.
     */
    public static RGBColor ceil(RGBColor value) {
        return new RGBColor(Math.ceil(value.getRed()), Math.ceil(value.getGreen()), Math.ceil(value.getBlue()));
    }
    
    /**
     * Absolute value of three parameters into a new RGB color.
     */
    public static RGBColor abs(RGBColor value) {
        return new RGBColor(Math.abs(value.getRed()), Math.abs(value.getGreen()), Math.abs(value.getBlue()));
    }
    
    /**
     * Clamp value of three parameters into a new RGB color.
     */
    public static RGBColor clamp(RGBColor value) {
        double myRed = clampComponent(value.getRed());
        double myGreen = clampComponent(value.getGreen());
        double myBlue = clampComponent(value.getBlue());
                
        return new RGBColor(myRed, myGreen, myBlue);
    }
    
    public static double clampComponent(double value)
    {
        if (value > 1) return 1; 
        else if (value < -1) return -1;
        return 0;

    }
    
    /**
     * Wrapped value of three parameters into a new RGB color.
     */
    public static RGBColor wrap(RGBColor value) {
        double myRed = wrapComponent(value.getRed());
        double myGreen = wrapComponent(value.getGreen());
        double myBlue = wrapComponent(value.getBlue());        

        return new RGBColor(myRed, myGreen, myBlue);
    }   
    
    public static double wrapComponent(double value) {
        if (value > 1){
            while (value > 1) value = value-2;
        }
        else if (value < -1){
            while (value < -1) value = value+2;
        }
        return value;
    }
    
    /**
     * Sine of three parameters into a new RGB color.
     */
    public static RGBColor sin(RGBColor value) {
        return new RGBColor(Math.sin(value.getRed()), Math.sin(value.getGreen()), Math.sin(value.getBlue()));
    }
    
    /**
     * Cosine of three parameters into a new RGB color.
     */
    public static RGBColor cos(RGBColor value) {
        return new RGBColor(Math.cos(value.getRed()), Math.cos(value.getGreen()), Math.cos(value.getBlue()));
    }
    
    /**
     * Tangent of three parameters into a new RGB color.
     */
    public static RGBColor tan(RGBColor value) {
        return new RGBColor(Math.tan(value.getRed()), Math.tan(value.getGreen()), Math.tan(value.getBlue()));
    }
    
    /**
     * Arctangent of three parameters into a new RGB color.
     */
    public static RGBColor atan(RGBColor value) {
        return new RGBColor(Math.atan(value.getRed()), Math.atan(value.getGreen()), Math.atan(value.getBlue()));
    }
    
    /**
     * Log base e of three parameters into a new RGB color.
     */
    public static RGBColor log(RGBColor value) {
        return new RGBColor(Math.log(value.getRed()), Math.log(value.getGreen()), Math.log(value.getBlue()));
    }
    
    /**
     * Color to luminance/chrominance
     */
    public static RGBColor rgbToY(RGBColor value) {
        return ColorModel.rgb2ycrcb(value);
    }
    
    /**
     * luminance/chrominance to color
     */
    public static RGBColor yToRGB(RGBColor value) {
        return ColorModel.ycrcb2rgb(value);
    }
    
    /**
     * perlin color random value from 2 values.
     */
    public static RGBColor perlinColor(RGBColor left, RGBColor right) {
        return PerlinNoise.colorNoise(left, right);
    }
    
    /**
     * perlin black/white color random value from 2 values.
     */
    public static RGBColor perlinBW(RGBColor left, RGBColor right) {
        return PerlinNoise.greyNoise(left, right);
    }
}
