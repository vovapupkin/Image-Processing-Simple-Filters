package models;


import views.Histogram;
import views.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class MyImage {

    BufferedImage bufferedImage;

    public MyImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public MyImage(String path) {
        loadFromFile(new File(path));
    }

    public MyImage(File file) {
        loadFromFile(file);
    }

    private void loadFromFile(File file) {
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    @Override
    public MyImage clone() {
        ColorModel cm = bufferedImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bufferedImage.copyData(null);
        return new MyImage(new BufferedImage(cm, raster, isAlphaPremultiplied, null));
    }

    public void show() {
        new ImageView(bufferedImage);
    }

    public void redHistogram() {
        new Histogram(this, "red");
    }

    public void greenHistogram() {
        new Histogram(this, "green");
    }

    public void blueHistogram() {
        new Histogram(this, "blue");
    }

    public void brightnessHistogram() {
        new Histogram(this, "brightness");
    }
}
