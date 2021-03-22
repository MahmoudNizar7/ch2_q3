/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ControlsController extends Window implements Initializable {

    @FXML
    private MenuItem menuOpen;
    @FXML
    private MenuItem menuClose;
    @FXML
    private MenuItem menuSave;
    @FXML
    private MenuItem menuExit;
    @FXML
    private MenuItem colorGold;
    @FXML
    private MenuItem colorCyan;
    @FXML
    private MenuItem colorRed;
    @FXML
    private Menu menuAbout;
    @FXML
    private Slider slider;
    @FXML
    private TextArea textareaField;
    @FXML
    private ComboBox<String> comboBoxField;
    @FXML
    private WebView webViewField;

    private File selectedFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        comboBoxField.getItems().addAll("Instructor GitHub", "JavaFx Guide", "Ma7moudNizar");
    }

    @FXML
    private void OpenFile(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src/assignment2_q3"));
        selectedFile = fileChooser.showOpenDialog(this);
        textareaField.appendText("\n");

        try {

            Scanner scanner = new Scanner(selectedFile);
            while (scanner.hasNext()) {
                textareaField.appendText(scanner.nextLine() + "\n");
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void CloseFile(ActionEvent event) {

        textareaField.setText("");

    }

    @FXML
    private void SaveFile(ActionEvent event) {


        try {

            FileWriter writer = new FileWriter(selectedFile);

            writer.write(textareaField.getText());
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void ExitWindow(ActionEvent event) {

        Platform.exit();

    }

    @FXML
    private void changeColorGold(ActionEvent event) {

        textareaField.setStyle("-fx-control-inner-background: gold;");

    }

    @FXML
    private void changeColorCyan(ActionEvent event) {

        textareaField.setStyle("-fx-control-inner-background: cyan");

    }

    @FXML
    private void changeColorRed(ActionEvent event) {

        textareaField.setStyle("-fx-control-inner-background: red");

    }

    @FXML
    private void ShowAboutMe(ActionEvent event) {

        Label name = new Label("Mahmoud N Abo-Nima");
        Label id = new Label("120181067");
        Label course = new Label("Programming 3");

        VBox vBox = new VBox(10, name, id, course);
        vBox.setAlignment(Pos.CENTER);

        FlowPane flowPane = new FlowPane(vBox);
        flowPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(flowPane, 150, 150);

        Stage myDialog = new Stage();
        myDialog.setScene(scene);
        myDialog.show();

    }

    @FXML
    private void comboBoxAction(ActionEvent event) {

        String action = comboBoxField.getValue().toString();
        if (action.equalsIgnoreCase("Instructor GitHub")) {

            webViewField.getEngine().load("https://github.com/aashgar");

        } else if (action.equalsIgnoreCase("JavaFx Guide")) {

            webViewField.getEngine().load("https://www.tutorialspoint.com/javafx/index.htm");

        } else if (action.equalsIgnoreCase("Ma7moudNizar")) {

            webViewField.getEngine().load("https://github.com/MahmoudNizar7");

        }


    }

    @FXML
    private void sliderAction(MouseEvent event) {

        textareaField.setStyle("-fx-font-size:" + slider.getValue() + "pt");

    }

}
