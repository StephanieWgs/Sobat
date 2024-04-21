package com.example.dsrmobile.sobat.Model;

import java.time.LocalDate;
import java.time.Period;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

@RealmClass
public class Anak extends RealmObject {
    @PrimaryKey
    private String idAnak;
    @Required
    private String namaAnak;
    @Required
    private String tglLahirAnak;
    @Required
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

    public int getUmurAnak(){
        LocalDate tanggalLahir = LocalDate.parse(tglLahirAnak);
        LocalDate hariIni = LocalDate.now();

        // Menghitung periode antara tanggal lahir dan hari ini
        Period periode = Period.between(tanggalLahir, hariIni);

        // Mengembalikan umur dalam tahun
        return periode.getYears();
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
