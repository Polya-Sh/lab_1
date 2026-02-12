package org.example.lab_1;

import javafx.beans.property.SimpleDoubleProperty;

public class ConverterModel {


    SimpleDoubleProperty _cels = new SimpleDoubleProperty();
    public void set_cels(double _cels) {
        this._cels.set(_cels);
    }
    public double get_cels() {
        return _cels.get();
    }
    public SimpleDoubleProperty _celsProperty() {
        return _cels;
    }


    SimpleDoubleProperty _kelv = new SimpleDoubleProperty();
    public double get_kelv() {
        return _kelv.get();
    }
    public SimpleDoubleProperty _kelvProperty() {
        return _kelv;
    }
    public void set_kelv(double _kelv) {
        this._kelv.set(_kelv);
    }

    SimpleDoubleProperty _farng = new SimpleDoubleProperty();
    public void set_farng(double _farng) {
        this._farng.set(_farng);
    }
    public double get_farng() {
        return _farng.get();
    }
    public SimpleDoubleProperty _farngProperty() {
        return _farng;
    }

    void test(){
        _cels.bind(_kelv);
        _cels.bind(_farng);
    }

    public double covertCelsKelv(){
        if (true) {
            return Math.round((_cels + 273)*100)/100;         // в кельвин
        }
        else{
            return Math.round((_cels + 273)*100)/100; // в цельсия
        }
    };
    public double covertCelsFarng(){
        if (true) {
            return Math.round(((1.8+_cels+32)*100)/100); // в фарингейт
        }
        else {
            return Math.round((((_farng-32)/1.8)*100)/100); // в цельсия
        }
    };
    public double covertKelvFarng(){
        if (true) {
            return Math.round(((_farng - 32)/1.8+273)*100)/100;         // в кельвин
        }
        else{
            return Math.round(((1.8 *_kelv -459)*100)/100); // в фарингейт
        }
    };
}