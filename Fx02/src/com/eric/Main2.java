package com.eric;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: Eric
 * @Date: 2019/3/23 0023
 * @Email: xiao_cui_vip@163.com
 */
public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Stage s1 = new Stage();
        //设置窗口的类型
        s1.initStyle(StageStyle.DECORATED);//默认类型
        s1.setTitle("s1");
        Stage s2 = new Stage();
        //设置窗口的类型
        s2.initStyle(StageStyle.DECORATED);//透明
        s2.setTitle("s2");
        Stage s3 = new Stage();
        //设置窗口的类型
        s3.initStyle(StageStyle.UNDECORATED);//透明
        Stage s4 = new Stage();
        //设置窗口的类型
        s4.initStyle(StageStyle.UNIFIED);//颜色统一
        Stage s5 = new Stage();
        //设置窗口的类型
        s5.initStyle(StageStyle.UTILITY);//没有最大化最小化，只有关闭关闭

        s1.show();
        s2.show();
        s3.show();
        s4.show();
        s5.show();


    }
}
