package com.example.dsrmobile.sobat.Model;

import java.time.LocalDate;

import io.realm.RealmObject;

public class Ibu extends RealmObject {

    private String idIbu;
    private String namaIbu;
    private String noTelp;
    private String tglLahirIbu;

    private UserLogin userLogin;

    public Ibu(){

    }

    public Ibu(String idIbu, String namaIbu, String noTelp, String tglLahirIbu) {
        this.idIbu = idIbu;
        this.namaIbu = namaIbu;
        this.noTelp = noTelp;
        this.tglLahirIbu = tglLahirIbu;
        this.userLogin = new UserLogin();
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

    public String getTglLahirIbu() {
        return tglLahirIbu;
    }

    public void setTglLahirIbu(String tglLahirIbu) {
        this.tglLahirIbu = tglLahirIbu;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
}
