package filters;

import baseStructures.simpleProcessor.SimpleTwoImageProcessor;
import models.MyImage;
import models.MyRGB;

/**
 * Created by vova on 06-Oct-16.
 */
public class ImageSubtraction extends SimpleTwoImageProcessor{
    double a = 1;

    public ImageSubtraction(MyImage image, double a) {
        super(image);
        if(a > 1) throw new  IllegalArgumentException("a > 1");
        if(a < 0) throw new  IllegalArgumentException("a < 0");
        this.a = a;
    }

    @Override
    protected int simpleOperation(int destinationRGB, int sourceRGB) {
        MyRGB destRGB = new MyRGB(destinationRGB);
        MyRGB sourRGB = new MyRGB(sourceRGB);
        destRGB.setRed((int)(a* destRGB.getRed() - (1-a) * sourRGB.getRed()));
        destRGB.setGreen((int)(a* destRGB.getGreen() - (1-a) * sourRGB.getGreen()));
        destRGB.setBlue((int)(a* destRGB.getBlue() - (1-a) * sourRGB.getBlue()));
        return destRGB.toInteger();
    }
}
