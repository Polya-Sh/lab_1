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

        convert.set_cels(0.0);
        convert.set_kelv(273.15);
        convert.set_farng(32.0);

        cels.textProperty().bindBidirectional(convert._celsProperty(), new NumberStringConverter());
        kelv.textProperty().bindBidirectional(convert._kelvProperty(), new NumberStringConverter());
        farng.textProperty().bindBidirectional(convert._farngProperty(), new NumberStringConverter());
    }

    public void click_output(ActionEvent actionEvent) {
        String celsiusText = cels.getText().trim();

        if (celsiusText.isEmpty() || !celsiusText.matches("^-?\\d+[.,]?\\d*$")) {
            output.setText("Некорректный ввод");
            output.setStyle("-fx-background-color: gray;");
            return;
        }

        String kelvinText = kelv.getText().trim();

        if (kelvinText.isEmpty() || !kelvinText.matches("^-?\\d+[.,]?\\d*$")) {
            output.setText("Некорректный ввод");
            output.setStyle("-fx-background-color: gray;");
            return;
        }
        String faringText = farng.getText().trim();

        if (faringText.isEmpty() || !faringText.matches("^-?\\d+[.,]?\\d*$")) {
            output.setText("Некорректный ввод");
            output.setStyle("-fx-background-color: gray;");
            return;
        }


        try {
            celsiusText = celsiusText.replace(',', '.');
            double celsius = Double.parseDouble(celsiusText);
            kelvinText = kelvinText.replace(',', '.');
            double kelvin = Double.parseDouble(celsiusText);
            faringText = faringText.replace(',', '.');
            double faring = Double.parseDouble(faringText);

            if (celsius <= -20) {
                output.setText("Холодно");
                output.setStyle("-fx-background-color: blue;");
            } else if (celsius < 10 && celsius > -20) {
                output.setText("Прохладно");
                output.setStyle("-fx-background-color: lightblue;");
            } else if (celsius <= 20 && celsius > 10) {
                output.setText("Нормально");
                output.setStyle("-fx-background-color: lightgreen;");
            } else {
                output.setText("Жарко");
                output.setStyle("-fx-background-color: red;");
            }

        } catch (NumberFormatException e) {
            output.setText("Некорректный ввод");
            output.setStyle("-fx-background-color: gray;");
        }
    }
    }