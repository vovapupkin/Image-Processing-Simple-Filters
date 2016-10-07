package filters;

import baseStructures.simpleProcessor.SimpleTwoImageProcessor;
import models.MyImage;
import models.MyRGB;

/**
 * Created by vova on 06-Oct-16.
 */
public class ImageOR extends SimpleTwoImageProcessor {

    public ImageOR(MyImage image) {
        super(image);
    }

    @Override
    protected int simpleOperation(int destinationRGB, int sourceRGB) {
        return new MyRGB(destinationRGB).getBrightness() != 0
                || new MyRGB(sourceRGB).getBrightness() != 0 ? new MyRGB(255, 255, 255).toInteger() : new MyRGB(0, 0, 0).toInteger();
    }
}
