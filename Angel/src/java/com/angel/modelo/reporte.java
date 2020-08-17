package com.angel.modelo;

import java.sql.Date;

public class reporte {
    private int id_reporte;
    private Date fecha;
    private int id_infante;
    private int talla;
    private int peso;
    private double temperatura;
    private int frecuencia_cardiaca;
    private int id_colo_piel;
    private int id_cansa;
    private int id_dolor_g;
    private int id_flema;
    private int id_escuri_n;
    private int id_dolor_ab;
    private int id_nauseas;
    private int id_vomito;
    private int id_dolor_ca;
    private int id_diarrea;

    public reporte(int id_reporte, Date fecha, int id_infante, int talla, int peso, double temperatura, int frecuencia_cardiaca, int id_colo_piel, int id_cansa, int id_dolor_g, int id_flema, int id_escuri_n, int id_dolor_ab, int id_nauseas, int id_vomito, int id_dolor_ca, int id_diarrea) {
        this.id_reporte = id_reporte;
        this.fecha = fecha;
        this.id_infante = id_infante;
        this.talla = talla;
        this.peso = peso;
        this.temperatura = temperatura;
        this.frecuencia_cardiaca = frecuencia_cardiaca;
        this.id_colo_piel = id_colo_piel;
        this.id_cansa = id_cansa;
        this.id_dolor_g = id_dolor_g;
        this.id_flema = id_flema;
        this.id_escuri_n = id_escuri_n;
        this.id_dolor_ab = id_dolor_ab;
        this.id_nauseas = id_nauseas;
        this.id_vomito = id_vomito;
        this.id_dolor_ca = id_dolor_ca;
        this.id_diarrea = id_diarrea;
    }

    public int getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_infante() {
        return id_infante;
    }

    public void setId_infante(int id_infante) {
        this.id_infante = id_infante;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getFrecuencia_cardiaca() {
        return frecuencia_cardiaca;
    }

    public void setFrecuencia_cardiaca(int frecuencia_cardiaca) {
        this.frecuencia_cardiaca = frecuencia_cardiaca;
    }

    public int getId_colo_piel() {
        return id_colo_piel;
    }

    public void setId_colo_piel(int id_colo_piel) {
        this.id_colo_piel = id_colo_piel;
    }

    public int getId_cansa() {
        return id_cansa;
    }

    public void setId_cansa(int id_cansa) {
        this.id_cansa = id_cansa;
    }

    public int getId_dolor_g() {
        return id_dolor_g;
    }

    public void setId_dolor_g(int id_dolor_g) {
        this.id_dolor_g = id_dolor_g;
    }

    public int getId_flema() {
        return id_flema;
    }

    public void setId_flema(int id_flema) {
        this.id_flema = id_flema;
    }

    public int getId_escuri_n() {
        return id_escuri_n;
    }

    public void setId_escuri_n(int id_escuri_n) {
        this.id_escuri_n = id_escuri_n;
    }

    public int getId_dolor_ab() {
        return id_dolor_ab;
    }

    public void setId_dolor_ab(int id_dolor_ab) {
        this.id_dolor_ab = id_dolor_ab;
    }

    public int getId_nauseas() {
        return id_nauseas;
    }

    public void setId_nauseas(int id_nauseas) {
        this.id_nauseas = id_nauseas;
    }

    public int getId_vomito() {
        return id_vomito;
    }

    public void setId_vomito(int id_vomito) {
        this.id_vomito = id_vomito;
    }

    public int getId_dolor_ca() {
        return id_dolor_ca;
    }

    public void setId_dolor_ca(int id_dolor_ca) {
        this.id_dolor_ca = id_dolor_ca;
    }

    public int getId_diarrea() {
        return id_diarrea;
    }

    public void setId_diarrea(int id_diarrea) {
        this.id_diarrea = id_diarrea;
    }

    @Override
    public String toString() {
        return "reporte{" + "id_reporte=" + id_reporte + ", fecha=" + fecha + ", id_infante=" + id_infante + ", talla=" + talla + ", peso=" + peso + ", temperatura=" + temperatura + ", frecuencia_cardiaca=" + frecuencia_cardiaca + ", id_colo_piel=" + id_colo_piel + ", id_cansa=" + id_cansa + ", id_dolor_g=" + id_dolor_g + ", id_flema=" + id_flema + ", id_escuri_n=" + id_escuri_n + ", id_dolor_ab=" + id_dolor_ab + ", id_nauseas=" + id_nauseas + ", id_vomito=" + id_vomito + ", id_dolor_ca=" + id_dolor_ca + ", id_diarrea=" + id_diarrea + '}';
    }
    
}