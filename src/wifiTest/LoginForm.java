package wifiTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginForm extends Application{

	@Override
	public void start(Stage stage){
		// TODO 自动生成的方法存根
		Stage loginStage = new Stage();
		//loginStage.setResizable(false);
		//loginStage.initStyle(StageStyle.TRANSPARENT);
		//loginStage.initModality(Modality.APPLICATION_MODAL);
		loginStage.setWidth(450);
		loginStage.setHeight(350);
		//loginStage.setTitle("登录");
		//loginStage.getIcons().addAll(new Image("5.png"),new Image("6.png"));
		
		BorderPane one=new BorderPane();
       /* Image backgroundimage2 = new Image("31.jpg");
		ImageView backgroundimageView2 = new ImageView(backgroundimage2);
		backgroundimageView2.fitWidthProperty().bind(one.widthProperty());
		backgroundimageView2.fitHeightProperty().bind(one.heightProperty());
		one.getChildren().add(backgroundimageView2);*/
		
	   HBox lhbox = new HBox();
	   lhbox.setPadding(new Insets(10, 12, 10, 8)); //节点到边缘的距离
	   lhbox.setSpacing(25); //节点之间的间距
	   lhbox.setStyle("-fx-background-color: #63B8FF;"); //背景色
	   Label login = new Label("登录");
	   login.setTextFill(Color.web("#FFFFFF"));  
	   login.setFont(new Font("宋体",21));
	   /*Label title =  new Label("登录");
	   title.setFont(new Font("宋体",21));*/
	   lhbox.getChildren().add(login);
		//one.setPadding(new Insets(11,3,3,3));
	
		one.setTop(lhbox);
		VBox mainBox = new VBox(25);
		mainBox.setPadding(new Insets(18,10,3,38));
		HBox nameHbox = new HBox();
		nameHbox.setPadding(new Insets(11,10,0,10));
		Label userNL = new Label("用户名");
		userNL.setTextFill(Color.web("#FFFFFF")); 
		userNL.setStyle("-fx-background-color: #63B8FF;"); //背景色
		userNL.setGraphic(new ImageView("3.png"));
		userNL.setFont(new Font(30));
		TextField userNT = new TextField();
		userNT.setPromptText("please input your username!");
		userNT.setPrefHeight(33);
		userNT.setStyle("-fx-border-color: white;"); //背景色
		userNT.setPrefColumnCount(20);
		nameHbox.getChildren().addAll(userNL,userNT);
		HBox passHbox = new HBox();
		passHbox.setPadding(new Insets(11,10,0,10));
		Label passNL = new Label("密码");
		passNL.setTextFill(Color.web("#FFFFFF")); 
		passNL.requestFocus();
		passNL.setStyle("-fx-background-color: #63B8FF;"); //背景色
		passNL.setGraphic(new ImageView("4.png"));
		passNL.setFont(new Font(30));
		TextField passNT = new TextField();
		
		passNT.setPromptText("please input your password!");
		passNT.setPrefHeight(33);
		passNT.setStyle("-fx-border-color: white;"); //背景色
		passNT.setPrefColumnCount(23);
		passHbox.getChildren().addAll(passNL,passNT);
		GridPane buttHbox = new GridPane();
		buttHbox.setPadding(new Insets(11,10,0,10));
		Button sure = new Button("Sign in");
		
		sure.setPrefWidth(173);
		sure.setPrefHeight(37);
		Button delete = new Button("Sign out");
		delete.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
			loginStage.close(); });
		delete.setPrefWidth(173);
		delete.setPrefHeight(37);
		Label forgNL = new Label("Password Forgot?");
		//forgNL.setTextFill(Color.web("#FFFFFF")); 
		Label regiNL = new Label("Register an account!");
		//regiNL.setTextFill(Color.web("#FFFFFF"));
		forgNL.setOnMouseEntered((MouseEvent e) -> {
			forgNL.setScaleX(1.1);
			forgNL.setScaleY(1.1);
			});

		forgNL.setOnMouseExited((MouseEvent e) -> {
			forgNL.setScaleX(1);
			forgNL.setScaleY(1);
			});
		regiNL.setOnMouseEntered((MouseEvent e) -> {
			regiNL.setScaleX(1.1);
			regiNL.setScaleY(1.1);
			});

		regiNL.setOnMouseExited((MouseEvent e) -> {
			regiNL.setScaleX(1);
			regiNL.setScaleY(1);
			});
		regiNL.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
			Register registerpane = new Register(); registerpane.start(stage);  });
		buttHbox.setVgap(5);
		buttHbox.add(sure,0,0);
		buttHbox.add(delete,1,0);
		buttHbox.add(forgNL,0,1);
		buttHbox.add(regiNL,1,1);
		mainBox.getChildren().addAll(nameHbox,passHbox,buttHbox);
		one.setCenter(mainBox);
		
	/*
		GridPane lopane = new GridPane();
		lopane.setHgap(5);
		lopane.setVgap(7);
		//lopane.setPadding(new Insets(5, 10, 10, 0));

		Label userNL = new Label("用户名：");
		userNL.setGraphic(new ImageView("3.png"));
		userNL.setFont(new Font(23));
		TextField userNT = new TextField();
        
		//用户名检测操作
		String nametxt ="^[a-zA-Z0-9][12]%" ;
		
		userNT.setPrefColumnCount(13);
		lopane.add(userNL, 2, 3, 2, 1);
		lopane.add(userNT, 4, 3);
		Label nameTip = new Label("nametips:");
		lopane.add(nameTip, 2, 4);
		
		//密码检测操作
		Label userPL = new Label("密码：");
		userPL.setGraphic(new ImageView("4.png"));
		userPL.setFont(new Font(23));
		TextField userPT = new TextField();
		userPT.setPrefColumnCount(13);
		lopane.add(userPL, 2, 5, 2, 1);
		lopane.add(userPT, 4, 5);
		Label passTip = new Label("passtips:");
		lopane.add(passTip, 2, 6);
		Label userFL = new Label("             忘记密码");
		userFL.setOnMouseEntered((MouseEvent e) -> {
			userFL.setScaleX(1.1);
			userFL.setScaleY(1.1);
		});

		userFL.setOnMouseExited((MouseEvent e) -> {
			userFL.setScaleX(1);
			userFL.setScaleY(1);
		});
		userFL.setFont(new Font(13));
		Label userRL = new Label("   注册");
		userRL.setFont(new Font(13));
		userRL.setOnMouseEntered((MouseEvent e) -> {
			userRL.setScaleX(1.1);
			userRL.setScaleY(1.1);
		});

		userRL.setOnMouseExited((MouseEvent e) -> {
			userRL.setScaleX(1);
			userRL.setScaleY(1);
		});
		HBox Lbox = new HBox(8); // spacing = 8
		Lbox.getChildren().addAll(userFL, userRL);
		lopane.add(Lbox, 4, 6, 1, 1);
		
		//确认按钮、取消按钮，改进地方：样式，操作
		Button sure = new Button("确定");
		sure.setBackground(null);
		sure.setBorder(null);
		sure.setOnMouseEntered((MouseEvent e) -> {
			sure.setBackground(
					new Background(new BackgroundFill(Color.WHITE, new CornerRadii(1.0), new Insets(1.0))));
		});

		sure.setOnMouseExited((MouseEvent e) -> {
			sure.setBackground(null);
		});
		
		//确定按钮点击事件
		sure.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
			loginStage.close();
		});

		Button cancel = new Button("取消");
		cancel.setBackground(null);
		cancel.setBorder(null);
		
		cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
			loginStage.close();
		});
		
		cancel.setOnMouseEntered((MouseEvent e) -> {
			cancel.setBackground(
					new Background(new BackgroundFill(Color.WHITE, new CornerRadii(1.0), new Insets(1.0))));
		});

		cancel.setOnMouseExited((MouseEvent e) -> {
			cancel.setBackground(null);
		});
		HBox Bbox = new HBox(8); // spacing = 8
		Bbox.getChildren().addAll(new Label("              "), sure, cancel);
		lopane.add(Bbox, 4, 8, 1, 1);
        one.setCenter(lopane);*/
		Scene scene = new Scene(one);
		loginStage.setScene(scene);
		loginStage.show();
		;
		// loginScene.setFill(null);
		// loginStage.setResizable(false);
}
		
	}


