package filters;

import imageProcessing.Processor;
import imageProcessing.simpleProcessor.SimpleProcessor;
import models.MyImage;
import models.MyRGB;

import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * Created by vova on 06-Oct-16.
 */
public class SawtoothBrightnessSlice extends SimpleProcessor {
    double toothSize;

    public SawtoothBrightnessSlice(int sawtooth) {
        if(sawtooth > 128) throw new IllegalArgumentException(" sawtooth > 128 ");
        if(sawtooth < 1) throw new IllegalArgumentException(" sawtooth < 1 ");
        this.toothSize = 256 / sawtooth;
    }

    @Override
    protected int simpleOperation(int rgb) {
        MyRGB myRGB = new MyRGB(rgb);
        myRGB.setRed((int)((((double)myRGB.getRed() % toothSize)/ toothSize) * 255));
        myRGB.setGreen((int)((((double)myRGB.getGreen() % toothSize)/ toothSize) * 255));
        myRGB.setBlue((int)((((double)myRGB.getBlue() % toothSize)/ toothSize) * 255));
        return myRGB.toInteger();
    }
}
