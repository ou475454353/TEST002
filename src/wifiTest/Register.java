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

public class Register extends Application{

	@Override
	public void start(Stage stage){
		// TODO 自动生成的方法存根
		Stage loginStage = new Stage();
		loginStage.setHeight(400);
		BorderPane one=new BorderPane();
	   HBox lhbox = new HBox();
	   lhbox.setPadding(new Insets(10, 12, 10, 20)); //节点到边缘的距离
	   lhbox.setSpacing(25); //节点之间的间距
	   lhbox.setStyle("-fx-background-color: #63B8FF;"); //背景色
	   Label login = new Label("注册");
	   login.setTextFill(Color.web("#FFFFFF"));  
	   login.setFont(new Font("宋体",21));
	   lhbox.getChildren().add(login);
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
		Label passNL = new Label("登录密码");
		passNL.setTextFill(Color.web("#FFFFFF")); 
		passNL.setStyle("-fx-background-color: #63B8FF;"); //背景色
		passNL.setGraphic(new ImageView("4.png"));
		passNL.setFont(new Font(30));
		TextField passNT = new TextField();
		passNT.setPromptText("please input your password!");
		passNT.setPrefHeight(33);
		passNT.setStyle("-fx-border-color: white;"); //背景色
		passNT.setPrefColumnCount(17);
		passHbox.getChildren().addAll(passNL,passNT);
		HBox passHbox1 = new HBox();
		passHbox1.setPadding(new Insets(11,10,0,10));
		Label passNL1 = new Label("确认密码");
		passNL1.setTextFill(Color.web("#FFFFFF")); 
		passNL1.setStyle("-fx-background-color: #63B8FF;"); //背景色
		passNL1.setGraphic(new ImageView("4.png"));
		passNL1.setFont(new Font(30));
		TextField passNT1 = new TextField();
		passNT1.setPromptText("please input your password!");
		passNT1.setPrefHeight(33);
		passNT1.setStyle("-fx-border-color: white;"); //背景色
		passNT1.setPrefColumnCount(17);
		passHbox1.getChildren().addAll(passNL1,passNT1);
		GridPane buttHbox = new GridPane();
		buttHbox.setPadding(new Insets(11,10,0,10));
		Button sure = new Button("Register in");
		
		sure.setPrefWidth(173);
		sure.setPrefHeight(37);
		Button delete = new Button("Cancel");
		delete.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
			loginStage.close(); });
		delete.setPrefWidth(173);
		delete.setPrefHeight(37);
		buttHbox.setVgap(5);
		buttHbox.add(sure,0,0);
		buttHbox.add(delete,1,0);
		mainBox.getChildren().addAll(nameHbox,passHbox,passHbox1,buttHbox);
		one.setCenter(mainBox);
	
		Scene scene = new Scene(one);
		loginStage.setScene(scene);
		loginStage.show();
		;
}
		
	}


