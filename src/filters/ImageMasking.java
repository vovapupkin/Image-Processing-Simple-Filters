package filters;

import imageProcessing.simpleProcessor.SimpleTwoImageProcessor;
import models.MyImage;
import models.MyRGB;

/**
 * Created by vova on 06-Oct-16.
 */
public class ImageMasking extends SimpleTwoImageProcessor {

    public ImageMasking(MyImage image) {
        super(image);
    }

    @Override
    protected int simpleOperation(int destinationRGB, int sourceRGB) {
        return new MyRGB(sourceRGB).getBrightness() != 0 ? destinationRGB : 0;
    }
}
