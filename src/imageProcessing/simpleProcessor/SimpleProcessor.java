package imageProcessing.simpleProcessor;

import imageProcessing.Processor;
import models.MyImage;

import java.awt.image.BufferedImage;

/**
 * Created by vova on 05-Oct-16.
 */
public abstract class SimpleProcessor implements Processor {
    protected abstract int simpleOperation(int rgb);

    @Override
    public void process(MyImage image) {
        BufferedImage bufferedImage = image.getBufferedImage();
        for(int i = 0; i < bufferedImage.getWidth(); i++)
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                bufferedImage.setRGB(i, j, simpleOperation(bufferedImage.getRGB(i, j)));
            }
    }
}
