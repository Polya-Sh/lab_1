package org.example.lab_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {
    ConverterModel convert=new ConverterModel();

    @FXML
    public Button output;
    @FXML
    private TextField cels;
    @FXML
    private TextField kelv;
    @FXML
    private TextField farng;



    @FXML
    protected void buttom_cels(){
        convert.set_cels(Double.parseDouble(cels.getText()));
        convert.convertCels();
        kelv.setText(String.valueOf(convert.get_kelv()));
        farng.setText(String.valueOf(convert.get_farng()));

    }

    @FXML
    protected void button_kelv(){
        convert.set_kelv(Double.parseDouble(kelv.getText()));
        convert.convertKelv();
        cels.setText(String.valueOf(convert.get_cels()));
        farng.setText(String.valueOf(convert.get_farng()));
    }

    @FXML
    public void button_farng() {
        convert.set_farng(Double.parseDouble(farng.getText()));
        convert.convertFarng();
        cels.setText(String.valueOf(convert.get_cels()));
        kelv.setText(String.valueOf(convert.get_kelv()));
    }
}