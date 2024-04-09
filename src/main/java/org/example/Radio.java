package org.example;

public class Radio {
    private int stationsAmount = 10;
    public final static int minStationNumber = 0;
    private int maxStationNumber = stationsAmount - 1;


    public final static int MAX_VOLUME = 100;
    public final static int MIN_VOLUME = 0;
    private int stationNumber;
    private int currentVolume;

    public Radio(int stationsAmount) {
        if (stationsAmount > 0) {
            this.stationsAmount = stationsAmount;
            this.maxStationNumber = stationsAmount - 1;
        }
    }

    public Radio() {
    }

    public int getStationsAmount() {
        return stationsAmount;
    }

    public int getMaxStationNumber() {
        return maxStationNumber;
    }


    public int getVolume() {
        return currentVolume;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setVolume(int newCurrentVolume) {
        if (newCurrentVolume < MIN_VOLUME) {
            return;
        }
        if (newCurrentVolume > MAX_VOLUME) {
            return;
        }
        currentVolume = newCurrentVolume;

    }

    public void setStationNumber(int newStationNumber) {
        if (newStationNumber < minStationNumber) {
            return;
        }
        if (newStationNumber > maxStationNumber) {
            return;
        }
        stationNumber = newStationNumber;

    }

    public void next() {
        if (stationNumber < maxStationNumber) {
            setStationNumber(stationNumber + 1);
        } else {
            setStationNumber(minStationNumber);
        }
    }

    public void prev() {
        if (stationNumber > minStationNumber) {
            setStationNumber(stationNumber - 1);
        } else {
            setStationNumber(maxStationNumber);
        }
    }

    public void increaseVolume() {
        if (currentVolume < MAX_VOLUME) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > MIN_VOLUME) {
            currentVolume--;
        }
    }


}
