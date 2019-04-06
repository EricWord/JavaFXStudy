package com.eric.fx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 *@description:布局
 *@author:cuigs
 *@Email:cuigs@ti-net.com.cn
 *@Version:1.0
 *@Date:2019/4/5
 */
public class LayoutDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("布局文件演示");
        stage.setWidth(800);
        stage.setHeight(600);
        //按钮
        Button b1 = new Button("按钮b1");
        Button b2 = new Button("按钮b2");

        AnchorPane ap=new AnchorPane();
        //布局设置背景颜色
        ap.setStyle("-fx-background-color: #CD00CD");
        //给背景设置点击事件
        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("背景被点击了...");
            }
        });
        ap.getChildren().addAll(b1,b2);
        AnchorPane.setTopAnchor(b1,20.0);
        AnchorPane.setLeftAnchor(b1,20.0);
        Scene scene = new Scene(ap);
        stage.setScene(scene);


        stage.show();

    }
}
