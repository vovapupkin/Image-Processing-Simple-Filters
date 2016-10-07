package filters;

import imageProcessing.simpleProcessor.SimpleProcessor;
import models.MyRGB;

/**
 * Created by vova on 06-Oct-16.
 */
public class BrightnessChange extends SimpleProcessor {
    double a;

    public BrightnessChange(double a) {
        this.a = a;
    }

    @Override
    protected int simpleOperation(int rgb) {
        MyRGB myRGB = new MyRGB(rgb);
        myRGB.setRed((int)(myRGB.getRed() + a));
        myRGB.setGreen((int)(myRGB.getGreen() + a));
        myRGB.setBlue((int)(myRGB.getBlue() + a));
        return myRGB.toInteger();
    }
}
