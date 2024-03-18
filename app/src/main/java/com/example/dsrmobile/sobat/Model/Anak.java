package com.example.dsrmobile.sobat.Model;

import java.time.LocalDate;

public class Anak {
    private String idAnak;
    private String namaAnak;
    private LocalDate tglLahirAnak;
    private String genderAnak;
    private String idIbu;

    public Anak(){}

    public Anak(String idAnak, String namaAnak, LocalDate tglLahirAnak, String genderAnak, String idIbu) {
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

    public LocalDate getTglLahirAnak() {
        return tglLahirAnak;
    }

    public void setTglLahirAnak(LocalDate tglLahirAnak) {
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
