package imageProcessing.simpleProcessor;

import imageProcessing.Processor;
import models.MyImage;

import java.awt.image.BufferedImage;

/**
 * Created by vova on 05-Oct-16.
 */
public abstract class SimpleTwoImageProcessor implements Processor {
    MyImage sourceImage;
    
    protected abstract int simpleOperation(int destinationRGB, int sourceRGB);

    public SimpleTwoImageProcessor(MyImage image) {
        this.sourceImage = image;
    }

    @Override
    public void process(MyImage destinationImage) {
        BufferedImage sourceBuffered = sourceImage.getBufferedImage();
        BufferedImage destinationBuffered = destinationImage.getBufferedImage();
        for(int i = 0; i < destinationBuffered.getWidth(); i++)
            for (int j = 0; j < destinationBuffered.getHeight(); j++) {
                destinationBuffered
                        .setRGB(i, j, simpleOperation(destinationBuffered.getRGB(i,j), sourceBuffered.getRGB(i,j)));
            }
    }
}
