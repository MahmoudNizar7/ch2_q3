package assignment2_q3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("controls.fxml"));
        // fxmlLoader.setController(this);

        //FlowPane flowPane = fxmlLoader.load();
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Advanced JavaFX Screen");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
