package com.eric.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;



/*
 *@description:按钮的使用
 *@author:cuigs
 *@Email:cuigs@ti-net.com.cn
 *@Version:1.0
 *@Date:2019/4/5
 */
public class ButtonDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("提交");
        btn.setLayoutX(100);
        btn.setLayoutX(100);
        btn.setPrefWidth(200);
        btn.setPrefHeight(200);
        //设置字体及字体大小
        btn.setFont(Font.font("sans-serif",40));
        //设置背景
        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#FF6A6A"),new CornerRadii(20),new Insets(10));
        Background bg = new Background(bgf);
        btn.setBackground(bg);
        Group root = new Group();
        root.getChildren().add(btn);

        //设置描边
        BorderStroke borderStroke = new BorderStroke(Paint.valueOf("#E0E0E0"), BorderStrokeStyle.DOTTED, new CornerRadii(20), new BorderWidths(5));
        Border border = new Border(borderStroke);
        btn.setBorder(border);
        //设置按钮上字体的颜色
        btn.setTextFill(Paint.valueOf("#CAFF70"));
        //给按钮设置点击事件
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button bt = (Button) event.getSource();
                System.out.println(bt.getText()+"按钮被点击了....");
            }
        });

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("按钮单击事件..");
                //获取鼠标的名称
                System.out.println("name="+event.getButton().name());
                //双击事件
                if(event.getClickCount()==2){
                    System.out.println("双击事件");
                }

            }
        });


        //按钮监听键盘是否按下
        btn.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent  event) {
                //获取按下的键
                System.out.println(event.getCode().getName());
            }
        });


        btn.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode().getName());
            }
        });

        //设置快捷键
        KeyCodeCombination keyCodeCombination = new KeyCodeCombination(KeyCode.C, KeyCodeCombination.SHORTCUT_DOWN);



        stage.setTitle("演示按钮的使用");
        stage.setWidth(800);
        stage.setHeight(500);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getAccelerators().put(keyCodeCombination, new Runnable() {
            @Override
            public void run() {
                System.out.println("run方法...");
            }
        });


        stage.show();


    }
}
