package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    @Test
    public void shouldSetStationNumber() {
        Radio radio = new Radio();
        radio.setStationNumber(5);
        int expected = 5;
        int actual = radio.getStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationNumberIfBelowMin() {
        Radio radio = new Radio();
        radio.setStationNumber(Radio.minStationNumber - 1);
        int expected = 0;
        int actual = radio.getStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationNumberIfAboveMax() {
        Radio radio = new Radio();
        radio.setStationNumber(radio.getMaxStationNumber() + 1);
        int expected = 0;
        int actual = radio.getStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNext() {
        Radio radio = new Radio();
        radio.setStationNumber(1);
        radio.next();
        int expected = 2;
        int actual = radio.getStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNextIfMax() {
        Radio radio = new Radio();
        radio.setStationNumber(radio.getMaxStationNumber());
        radio.next();
        int expected = 0;
        int actual = radio.getStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrev() {
        Radio radio = new Radio();
        radio.setStationNumber(1);
        radio.prev();
        int expected = 0;
        int actual = radio.getStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevIfMin() {
        Radio radio = new Radio();
        radio.setStationNumber(Radio.minStationNumber);
        radio.prev();
        int expected = 9;
        int actual = radio.getStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        int expected = 1;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseVolumeIfMax() {
        Radio radio = new Radio();
        radio.setVolume(Radio.MAX_VOLUME);
        radio.increaseVolume();
        int expected = 100;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.decreaseVolume();
        int expected = 49;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDecreaseVolumeIfMin() {
        Radio radio = new Radio();
        radio.setVolume(Radio.MIN_VOLUME);
        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolumeIfBelowMin() {
        Radio radio = new Radio();
        radio.setVolume(Radio.MIN_VOLUME - 1);
        int expected = 0;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolumeIfAboveMax() {
        Radio radio = new Radio();
        radio.setVolume(Radio.MAX_VOLUME + 1);
        int expected = 0;
        int actual = radio.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationsAmount() {
        Radio radio = new Radio(15);
        int expectedStationsAmount = 15;
        int actualStationsAmount = radio.getStationsAmount();
        int expectedMaxStation = 14;
        int actualMaxStation = radio.getMaxStationNumber();
        Assertions.assertEquals(expectedStationsAmount, actualStationsAmount);
        Assertions.assertEquals(expectedMaxStation, actualMaxStation);
    }

    @Test
    public void shouldNotSetStationsAmountLess1() {
        Radio radio = new Radio(-2);
        int expectedStationsAmount = 10;
        int actualStationsAmount = radio.getStationsAmount();
        int expectedMaxStation = 9;
        int actualMaxStation = radio.getMaxStationNumber();
        Assertions.assertEquals(expectedStationsAmount, actualStationsAmount);
        Assertions.assertEquals(expectedMaxStation, actualMaxStation);
    }
}


