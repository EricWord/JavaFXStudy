package com.eric;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.awt.image.Kernel;

/**
 * @ClassName: Main
 * @Description:
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
        String name = Thread.currentThread().getName();
        System.out.println(name);
        stage.setWidth(600);
        stage.setHeight(600);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println(name);

            }
        });


        stage.show();


    }
}
