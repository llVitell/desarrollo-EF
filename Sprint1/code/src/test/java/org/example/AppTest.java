package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class    AppTest {
    @Mock
    Rain mockRain;
    @Mock
    Air mockAir;
    @Mock
    Temperature mockTemperature;

    @Test
    void airEventsShouldWork(){
        Air air = new Air(50,35);
        assertThat(air.isAirFast()).isEqualTo(true);
        assertThat(air.isTooMuchPressure()).isEqualTo(true);
    }
    @Test
    void rainEventsShouldWork(){
        Rain rain = new Rain(20,70);
        assertThat(rain.isTooMuchRain()).isEqualTo(true);
        assertThat(rain.isTooMuchHumidity()).isEqualTo(true);
    }
    @Test
    void airAlertsShouldWork(){
        Air air = new Air(50,35);
        assertThat(air.getAlerts()).isEqualTo(new String[] {
                "Cerrar persianas y activar sistema de presion", "Llevar cortavientos y antipresion"});
        assertThat(new Air(50,15).getAlerts()).isEqualTo(new String[] {
                "Cerrar persianas", "Llevar cortavientos"});
        assertThat(new Air(25,35).getAlerts()).isEqualTo(new String[] {
                "Activar sistema de presion", "Llevar antipresion"});
        assertThat(new Air(25,25).getAlerts()).isEqualTo(new String[] {""});
    }
    @Test
    void rainAlertsShouldWork() {
        Rain rain = new Rain(20,70);
        assertThat(rain.getAlerts()).isEqualTo(new String[] {
                "Activar sistema de humedad y riego", "Llevar paraguas y abrigarse bien"});
        assertThat(new Rain(20,50).getAlerts()).isEqualTo(new String[] {
                "Activar sistema de riego", "Llevar paraguas"});
        assertThat(new Rain(15,70).getAlerts()).isEqualTo(new String[] {
                "Activar sistema de humedad", "Llevar paraguas"});
        assertThat(new Rain(15,20).getAlerts()).isEqualTo(new String[] {""});
    }
    @Test
    void temperatureEventsShouldWork(){
        Temperature temperature = new Temperature(35);
        assertThat(temperature.isTooHot()).isEqualTo(true);
    }
    @Test
    void temperatureAlertsShouldWork(){
        Temperature temperature = new Temperature(35);
        assertThat(temperature.getAlerts()).isEqualTo(new String[] {
                "Activar sistema de alta temperatura", "Llevar ropa veraniega"});
        assertThat(new Temperature(10).getAlerts()).isEqualTo(new String[] {"Activar calefacioon","Abrigarse bien"});
    }
    @Test
    void airAlertsAndEventsShouldWork(){
        when(mockAir.isAirFast()).thenReturn(true);
        when(mockAir.getAlerts()).thenReturn(new String[] {"Cerrar persianas"});
        assertTrue(mockAir.isAirFast());
        assertThat(mockAir.getAlerts()).isEqualTo(new String[] {"Cerrar persianas"});
        verify(mockAir).isAirFast();
    }
    @Test
    void airExtremeWeatherConditions(){
        Air air = new Air(1000,1000);
        assertTrue(air.isAirFast());
    }
    @Test
    void rainAlertsAndEventsShouldWork(){
        when(mockRain.isTooMuchRain()).thenReturn(true);
        when(mockRain.getAlerts()).thenReturn(new String[] {"Activar sistema de riego"});
        assertTrue(mockRain.isTooMuchRain());
        assertThat(mockRain.getAlerts()).isEqualTo(new String[] {"Activar sistema de riego"});
        verify(mockRain).isTooMuchRain();
    }
    @Test
    void rainExtremeWeatherConditions(){
        Rain rain = new Rain(1000,1000);
        assertTrue(rain.isTooMuchRain());
    }
    @Test
    void templertsAndEventsShouldWork(){
        when(mockTemperature.isTooHot()).thenReturn(true);
        when(mockTemperature.getAlerts()).thenReturn(new String[] {
                "Activar sistema de alta temperatura", "Llevar ropa veraniega"});
        assertTrue(mockTemperature.isTooHot());
        assertThat(mockTemperature.getAlerts()).isEqualTo(new String[] {
                "Activar sistema de alta temperatura", "Llevar ropa veraniega"});
        verify(mockTemperature).isTooHot();
    }
    @Test
    void tempExtremeWeatherConditions(){
        Temperature temperature = new Temperature(1000);
        assertTrue(temperature.isTooHot());
    }

}