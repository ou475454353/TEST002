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

public class Shop extends Application{

	@Override
	public void start(Stage stage){
		// TODO �Զ����ɵķ������
		Stage loginStage = new Stage();
		loginStage.setWidth(450);
		loginStage.setHeight(350);
		BorderPane one=new BorderPane();
	   HBox lhbox = new HBox();
	   lhbox.setPadding(new Insets(10, 12, 10, 20)); //�ڵ㵽��Ե�ľ���
	   lhbox.setSpacing(25); //�ڵ�֮��ļ��
	   lhbox.setStyle("-fx-background-color: #63B8FF;"); //����ɫ
	   Label login = new Label("���̹���");
	   login.setTextFill(Color.web("#FFFFFF"));  
	   login.setFont(new Font("����",21));
	   lhbox.getChildren().add(login);
		one.setTop(lhbox);
		
		Scene scene = new Scene(one);
		loginStage.setScene(scene);
		loginStage.show();
		;
}
		
	}


