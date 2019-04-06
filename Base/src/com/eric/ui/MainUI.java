package com.eric.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 *@description:主界面
 *@author:cuigs
 *@Email:cuigs@ti-net.com.cn
 *@Version:1.0
 *@Date:2019/4/6
 */
public class MainUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button bt1 = new Button("点击显示窗口");
        //绝对布局
        AnchorPane an = new AnchorPane();
        //给布局设置一个背景颜色
        an.setStyle("-fx-background-color: #FFEFDB");
        an.getChildren().add(bt1);
        Scene scene = new Scene(an);
        //将场景添加到舞台
        stage.setScene(scene);

        //设置舞台的宽高
        stage.setHeight(700);
        stage.setWidth(900);
        //设置标题
        stage.setTitle("基于在线学习的恶意Android应用检测系统");
        //设置左上角的图标
        //设置icon
        stage.getIcons().add(new Image("/images/detectIcon.png"));

        //显示舞台
        stage.show();

    }
}
