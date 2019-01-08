package LoginGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Application.fxml"));
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(root, 1300, 980));
        Scene scene = primaryStage.getScene();
        scene.getStylesheets().add("LoginGUI/cssApplication.css");
        primaryStage.setTitle("Salon samochodowy v1.0");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
