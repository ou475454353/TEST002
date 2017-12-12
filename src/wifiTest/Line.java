package wifiTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.*;

public class Line {

	private Series<String, Number> series = new XYChart.Series<>();// 创建一组坐标数据
	private NumberAxis yAxis;// 数字坐标：y轴
	private NumberAxis xAxis;// 文字坐标：x轴
	private double yShift;// 鼠标y坐标
	private double xShift;// 鼠标x坐标
	private ObservableList<String> options = FXCollections.observableArrayList();// x轴取值范围

	Pane pane;

	public Pane setDayPhoto() throws FileNotFoundException, IOException {

		for (int k = 0; k <= 23; k++) {
			for (int j = 0; j < 60; j += 30) {
				options.add("" + k + ":" + j);

			}
		} // 添加x轴的取值

		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Hours");

		LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

		xAxis.setCategories(options);

		lineChart.setTitle("当日客流量统计表");
		/*java.util.Random random = new java.util.Random();
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("F:\\temp.txt"));) {
			for (int i = 1; i <= 288; i++) {
				output.writeInt(random.nextInt(10000));
			}
		}*/
		/*
		 * DataInputStream input = new DataInputStream(new
		 * FileInputStream("F:\\temp.txt"));
		 * 
		 * for(int k1=0;k1<=23;k1++) { for(int i=1,j=0;j<60;i++,j+=30) {
		 * 
		 * series.getData().add(new XYChart.Data(""+k1+":"+j, input.readInt()));
		 * 
		 * } }//添加一组数据
		 */
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://120.77.222.144:3306/WIFI";
		// MySQL配置时的用户名
		String user = "Root";

		// MySQL配置时的密码
		String password = "abcdef";
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			Connection conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			// statement接口用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
			String sql = "select * from KFC10_half_visitors";

			// 结果集
			ResultSet rs = statement.executeQuery(sql);

			/*System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println("进店人数");
			System.out.println("-----------------");*/
			int id = 1, k1 = 0, j = 0;
			while (rs.next()) {

				/*System.out.println(id + "   " + rs.getInt("visitors") + k1+":"+j+"\n");
				id++;*/
				series.getData().add(new XYChart.Data("" + k1 + ":" + j, rs.getInt("visitors")));
				j+=30;
				int num=j%60;
				k1+=j/60;
				j=num;
			}

			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {

			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

		lineChart.setLegendVisible(false);// 隐藏图例
		lineChart.getData().add(series);

		// lineChart.setHorizontalGridLinesVisible(false);//中间显示的水平线不显示
		// lineChart.setVerticalGridLinesVisible(false);//中间显示的垂直线不显示
		lineChart.setAlternativeColumnFillVisible(true); // 默认false， 列颜色填充
		lineChart.setAlternativeRowFillVisible(true); // 默认true， 也就行颜色填充

		// 折线图上节点的点击事件，显示该点的坐标
		final Label caption = new Label("");
		caption.setTextFill(Color.BLUE);
		caption.setStyle("-fx-font: 16 arial;");
		for (Data<String, Number> value : series.getData()) {
			value.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					caption.setTranslateX(e.getSceneX());
					caption.setTranslateY(e.getSceneY());
					caption.setText("(" + value.getXValue().toString() + "," + value.getYValue().intValue() + ")");
					System.out.println("(" + value.getXValue().toString() + "," + value.getYValue().intValue() + ")");

				}
			});
		}
		// lineChart.setAlternativeRowFillVisible(false);
		Application.setUserAgentStylesheet(getClass().getResource("caspian.css").toExternalForm());
		pane = new Pane();
		pane.setPrefSize(1200, 600);
		lineChart.prefHeightProperty().bind(pane.heightProperty());
		lineChart.prefWidthProperty().bind(pane.widthProperty().multiply(0.94));
		pane.getChildren().addAll(lineChart, caption);
		return pane;

	}
	
	
	public Pane setWeekPhoto() throws FileNotFoundException, IOException {

		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Days");

		LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

		//xAxis.setCategories(options);

		lineChart.setTitle("每周客流量统计表");
		java.util.Random random = new java.util.Random();
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("F:\\temp.txt"));) {
			for (int i = 1; i <= 7; i++) {
				output.writeInt(random.nextInt(10000));
			}
		}
		
		 DataInputStream input = new DataInputStream(new
		 FileInputStream("F:\\temp.txt"));
		 series.getData().add(new XYChart.Data("Sunday", input.readInt()));
		 series.getData().add(new XYChart.Data("Monday", input.readInt()));
		 series.getData().add(new XYChart.Data("Tuesday", input.readInt()));
		 series.getData().add(new XYChart.Data("Wednesday", input.readInt()));
		 series.getData().add(new XYChart.Data("Thursday", input.readInt()));
		 series.getData().add(new XYChart.Data("Friday", input.readInt()));
		 series.getData().add(new XYChart.Data("Saturday", input.readInt()));
		 
		//添加一组数据
		 
		/*// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://120.77.222.144:3306/WIFI";
		// MySQL配置时的用户名
		String user = "Root";

		// MySQL配置时的密码
		String password = "abcdef";
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			Connection conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			// statement接口用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
			String sql = "select * from KFC10_half_visitors";

			// 结果集
			ResultSet rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println("进店人数");
			System.out.println("-----------------");

			String ID = null;
			String MAC = null;
			String times = null;
			String distance = null;
			int id = 1, k1 = 0, j = 0;
			while (rs.next()) {

				System.out.println(id + "   " + rs.getInt("visitors") + k1+":"+j+"\n");
				id++;
				series.getData().add(new XYChart.Data("" + k1 + ":" + j, rs.getInt("visitors")));
				j+=30;
				int num=j%60;
				k1+=j/60;
				j=num;
			}

			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {

			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
*/
		lineChart.setLegendVisible(false);// 隐藏图例
		lineChart.getData().add(series);

		// lineChart.setHorizontalGridLinesVisible(false);//中间显示的水平线不显示
		// lineChart.setVerticalGridLinesVisible(false);//中间显示的垂直线不显示
		lineChart.setAlternativeColumnFillVisible(true); // 默认false， 列颜色填充
		lineChart.setAlternativeRowFillVisible(true); // 默认true， 也就行颜色填充

		// 折线图上节点的点击事件，显示该点的坐标
		final Label caption = new Label("");
		caption.setTextFill(Color.BLUE);
		caption.setStyle("-fx-font: 16 arial;");
		for (Data<String, Number> value : series.getData()) {
			value.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					caption.setTranslateX(e.getSceneX());
					caption.setTranslateY(e.getSceneY());
					caption.setText("(" + value.getXValue().toString() + "," + value.getYValue().intValue() + ")");
					System.out.println("(" + value.getXValue().toString() + "," + value.getYValue().intValue() + ")");

				}
			});
		}
		// lineChart.setAlternativeRowFillVisible(false);
		Application.setUserAgentStylesheet(getClass().getResource("caspian.css").toExternalForm());
		pane = new Pane();
		pane.setPrefSize(1200, 600);
		lineChart.prefHeightProperty().bind(pane.heightProperty());
		lineChart.prefWidthProperty().bind(pane.widthProperty().multiply(0.94));
		pane.getChildren().addAll(lineChart, caption);
		return pane;

	}
	
	public Pane setMonthPhoto() throws FileNotFoundException, IOException {

		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Days");

		LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

		lineChart.setTitle("每月日客流量统计表");
		java.util.Random random = new java.util.Random();
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("F:\\temp.txt"));) {
			for (int i = 1; i <= 30; i++) {
				output.writeInt(random.nextInt(10000));
			}
		}
		
		 DataInputStream input = new DataInputStream(new
		 FileInputStream("F:\\temp.txt"));
		 for(int k1=1;k1<=30;k1++) { 
		series.getData().add(new XYChart.Data(k1+"号", input.readInt()));
		  } //添加一组数据
		/* 
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://120.77.222.144:3306/WIFI";
		// MySQL配置时的用户名
		String user = "Root";

		// MySQL配置时的密码
		String password = "abcdef";
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			Connection conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			// statement接口用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
			String sql = "select * from KFC10_half_visitors";

			// 结果集
			ResultSet rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println("进店人数");
			System.out.println("-----------------");

			String ID = null;
			String MAC = null;
			String times = null;
			String distance = null;
			int id = 1, k1 = 0, j = 0;
			while (rs.next()) {

				System.out.println(id + "   " + rs.getInt("visitors") + k1+":"+j+"\n");
				id++;
				series.getData().add(new XYChart.Data("" + k1 + ":" + j, rs.getInt("visitors")));
				j+=30;
				int num=j%60;
				k1+=j/60;
				j=num;
			}

			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {

			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
*/
		lineChart.setLegendVisible(false);// 隐藏图例
		lineChart.getData().add(series);

		// lineChart.setHorizontalGridLinesVisible(false);//中间显示的水平线不显示
		// lineChart.setVerticalGridLinesVisible(false);//中间显示的垂直线不显示
		lineChart.setAlternativeColumnFillVisible(true); // 默认false， 列颜色填充
		lineChart.setAlternativeRowFillVisible(true); // 默认true， 也就行颜色填充

		// 折线图上节点的点击事件，显示该点的坐标
		final Label caption = new Label("");
		caption.setTextFill(Color.BLUE);
		caption.setStyle("-fx-font: 16 arial;");
		for (Data<String, Number> value : series.getData()) {
			value.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					caption.setTranslateX(e.getSceneX());
					caption.setTranslateY(e.getSceneY());
					caption.setText("(" + value.getXValue().toString() + "," + value.getYValue().intValue() + ")");
					System.out.println("(" + value.getXValue().toString() + "," + value.getYValue().intValue() + ")");

				}
			});
		}
		// lineChart.setAlternativeRowFillVisible(false);
		Application.setUserAgentStylesheet(getClass().getResource("caspian.css").toExternalForm());
		pane = new Pane();
		pane.setPrefSize(1200, 600);
		lineChart.prefHeightProperty().bind(pane.heightProperty());
		lineChart.prefWidthProperty().bind(pane.widthProperty().multiply(0.94));
		pane.getChildren().addAll(lineChart, caption);
		return pane;

	}

}
