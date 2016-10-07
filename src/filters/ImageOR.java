package filters;

import imageProcessing.simpleProcessor.SimpleTwoImageProcessor;
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
        return destinationRGB != 0 || sourceRGB != 0 ? new MyRGB(255, 255, 255).toInteger() : 0;
    }
}
