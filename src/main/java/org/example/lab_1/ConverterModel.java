package org.example.lab_1;

import javafx.beans.property.SimpleDoubleProperty;

public class ConverterModel {
    SimpleDoubleProperty _cels = new SimpleDoubleProperty();
    SimpleDoubleProperty _kelv = new SimpleDoubleProperty();
    SimpleDoubleProperty _farng = new SimpleDoubleProperty();

    private boolean updating = false;

    public ConverterModel() {
        _cels.addListener((obs, oldVal, newVal) -> {
            if (!updating) {
                updating = true;
                try {
                    double c = newVal.doubleValue();
                    _kelv.set(convertCelsKelv(true));
                    _farng.set(convertCelsFarng(true));
                } finally {
                    updating = false;
                }
            }
        });


        _kelv.addListener((obs, oldVal, newVal) -> {
            if (!updating) {
                updating = true;
                try {
                    double k = newVal.doubleValue();
                    _cels.set(convertKelvCels(true));
                    _farng.set(convertKelvFarng(true));
                } finally {
                    updating = false;
                }
            }
        });

        _farng.addListener((obs, oldVal, newVal) -> {
            if (!updating) {
                updating = true;
                try {
                    double f = newVal.doubleValue();
                    _cels.set(convertFarngCels(true));
                    _kelv.set(convertFarngKelv(true));
                } finally {
                    updating = false;
                }
            }
        });
    }

    public void set_cels(double _cels) {
        this._cels.set(_cels);
    }

    public double get_cels() {
        return _cels.get();
    }

    public SimpleDoubleProperty _celsProperty() {
        return _cels;
    }

    public void set_kelv(double _kelv) {
        this._kelv.set(_kelv);
    }

    public double get_kelv() {
        return _kelv.get();
    }

    public SimpleDoubleProperty _kelvProperty() {
        return _kelv;
    }

    public void set_farng(double _farng) {
        this._farng.set(_farng);
    }

    public double get_farng() {
        return _farng.get();
    }

    public SimpleDoubleProperty _farngProperty() {
        return _farng;
    }

    public double convertCelsKelv(boolean toKelvin) {
        if (toKelvin) {
            return Math.round((_cels.get() + 273.15) * 100) / 100.0; // в кельвин
        } else {
            return Math.round((_kelv.get() - 273.15) * 100) / 100.0; // в цельсия
        }
    }

    public double convertCelsFarng(boolean toFahrenheit) {
        if (toFahrenheit) {
            return Math.round((_cels.get() * 9/5 + 32) * 100) / 100.0; // в фаренгейт
        } else {
            return Math.round(((_farng.get() - 32) * 5/9) * 100) / 100.0; // в цельсия
        }
    }

    public double convertKelvFarng(boolean toFahrenheit) {
        if (toFahrenheit) {
            return Math.round((_kelv.get() * 9/5 - 459.67) * 100) / 100.0; // в фаренгейт
        } else {
            return Math.round(((_farng.get() - 32) * 5/9 + 273.15) * 100) / 100.0; // в кельвин
        }
    }

    public double convertKelvCels(boolean toCelsius) {
        if (toCelsius) {
            return Math.round((_kelv.get() - 273.15) * 100) / 100.0; // в цельсия
        } else {
            return Math.round((_cels.get() + 273.15) * 100) / 100.0; // в кельвин
        }
    }

    public double convertFarngCels(boolean toCelsius) {
        if (toCelsius) {
            return Math.round(((_farng.get() - 32) * 5/9) * 100) / 100.0; // в цельсия
        } else {
            return Math.round((_cels.get() * 9/5 + 32) * 100) / 100.0; // в фаренгейт
        }
    }

    public double convertFarngKelv(boolean toKelvin) {
        if (toKelvin) {
            return Math.round(((_farng.get() - 32) * 5/9 + 273.15) * 100) / 100.0; // в кельвин
        } else {
            return Math.round((_kelv.get() * 9/5 - 459.67) * 100) / 100.0; // в фаренгейт
        }
    }
}