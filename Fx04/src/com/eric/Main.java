package com.eric;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

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
        Screen screen = Screen.getPrimary();
        double dpi = screen.getDpi();
        System.out.println("屏幕dpi="+dpi);
        Rectangle2D rec1 = screen.getBounds();
        System.out.println("下面是全部屏幕");
        System.out.println(rec1.getMinX()+":"+rec1.getMaxX()+":"+rec1.getMinY()+":"+rec1.getMaxY());
        Rectangle2D rec2 = screen.getVisualBounds();
        System.out.println(rec2.getMinX()+":"+rec2.getMaxX()+":"+rec2.getMinY()+":"+rec2.getMaxY());


    }
}
