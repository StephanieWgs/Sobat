package com.example.dsrmobile.sobat.Model;

import java.time.LocalDate;

public class Ibu {

    private String idIbu;
    private String namaIbu;
    private String noTelp;
    private LocalDate tglLahirIbu;

    public Ibu(){}

    public Ibu(String idIbu, String namaIbu, String noTelp, LocalDate tglLahirIbu) {
        this.idIbu = idIbu;
        this.namaIbu = namaIbu;
        this.noTelp = noTelp;
        this.tglLahirIbu = tglLahirIbu;
    }

    public String getIdIbu() {
        return idIbu;
    }

    public void setIdIbu(String idIbu) {
        this.idIbu = idIbu;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public LocalDate getTglLahirIbu() {
        return tglLahirIbu;
    }

    public void setTglLahirIbu(LocalDate tglLahirIbu) {
        this.tglLahirIbu = tglLahirIbu;
    }
}
