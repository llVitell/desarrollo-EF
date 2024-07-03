package org.example;

public class Temperature implements Alert {
    private int temperature;
    public Temperature(int temperature){
        this.temperature = temperature;
    }
    public boolean isTooHot(){
        return temperature >= 35;
    }
    @Override
    public String[] getAlerts() {
        if (isTooHot()) {
            return new String[] {
                    "Activar sistema de alta temperatura",
                    "Llevar ropa veraniega"};
        }
        return new String[] {"Activar calefacioon","Abrigarse bien"};
    }
}
