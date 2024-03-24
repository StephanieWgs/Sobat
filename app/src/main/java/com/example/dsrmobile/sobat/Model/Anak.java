package com.example.dsrmobile.sobat.Model;

import java.time.LocalDate;

import io.realm.RealmObject;

public class Anak extends RealmObject {
    private String idAnak;
    private String namaAnak;
    private String tglLahirAnak;
    private String genderAnak;
    private String idIbu;

    public Anak(){}

    public Anak(String idAnak, String namaAnak, String tglLahirAnak, String genderAnak, String idIbu) {
        this.idAnak = idAnak;
        this.namaAnak = namaAnak;
        this.tglLahirAnak = tglLahirAnak;
        this.genderAnak = genderAnak;
        this.idIbu = idIbu;
    }

    public String getIdAnak() {
        return idAnak;
    }

    public void setIdAnak(String idAnak) {
        this.idAnak = idAnak;
    }

    public String getNamaAnak() {
        return namaAnak;
    }

    public void setNamaAnak(String namaAnak) {
        this.namaAnak = namaAnak;
    }

    public String getTglLahirAnak() {
        return tglLahirAnak;
    }

    public void setTglLahirAnak(String tglLahirAnak) {
        this.tglLahirAnak = tglLahirAnak;
    }

    public String getGenderAnak() {
        return genderAnak;
    }

    public void setGenderAnak(String genderAnak) {
        this.genderAnak = genderAnak;
    }

    public String getIdIbu() {
        return idIbu;
    }

    public void setIdIbu(String idIbu) {
        this.idIbu = idIbu;
    }
}
