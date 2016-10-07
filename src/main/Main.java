package main;

import filters.*;
import baseStructures.ImageBuilder;
import javafx.application.Application;

import javafx.stage.Stage;
import models.MyImage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MyImage myImage1 = new MyImage("1.jpg");
        new ImageBuilder(myImage1).add(new BrightnessChange(-50)).build().show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
