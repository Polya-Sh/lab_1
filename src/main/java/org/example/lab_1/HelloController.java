package org.example.lab_1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    ConverterModel convert = new ConverterModel();

    @FXML
    public Button output;
    @FXML
    private TextField cels;
    @FXML
    private TextField kelv;
    @FXML
    private TextField farng;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cels.textProperty().bindBidirectional(convert._celsProperty(), new NumberStringConverter());
        kelv.textProperty().bindBidirectional(convert._kelvProperty(), new NumberStringConverter());
        farng.textProperty().bindBidirectional(convert._farngProperty(), new NumberStringConverter());
    }

    public void click_output(ActionEvent actionEvent) {
        try {
            double celsius = convert.get_cels();

            if (celsius <= -20) {
                output.setText("Холодно");
                output.setStyle("-fx-background-color: blue;");
            } else if (celsius > -20 && celsius < 10) {
                output.setText("Прохладно");
                output.setStyle("-fx-background-color: lightblue;");
            } else if (celsius >= 10 && celsius <= 20) {
                output.setText("Нормально");
                output.setStyle("-fx-background-color: lightgreen;");
            } else if (celsius > 20) {
                output.setText("Жарко");
                output.setStyle("-fx-background-color: lightred;");
            }
        } catch (Exception e) {
            output.setText("Ошибка");
        }
    }
}