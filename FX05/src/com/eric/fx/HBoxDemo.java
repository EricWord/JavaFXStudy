package com.eric.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
 *@description:HBox
 *@author:cuigs
 *@Email:cuigs@ti-net.com.cn
 *@Version:1.0
 *@Date:2019/4/5
 */
public class HBoxDemo  extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button bt1 = new Button("Button1");
        Button bt2 = new Button("Button2");
        Button bt3 = new Button("Button3");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(bt1,bt2,bt3);
        hBox.setStyle("-fx-background-color: #9B30FF");
        hBox.setPrefHeight(200);
        hBox.setPrefWidth(400);


        AnchorPane ap=new AnchorPane();
        ap.getChildren().add(hBox);
        ap.setStyle("-fx-background-color: #BCEE68");
        Scene scene = new Scene(ap);
        stage.setScene(scene);
        stage.setHeight(600);
        stage.setWidth(800);


        stage.show();

    }
}
