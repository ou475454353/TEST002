package wifiTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//精品
//颜色，表现形式，创意
//抠图
public class MainForm extends Application {
	TreeItem<String> searchItem = new TreeItem<> ("客流量查询");
	TreeView<String> tree = new TreeView<> (searchItem);
	BorderPane basepane = new BorderPane();
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException, IOException {
		// TODO 自动生成的方法存根
		/*
		 * Button login = new Button("登录"); Scene mainScence = new Scene(login);
		 * login.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
		 * LoginForm loginpane = new LoginForm(); loginpane.start(stage); });
		 * stage.setScene(mainScence); stage.show();
		 */
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		//BorderPane basepane = new BorderPane();
		
		//顶部布局
		   HBox hbox = new HBox();
		   hbox.setPadding(new Insets(10, 12, 10, 920)); //节点到边缘的距离
		   hbox.setSpacing(25); //节点之间的间距
		   hbox.setStyle("-fx-background-color: #63B8FF;"); //背景色
		   Image loginimage = new Image("8.png");
		   ImageView loginimageView = new ImageView(loginimage);
		   Label login = new Label("登录");
		   login.setGraphic(loginimageView);  
		   login.setTextFill(Color.web("#FFFFFF"));  
		   login.setContentDisplay(ContentDisplay.TOP);
			login.setOnMouseEntered((MouseEvent e) -> {
				login.setScaleX(1.1);
				login.setScaleY(1.1);
			});

			login.setOnMouseExited((MouseEvent e) -> {
				login.setScaleX(1);
				login.setScaleY(1);
			});
			login.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
				  LoginForm loginpane = new LoginForm(); loginpane.start(primaryStage); });
			
			
			Image setimage = new Image("9.png");
			   ImageView setmageView = new ImageView(setimage);
			   Label setlabel = new Label("设置");
			   setlabel.setGraphic(setmageView);  
			   setlabel.setTextFill(Color.web("#FFFFFF"));  
			   setlabel.setContentDisplay(ContentDisplay.TOP);
			   setlabel.setOnMouseEntered((MouseEvent e) -> {
				   setlabel.setScaleX(1.1);
				   setlabel.setScaleY(1.1);
				});

			   setlabel.setOnMouseExited((MouseEvent e) -> {
				   setlabel.setScaleX(1);
				   setlabel.setScaleY(1);
				});
			   setlabel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
					  Set setpane = new Set(); setpane.start(primaryStage); });
			   
			   
			   
			   Image helpimage = new Image("11.png");
			   ImageView helpmageView = new ImageView(helpimage);
			   Label helplabel = new Label("帮助");
			   helplabel.setGraphic(helpmageView);  
			   helplabel.setTextFill(Color.web("#FFFFFF"));  
			   helplabel.setContentDisplay(ContentDisplay.TOP);
			   helplabel.setOnMouseEntered((MouseEvent e) -> {
				   helplabel.setScaleX(1.1);
				   helplabel.setScaleY(1.1);
				});

			   helplabel.setOnMouseExited((MouseEvent e) -> {
				   helplabel.setScaleX(1);
				   helplabel.setScaleY(1);
				});
			   helplabel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
					  Help helppane = new Help(); helppane.start(primaryStage); });
			   
			   Image shopimage = new Image("13.png");
			   ImageView shopimageView = new ImageView(shopimage);
			   Label shoplabel = new Label("店铺管理");
			   shoplabel.setGraphic(shopimageView);  
			   shoplabel.setTextFill(Color.web("#FFFFFF"));  
			   shoplabel.setContentDisplay(ContentDisplay.TOP);
			   shoplabel.setOnMouseEntered((MouseEvent e) -> {
				   shoplabel.setScaleX(1.1);
				   shoplabel.setScaleY(1.1);
				});

			   shoplabel.setOnMouseExited((MouseEvent e) -> {
				   shoplabel.setScaleX(1);
				   shoplabel.setScaleY(1);
				});
			   shoplabel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
					  Shop shoppane = new Shop(); shoppane.start(primaryStage); });
			   
			   
			   Image quitimage = new Image("12.png");
			   ImageView quitmageView = new ImageView(quitimage);
			   Label quitlabel = new Label("退出");
			   quitlabel.setGraphic(quitmageView);  
			   quitlabel.setTextFill(Color.web("#FFFFFF"));  
			   quitlabel.setContentDisplay(ContentDisplay.TOP);
			   quitlabel.setOnMouseEntered((MouseEvent e) -> {
				   quitlabel.setScaleX(1.1);
				   quitlabel.setScaleY(1.1);
				});

			   quitlabel.setOnMouseExited((MouseEvent e) -> {
				   quitlabel.setScaleX(1);
				   quitlabel.setScaleY(1);
				});
			   quitlabel.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
				   primaryStage.close(); });
		   hbox.getChildren().addAll(setlabel,login,shoplabel,helplabel,quitlabel);
		   basepane.setTop(hbox);
		//左边布局，菜单
		/*TreeItem<String> dayItem = new TreeItem<> ("每日客流量");
		TreeItem<String> weekItem = new TreeItem<> ("每周客流量");
		TreeItem<String> monthItem = new TreeItem<> ("每月客流量");
		TreeView<String> tree = new TreeView<> (dayItem);
		StackPane root = new StackPane();
	    root.getChildren().add(tree);
	    basepane.setLeft(root);*/
		
		//TreeItem<String> searchItem = new TreeItem<> ("客流量查询");
		Image peopleimage = new Image("22.png");
		ImageView peopleimageView = new ImageView(peopleimage);
		searchItem.setGraphic(peopleimageView);
		TreeItem<String> dayitem = new TreeItem<> ("每日客流量查询");
		Image dayimage = new Image("19.png");
		ImageView dayimageView = new ImageView(dayimage);
		dayitem.setGraphic(dayimageView);
		
		TreeItem<String> weekitem = new TreeItem<> ("每周客流量查询");
		Image weekimage = new Image("20.png");
		ImageView weekimageView = new ImageView(weekimage);
		weekitem.setGraphic(weekimageView);
		TreeItem<String> monthitem = new TreeItem<> ("每月客流量查询");
		Image monthimage = new Image("21.png");
		ImageView monthimageView = new ImageView(monthimage);
		monthitem.setGraphic(monthimageView);
		searchItem.getChildren().add(dayitem);
		searchItem.getChildren().add(weekitem);
		searchItem.getChildren().add(monthitem);
		
		//TreeView<String> tree = new TreeView<> (searchItem);
		
		EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
		    try {
				handleMouseClicked(event);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		};

		tree.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle); 
		StackPane root = new StackPane();
		root.setPadding(new Insets(1, 1, 1, 1)); //节点到边缘的距离
		//root.setStyle("-fx-background-color: #B0E2FF;"); //背景色
        root.getChildren().add(tree);
	    basepane.setLeft(root);
	    
	 
		primaryStage.setWidth(1300);
		primaryStage.setHeight(700);
		Scene b = new Scene(basepane);

		primaryStage.setScene(b);
		Application.setUserAgentStylesheet(getClass().getResource("caspian.css").toExternalForm());
		primaryStage.show();

	}

	private void handleMouseClicked(MouseEvent event) throws FileNotFoundException, IOException {
		// TODO 自动生成的方法存根
		Node node = event.getPickResult().getIntersectedNode();
	    // Accept clicks only on node cells, and not on empty spaces of the TreeView
	    if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
	        String name = (String) ((TreeItem)tree.getSelectionModel().getSelectedItem()).getValue();
	        System.out.println("Node click: " + name);
	        Line dayLinePhoto = new Line();
	        if(name.equals("每日客流量查询"))
	        {
	        	
	        	basepane.setCenter(dayLinePhoto.setDayPhoto());
	        }
	        else if(name.equals("每周客流量查询"))
	        {
	        	basepane.setCenter(dayLinePhoto.setWeekPhoto());
	        }
	        else if(name.equals("每月客流量查询"))
	        {
	        	basepane.setCenter(dayLinePhoto.setMonthPhoto());
	        }
	        
	        else
	        {
	        	
	        }
	    }
		
	}

	
}
