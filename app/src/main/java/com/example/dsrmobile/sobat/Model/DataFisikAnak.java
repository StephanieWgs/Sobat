package com.example.dsrmobile.sobat.Model;

import java.time.LocalDate;

import io.realm.RealmObject;

public class DataFisikAnak extends RealmObject{

    private String idData;
    private String tglData;
    private int berat;
    private int tinggi;
    private int lingkarKepala;

    private String idAnak;

    public DataFisikAnak(){}

    public DataFisikAnak(String idData, String tglData, int berat, int tinggi, int lingkarKepala
    , String idAnak) {
        this.idData = idData;
        this.tglData = tglData;
        this.berat = berat;
        this.tinggi = tinggi;
        this.lingkarKepala = lingkarKepala;
        this.idAnak = idAnak;
    }

    public String getIdData() {
        return idData;
    }

    public void setIdData(String idData) {
        this.idData = idData;
    }

    public String getTglData() {
        return tglData;
    }

    public void setTglData(String tglData) {
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

    public String getIdAnak() {
        return idAnak;
    }

    public void setIdAnak(String idAnak) {
        this.idAnak = idAnak;
    }
}
