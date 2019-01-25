package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/accountUI.fxml"));
        primaryStage.setTitle("User Login");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/sample/resources/css/style.css");

        Image image = new Image("/sample/resources/login.png");
        primaryStage.getIcons().add(image);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
