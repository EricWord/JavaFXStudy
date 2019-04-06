package com.eric.fx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/*
 *@description:窗口
 *@author:cuigs
 *@Email:cuigs@ti-net.com.cn
 *@Version:1.0
 *@Date:2019/4/6
 */
public class DialogDemo extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {


        Button bt1 = new Button("点击显示窗口");
        //设置按钮的样式
        //设置字体及大小
        bt1.setFont(Font.font("宋体",14));
        //设置按钮背景
        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#CDC673"),new CornerRadii(5),new Insets(3));
        Background bg = new Background(bgf);
        bt1.setBackground(bg);
        //给按钮设置点击监听
        bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //实现点击按钮弹出窗口
                DialogPane dialogPane = new DialogPane();
                //设置弹窗中显示的文字
                dialogPane.setHeaderText("请下次再来！");
                dialogPane.setContentText("您的验证码是38283");
                //设置弹窗的按钮
                dialogPane.getButtonTypes().add(ButtonType.OK);
                dialogPane.getButtonTypes().add(ButtonType.NO);
                //给弹窗添加图片(在右上角)
                ImageView ima = new ImageView("/images/detectIcon.png");
                dialogPane.setGraphic(ima);
                //设置扩展内容
                dialogPane.setExpandableContent(new Text("这是详细信息..."));
                dialogPane.setExpanded(false);
                //先获取按钮，然后设置点击事件
                Button ok = (Button) dialogPane.lookupButton(ButtonType.OK);
                Button no = (Button) dialogPane.lookupButton(ButtonType.NO);
                Scene sc = new Scene(dialogPane);

                Stage st = new Stage();
                st.setScene(sc);
                //设置模态窗口
                st.initOwner(stage);
                st.initModality(Modality.WINDOW_MODAL);
                //去掉右上角的最大化和最小化
                st.initStyle(StageStyle.UTILITY);
                st.setTitle("弹出窗口");
                //设置弹出窗口的大小
//                st.setWidth(100);
//                st.setHeight(60);

                //显示
                st.show();
                //给按钮设置监听
                ok.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("ok按钮被点击了....");
                    }
                });
                //给no按钮设置点击事件
                no.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("no按钮被点击了....");
                    }
                });
                //创建计划任务
                MyScheuledService service = new MyScheuledService(dialogPane,st);
                //设置延迟
                service.setDelay(Duration.millis(0));
                //设置事件间隔
                service.setPeriod(Duration.millis(1000));
                //启动定时任务
                service.start();
            }


        });
        //绝对布局
        AnchorPane an = new AnchorPane();
        //给布局设置一个背景颜色
        an.setStyle("-fx-background-color: #FFEFDB");
        an.getChildren().add(bt1);
        //设置距离顶部的距离
        AnchorPane.setTopAnchor(bt1,20.0);
        //设置距离左边的距离
        AnchorPane.setLeftAnchor(bt1,20.0);
        Scene scene = new Scene(an);
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

    }
}


//多任务 内部类

class MyScheuledService extends ScheduledService<Integer>{
    //自增
    private  int i=0;
    private DialogPane di;
    private Stage st;

    public MyScheuledService() {
    }

    public MyScheuledService(DialogPane di, Stage st) {
        this.di = di;
        this.st = st;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                System.out.println("call()所在的线程名称:"+Thread.currentThread().getName());
                return i++;
            }


            @Override
            protected void updateValue(Integer value) {
                System.out.println("updateValue所在的线程名称:"+Thread.currentThread().getName());
                System.out.println("updateValue="+value);
                super.updateValue(value);
                if(value<11){
                    //更新界面
                    di.setContentText(String.valueOf(value));
                }else{
                    //关闭窗口
                    st.close();
                    //结束计划任务,注意这里要加上类名，不能直接用this
                    MyScheuledService.this.cancel();
                }
            }
        };
    }




}

