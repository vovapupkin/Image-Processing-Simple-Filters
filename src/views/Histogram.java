package views;

import models.MyImage;
import models.MyRGB;

import javax.swing.*;
import javax.swing.plaf.synth.ColorType;
import java.awt.*;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * Created by vova on 06-Oct-16.
 */
public class Histogram extends JPanel {

    //TODO: refactor class

    public Histogram(MyImage image, String color) {
        JFrame frame = new JFrame(color);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(new Graph(image, color)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private class Graph extends JPanel {
        protected static final int MIN_BAR_WIDTH = 4;
        private Integer[] histogram = new Integer[256];

        public Graph(MyImage image, String color) {
            Arrays.fill(histogram, 0);
            BufferedImage bufferedImage = image.getBufferedImage();
            for (int i = 0; i < bufferedImage.getWidth(); i++) {
                for (int j = 0; j < bufferedImage.getHeight(); j++) {
                    //TODO: changed it with ENUM
                    switch (color) {
                        case "red":
                            histogram[new MyRGB(bufferedImage.getRGB(i, j)).getRed()]++;
                            break;
                        case "green":
                            histogram[new MyRGB(bufferedImage.getRGB(i, j)).getGreen()]++;
                            break;
                        case "blue":
                            histogram[new MyRGB(bufferedImage.getRGB(i, j)).getBlue()]++;
                            break;
                        case "brightness":
                            histogram[new MyRGB(bufferedImage.getRGB(i, j)).getBrightness()]++;
                            break;
                        default:
                            throw new IllegalArgumentException("invalid color");
                    }

                }
            }
            int width = (histogram.length * MIN_BAR_WIDTH) + 11;
            Dimension minSize = new Dimension(width, 128);
            Dimension prefSize = new Dimension(width, 256);
            setMinimumSize(minSize);
            setPreferredSize(prefSize);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (histogram != null) {
                int xOffset = 5;
                int yOffset = 5;
                int width = getWidth() - 1 - (xOffset * 2);
                int height = getHeight() - 1 - (yOffset * 2);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(Color.DARK_GRAY);
                g2d.drawRect(xOffset, yOffset, width, height);
                int barWidth = Math.max(MIN_BAR_WIDTH,
                        (int) Math.floor((float) width
                                / (float) histogram.length));
                System.out.println("width = " + width + "; size = "
                        + histogram.length + "; barWidth = " + barWidth);
                int maxValue = 0;
                for (Integer key : histogram) {
                    int value = key;
                    maxValue = Math.max(maxValue, value);
                }
                int xPos = xOffset;
                for (Integer key : histogram) {
                    int value = key;
                    int barHeight = Math.round(((float) value
                            / (float) maxValue) * height);
                    g2d.setColor(new Color(150, 150, 150));
                    int yPos = height + yOffset - barHeight;
                    Rectangle2D bar = new Rectangle2D.Float(
                            xPos, yPos, barWidth, barHeight);
                    g2d.fill(bar);
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.draw(bar);
                    xPos += barWidth;
                }
                g2d.dispose();
            }
        }
    }
}
