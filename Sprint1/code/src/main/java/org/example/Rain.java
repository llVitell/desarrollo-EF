package org.example;

public class Rain implements Alert{
    private int rain;
    private int humidity;

    public Rain(int rain, int humidity) {
        this.rain = rain;
        this.humidity = humidity;
    }
    public boolean isTooMuchRain() {
        return rain >= 20;
    }
    public boolean isTooMuchHumidity() {
        return humidity >= 70;
    }

    @Override
    public String[] getAlerts() {
        if (isTooMuchHumidity() && isTooMuchRain()) {
            return new String[] {
                    "Activar sistema de humedad y riego",
                    "Llevar paraguas y abrigarse bien"};
        }
        if (isTooMuchRain()) {
            return new String[] {
                    "Activar sistema de riego",
                    "Llevar paraguas"};
        }
        if (isTooMuchHumidity()) {
            return new String[] {
                    "Activar sistema de humedad",
                    "Llevar paraguas"};
        }
        return new String[] {""};
    }
}
