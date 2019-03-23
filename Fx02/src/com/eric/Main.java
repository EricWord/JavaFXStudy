package com.eric;

import com.sun.org.apache.xpath.internal.Arg;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

import javax.xml.bind.SchemaOutputResolver;

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
        //设置宽高
        stage.setWidth(600);
        stage.setHeight(600);
        //设置透明度
        stage.setOpacity(0.8);
        //设置总是置顶显示
//        stage.setAlwaysOnTop(true);
        //设置初始横轴纵轴坐标
        stage.setX(200);
        stage.setY(300);
        //横纵坐标的监听
        stage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                System.out.println("新的x坐标为："+newValue);
            }
        });
        stage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("新的纵坐标为："+newValue);
            }
        });

        //不要忘记显示
        stage.show();


    }
}
