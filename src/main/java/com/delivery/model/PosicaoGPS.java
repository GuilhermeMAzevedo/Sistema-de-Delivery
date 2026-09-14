package com.delivery.model;

import java.time.LocalDateTime;

public class PosicaoGPS {
    private double latitude;
    private double longitude;
    private LocalDateTime horario;

    public PosicaoGPS(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
        this.horario = LocalDateTime.now();
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LocalDateTime getHorario() {
        return horario;
    }
}
