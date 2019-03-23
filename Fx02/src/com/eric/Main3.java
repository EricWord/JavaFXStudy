package com.eric;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: Eric
 * @Date: 2019/3/23 0023
 * @Email: xiao_cui_vip@163.com
 */
public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("s1");
//        s1.initModality(Modality.APPLICATION_MODAL);
        Stage s2 = new Stage();
        s2.setTitle("s2");
//        s2.initOwner(s1);
        s2.initModality(Modality.APPLICATION_MODAL);
        Stage s3 = new Stage();
        s3.setTitle("s3");
        s1.show();
        s2.show();
        s3.show();

    }
}
