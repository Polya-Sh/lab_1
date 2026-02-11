package org.example.lab_1;

public class ConverterModel {
    private double _cels;
    public double get_cels() {
        return _cels;
    }
    public void set_cels(double _cels) {
        this._cels = _cels;
    }

    private double _farng;
    public double get_farng() {
        return _farng;
    }
    public void set_farng(double _farng) {
        this._farng = _farng;
    }

    public double get_kelv() {
        return _kelv;
    }

    public void set_kelv(double _kelv) {
        this._kelv = _kelv;
    }

    private double _kelv;



    public void convertCels() {
        _kelv = Math.round((_cels + 273)*100)/100;
        _farng =  Math.round(((1.8+_cels+32)*100)/100);
    };

    public void convertKelv() {
        _cels =Math.round(((_kelv-273)*100)/100);
        _farng=Math.round(((1.8 *_kelv -459)*100)/100);
    }

    public void convertFarng() {
        _cels = Math.round((((_farng-32)/1.8)*100)/100);
        _kelv=Math.round(((_farng - 32)/1.8+273)*100)/100;
    }
}
