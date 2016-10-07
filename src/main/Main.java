package main;

import filters.*;
import imageProcessing.ImageBuilder;
import javafx.application.Application;

import javafx.stage.Stage;
import models.MyImage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MyImage myImage = new MyImage("image1.jpg");
        myImage.show();
        new ImageBuilder(myImage)
                .add(new SawtoothBrightnessSlice(20))
                .build()
                .show();

        MyImage myImage1 = new MyImage("1.jpg");
        myImage1.show();
        MyImage myImage2 = new MyImage("2.jpg");
        myImage2.show();
        MyImage binaryImage2 = new ImageBuilder(myImage2)
                .add(new ImageBinarization(20))
                .build();
        new ImageBuilder(myImage1)
                .add(new ImageMasking(binaryImage2))
                .build()
                .show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
