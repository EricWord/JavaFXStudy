package com.eric.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 *@description:登录小项目
 *@author:cuigs
 *@Email:cuigs@ti-net.com.cn
 *@Version:1.0
 *@Date:2019/4/6
 */
public class LoginDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        //两个标签
        Label account = new Label("账号：");
        Label pwd = new Label("密码：");
        //设置标签文字的大小
        account.setFont(Font.font("宋体",14));
        pwd.setFont(Font.font("宋体",14));
        //密码框
        PasswordField pwf = new PasswordField();
        //输入框
        TextField tx = new TextField();
        Button login = new Button("登录");
        Button clear = new Button("清除");


        //网格布局
        GridPane gp=new GridPane();
        //给布局设置一个背景颜色
        gp.setStyle("-fx-background-color: #FFEFDB");
        //设置对齐方式
        gp.setAlignment(Pos.CENTER);

        //将组件添加到布局中
        gp.add(account,0,0);
        gp.add(tx,1,0);
        gp.add(pwd,0,1);
        gp.add(pwf,1,1);
        gp.add(clear,0,2);
        gp.add(login,1,2);
        //设置水平间距
        gp.setHgap(5);
        //设置垂直间距
        gp.setVgap(17);
        //给登录按钮设置外边距
        GridPane.setMargin(login,new Insets(0,0,0,120));


        Scene scene = new Scene(gp);
        //将场景添加到舞台
        stage.setScene(scene);

        //设置舞台的宽高
        stage.setHeight(750);
        stage.setWidth(1200);
        //设置标题
        stage.setTitle("基于在线学习的恶意Android应用检测系统");
        //设置左上角的图标
        //设置icon
        stage.getIcons().add(new Image("/images/detectIcon.png"));

        //禁止舞台拉伸
        stage.setResizable(false);
        //显示舞台
        stage.show();
        //给清除按钮设置点击事件
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tx.setText("");
                pwf.setText("");
            }
        });

    }
}
