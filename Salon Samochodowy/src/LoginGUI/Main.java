package LoginGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    static Connection connection;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        primaryStage.setScene(new Scene(root, 300, 350));
        Scene scene = primaryStage.getScene();
        scene.getStylesheets().add("LoginGUI/cssLogin.css");
        primaryStage.setTitle("Salon samochodowy v1.0");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
