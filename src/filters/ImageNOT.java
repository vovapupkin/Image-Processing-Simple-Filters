package filters;

import imageProcessing.simpleProcessor.SimpleProcessor;
import models.MyRGB;

/**
 * Created by vova on 06-Oct-16.
 */
public class ImageNOT extends SimpleProcessor {

    @Override
    protected int simpleOperation(int rgb) {
        MyRGB myRGB = new MyRGB(rgb);
        myRGB.setRed(255 - myRGB.getRed());
        myRGB.setGreen(255 - myRGB.getGreen());
        myRGB.setBlue(255 - myRGB.getBlue());
        return myRGB.toInteger();
    }
}
