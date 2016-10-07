package filters;

import imageProcessing.simpleProcessor.SimpleProcessor;
import models.MyRGB;

/**
 * Created by vova on 06-Oct-16.
 */
public class ImageMonochrome extends SimpleProcessor {
    @Override
    protected int simpleOperation(int rgb) {
        MyRGB myRGB = new MyRGB(rgb);
        return new MyRGB(myRGB.getBrightness(), myRGB.getBrightness(), myRGB.getBrightness()).toInteger();
    }
}
