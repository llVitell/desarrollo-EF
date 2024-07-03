package org.example;

import java.util.Scanner;

public class Weather {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Temperatura (en Celsius): ");
        int temp = scanner.nextInt();
        System.out.println("Cantidad de lluvia (en mm): ");
        int rainQty = scanner.nextInt();
        System.out.println("Velocidad del viento (en km/h): ");
        int airSpeed = scanner.nextInt();
        System.out.println("Humedad (en %): ");
        int humidity = scanner.nextInt();
        System.out.println("Presion Atmosferica (en hPa): ");
        int pressure = scanner.nextInt();

        Air air = new Air(airSpeed,pressure);
        Rain rain = new Rain(rainQty,humidity);
        Temperature temperature = new Temperature(temp);

        System.out.println(air.getAlerts());
    }
}