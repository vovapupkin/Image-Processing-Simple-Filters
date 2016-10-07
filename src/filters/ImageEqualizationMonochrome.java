package filters;

import baseStructures.Processor;
import models.MyImage;
import models.MyRGB;

import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * Created by vova on 06-Oct-16.
 */
public class ImageEqualizationMonochrome implements Processor {
    Double[] histogram = new Double[256];

    public ImageEqualizationMonochrome() {
        Arrays.fill(histogram, 0.0);
    }

    @Override
    public void process(MyImage destinationImage) {
        BufferedImage bufferedImage = destinationImage.getBufferedImage();
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                histogram[new MyRGB(bufferedImage.getRGB(i, j)).getBrightness()]++;
            }
        }
        for (int i = 0; i < histogram.length; i++) {
            histogram[i] /= (bufferedImage.getHeight() * bufferedImage.getWidth());
        }
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                Double y = 0.0;
                Integer brightness = new MyRGB(bufferedImage.getRGB(i, j)).getBrightness();
                for (int k = 0; k < brightness; k++) {
                    y += histogram[k];
                }
                bufferedImage.setRGB(i, j, new MyRGB((int)(y * 255), (int)(y * 255), (int)(y * 255)).toInteger());
            }
        }
    }
}
