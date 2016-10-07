package filters;

import baseStructures.simpleProcessor.SimpleProcessor;
import models.MyRGB;

/**
 * Created by vova on 06-Oct-16.
 */
public class BrightnessMultiplication extends SimpleProcessor {
    double a;

    public BrightnessMultiplication(double a) {
        if(a < 0) throw new IllegalArgumentException(" a < 0 ");
        this.a = a;
    }

    @Override
    protected int simpleOperation(int rgb) {
        MyRGB myRGB = new MyRGB(rgb);
        myRGB.setRed((int)(myRGB.getRed() * a));
        myRGB.setGreen((int)(myRGB.getGreen() * a));
        myRGB.setBlue((int)(myRGB.getBlue() * a));
        return myRGB.toInteger();
    }
}
