package org.example;

public class Air implements Alert{
    private int airSpeed;
    private int pressure;

    public Air(int airSpeed, int pressure){
        this.airSpeed = airSpeed;
        this.pressure = pressure;
    }
    public boolean isAirFast() {
        return airSpeed >= 50 ;
    }
    public boolean isTooMuchPressure(){
        return pressure >= 35;
    }

    @Override
    public String[] getAlerts() {
        if (isAirFast() && isTooMuchPressure()) {
            return new String[] {
                    "Cerrar persianas y activar sistema de presion",
                    "Llevar cortavientos y antipresion"};
        }
        if (isAirFast()) {
            return new String[] {
                    "Cerrar persianas",
                    "Llevar cortavientos"};
        }
        if (isTooMuchPressure()) {
            return new String[] {
                    "Activar sistema de presion",
                    "Llevar antipresion"};
        }
        return new String[] {""};
    }

}
