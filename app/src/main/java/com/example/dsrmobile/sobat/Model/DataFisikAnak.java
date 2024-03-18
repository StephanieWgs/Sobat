package com.example.dsrmobile.sobat.Model;

import java.time.LocalDate;

public class DataFisikAnak {

    private String idData;
    private LocalDate tglData;
    private int berat;
    private int tinggi;
    private int lingkarKepala;

    private Anak anak;

    public DataFisikAnak(){}

    public DataFisikAnak(String idData, LocalDate tglData, int berat, int tinggi, int lingkarKepala, Anak anak) {
        this.idData = idData;
        this.tglData = tglData;
        this.berat = berat;
        this.tinggi = tinggi;
        this.lingkarKepala = lingkarKepala;
        this.anak = anak;
    }

    public String getIdData() {
        return idData;
    }

    public void setIdData(String idData) {
        this.idData = idData;
    }

    public LocalDate getTglData() {
        return tglData;
    }

    public void setTglData(LocalDate tglData) {
        this.tglData = tglData;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getLingkarKepala() {
        return lingkarKepala;
    }

    public void setLingkarKepala(int lingkarKepala) {
        this.lingkarKepala = lingkarKepala;
    }

    public Anak getAnak() {
        return anak;
    }

    public void setAnak(Anak anak) {
        this.anak = anak;
    }
}
