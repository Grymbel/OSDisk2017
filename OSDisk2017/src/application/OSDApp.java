package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OSDApp extends Application {
	public Stage primarystage;
	private Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("OSDView.fxml"));
			GridPane root = loader.load();

			Scene scene = new Scene(root, 800, 600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("OSDisk 2017");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
