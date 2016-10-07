package filters;

import baseStructures.simpleProcessor.SimpleProcessor;
import models.MyRGB;

/**
 * Created by vova on 06-Oct-16.
 */
public class ImageBinarization extends SimpleProcessor {
    private int max;

    public ImageBinarization(int max) {
        this.max = max;
    }

    @Override
    protected int simpleOperation(int rgb) {
        MyRGB myRGB = new MyRGB(rgb);
        if(myRGB.getBrightness() < max) return 0;
        else return new MyRGB(255, 255, 255).toInteger();
    }
}
