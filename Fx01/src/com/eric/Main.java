package com.eric;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @ClassName: Main
 * @Description: stage的一些基本设置
 * @Author: Eric
 * @Date: 2019/3/23 0023
 * @Email: xiao_cui_vip@163.com
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        //设置标题
        stage.setTitle("恶意Android应用检测系统");
        //设置icon
        stage.getIcons().add(new Image("/images/detectIcon.png"));
        //设置宽度
        stage.setWidth(680);
        //设置高度
        stage.setHeight(600);
        //设置最大宽度
//        stage.setMaxWidth(1000);
        //设置最大高度
//        stage.setMaxHeight(720);
        //高度变化的监听
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("新的宽度："+newValue);

            }
        });
        //宽度变化监听
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("新的高度："+newValue);
            }
        });






        //显示
        stage.show();

    }
}
