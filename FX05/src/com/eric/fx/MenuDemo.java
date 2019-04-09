package com.eric.fx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 *@description:顶部菜单栏
 *@author:cuigs
 *@Email:cuigs@ti-net.com.cn
 *@Version:1.0
 *@Date:2019/4/9
 */
public class MenuDemo  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button bt1 = new Button("点击显示窗口");
        //绝对布局
        AnchorPane an = new AnchorPane();
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("菜单1");
        Menu menu2 = new Menu("菜单2");
        Menu menu3 = new Menu("菜单3");
        Menu menu4 = new Menu("菜单4");
        Menu menu5 = new Menu("菜单5");
        //将菜单添加到导航栏
        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4,menu5);
        MenuItem item1 = new MenuItem("项目1");
        MenuItem item2 = new MenuItem("项目2");
        MenuItem item3 = new MenuItem("项目3");
        MenuItem item4 = new MenuItem("项目4");
        MenuItem item5 = new MenuItem("项目5");
        //给item添加一个图标
        MenuItem item6 = new MenuItem("项目6",new ImageView("images/bookmark.png"));
        //将item添加到menu
        menu1.getItems().addAll(item1,item2,item3);
        menu2.getItems().addAll(item4,item5,item6);

        //给布局设置一个背景颜色
        an.setStyle("-fx-background-color: #FFEFDB");
        an.getChildren().add(bt1);
        //将导航栏添加到布局
        an.getChildren().add(menuBar);
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
        //给导航栏设置宽度
        menuBar.setPrefWidth(an.getWidth());
        //监听根节点(布局)的宽度变化
        an.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(stage.getWidth());
            }
        });


        //给item添加点击事件
        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("项目1被点击了....");
            }
        });
    }
}
