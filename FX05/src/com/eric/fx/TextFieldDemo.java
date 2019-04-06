package com.eric.fx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/*
 *@description:输入框
 *@author:cuigs
 *@Email:cuigs@ti-net.com.cn
 *@Version:1.0
 *@Date:2019/4/5
 */
public class TextFieldDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        stage.setHeight(600);
        stage.setWidth(800);
        stage.setTitle("输入框演示");
        Group root = new Group();
        TextField tx = new TextField();
//        tx.setText("你好世界");
        //设置输入框的位置
        tx.setLayoutX(100);
        tx.setLayoutY(100);
        //设置输入框的宽和高
        tx.setPrefHeight(50);
        tx.setPrefWidth(100);
        //鼠标放上会有提示
        tx.setTooltip(new Tooltip("请输入哦！"));
        //设置提示
        tx.setFocusTraversable(false);


        //限制输入框中输入的文字长度
        tx.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.length()>7){
                    tx.setText(oldValue);
                }
            }
        });

        //监听用户已经选择的内容
        tx.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });
        //密码框
        PasswordField pf = new PasswordField();
        pf.setLayoutX(300);
        pf.setLayoutY(100);
        pf.setPrefHeight(50);
        pf.setPrefWidth(100);
        root.getChildren().add(pf);
        tx.setPromptText("请输入手机号");
        //标签
        Label label = new Label("手机号");
        //设置位置
        label.setLayoutX(2);
        label.setLayoutY(100);
        root.getChildren().add(tx);
        root.getChildren().add(label);
        Scene scene = new Scene(root);
        stage.setScene(scene);


        stage.show();





    }
}
