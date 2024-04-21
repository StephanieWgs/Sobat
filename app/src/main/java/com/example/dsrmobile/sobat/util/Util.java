package com.example.dsrmobile.sobat.util;

import com.example.dsrmobile.sobat.Model.Anak;
import com.example.dsrmobile.sobat.Model.DataFisikAnak;
import com.example.dsrmobile.sobat.Model.Ibu;
import com.example.dsrmobile.sobat.Model.UserLogin;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class Util {

    public static void simpanDataIbu(String idIbu, String namaIbu, String noTelp, String tglLahirIbu,
                              String username, String password){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Ibu ibu = realm.createObject(Ibu.class, idIbu);
                ibu.setNamaIbu(namaIbu);
                ibu.setNoTelp(noTelp);
                ibu.setTglLahirIbu(tglLahirIbu);

                if (ibu.getUserLogin() == null) {
                    //Belum ada user login
                    UserLogin userLogin = realm.createObject(UserLogin.class);
                    userLogin.setUsername(username);
                    userLogin.setPassword(password);
                    ibu.setUserLogin(userLogin);
                }else{
                    ibu.getUserLogin().setUsername(username);
                    ibu.getUserLogin().setPassword(password);
                }
            }
        });
        realm.close();
    }

    public static void updateProfilIbu(String idIbu, String namaIbu, String tglLahir, String noTelp){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Ibu ibu = realm.where(Ibu.class).equalTo("idIbu", idIbu).findFirst();
                if (ibu != null) {
                    ibu.setNamaIbu(namaIbu);
                    ibu.setTglLahirIbu(tglLahir);
                    ibu.setNoTelp(noTelp);
                }
            }
        });
        realm.close();
    }

    public static boolean cekKredensial(String username, String password) {
        Realm realm = Realm.getDefaultInstance();
        UserLogin user = realm.where(UserLogin.class).equalTo("username", username).findFirst();
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }

    public static String getIdIbu(String username) {
        Realm realm = Realm.getDefaultInstance();
        UserLogin userLogin = realm.where(UserLogin.class).equalTo("username", username).findFirst();
        if (userLogin != null) {
            // Jika UserLogin ditemukan, mencari Ibu yang terkait
            Ibu ibu = realm.where(Ibu.class).equalTo("userLogin.username", username).findFirst();
            if (ibu != null) {
                return ibu.getIdIbu();
            }
        }
        return "";

    }

    public static String getNamaIbu(String idIbu){
        Realm realm = Realm.getDefaultInstance();
        Ibu ibu = realm.where(Ibu.class).equalTo("idIbu", idIbu).findFirst();
        return ibu.getNamaIbu();
    }

    public static String getNoTelpIbu(String idIbu){
        Realm realm = Realm.getDefaultInstance();
        Ibu ibu = realm.where(Ibu.class).equalTo("idIbu", idIbu).findFirst();
        return ibu.getNoTelp();
    }

    public static String getTglLahirIbu(String idIbu){
        Realm realm = Realm.getDefaultInstance();
        Ibu ibu = realm.where(Ibu.class).equalTo("idIbu", idIbu).findFirst();
        return ibu.getTglLahirIbu();
    }

    public static boolean usernameAda(String username){
        Realm realm = Realm.getDefaultInstance();
        UserLogin user = realm.where(UserLogin.class).equalTo("username", username).findFirst();
        if (user != null){
            return false; //Username sudah ada
        }
        return true;
    }

    public static String idIbuBaru(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Ibu> ibus = realm.where(Ibu.class).findAll();
        int idIbuBaru = ibus.size() + 1;
        return String.valueOf(idIbuBaru);
    }

    public static void simpanDataAnak(String idAnak, String namaAnak, String tglLahirAnak,
                               String genderAnak, String idIbu){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Anak anak = realm.createObject(Anak.class,idAnak);
                anak.setNamaAnak(namaAnak);
                anak.setTglLahirAnak(tglLahirAnak);
                anak.setGenderAnak(genderAnak);
                anak.setIdIbu(idIbu);
            }
        });
        realm.close();
    }

    public static void updateProfilAnak(String idAnak, String nama, String tglLahir, String gender){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Anak anak = realm.where(Anak.class).equalTo("idAnak", idAnak).findFirst();
                if (anak != null) {
                    anak.setNamaAnak(nama);
                    anak.setTglLahirAnak(tglLahir);
                    anak.setGenderAnak(gender);
                }
            }
        });
        realm.close();
    }

    public static String getNamaAnak(String idAnak){
        Realm realm = Realm.getDefaultInstance();
        Anak anak = realm.where(Anak.class).equalTo("idAnak", idAnak).findFirst();
        return anak.getNamaAnak();
    }

    public static String getTglLahirAnak(String idAnak){
        Realm realm = Realm.getDefaultInstance();
        Anak anak = realm.where(Anak.class).equalTo("idAnak", idAnak).findFirst();
        return anak.getTglLahirAnak();
    }

    public static String idAnakBaru(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Anak> anaks = realm.where(Anak.class).findAll();
        int idAnakBaru = anaks.size() + 1;
        return String.valueOf(idAnakBaru);
    }

    public static void simpanDataFisik(String idData, String tglData, int berat,
                                int tinggi, int lingkarKepala, String idAnak){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                DataFisikAnak dataFisik = realm.createObject(DataFisikAnak.class,idData);
                dataFisik.setTglData(tglData);
                dataFisik.setBerat(berat);
                dataFisik.setTinggi(tinggi);
                dataFisik.setLingkarKepala(lingkarKepala);
                dataFisik.setIdAnak(idAnak);
            }
        });
        realm.close();
    }

    public static String idDataBaru(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<DataFisikAnak> dataFisikAnaks = realm.where(DataFisikAnak.class).findAll();
        int idAnakBaru = dataFisikAnaks.size() + 1;
        return String.valueOf(idAnakBaru);
    }

    public static int getBeratBadan(String idAnak){
        Realm realm = Realm.getDefaultInstance();
        DataFisikAnak dataFisikAnak = realm.where(DataFisikAnak.class).equalTo("idAnak", idAnak).findFirst();
        if (dataFisikAnak != null){
            return dataFisikAnak.getBerat();
        }else{
            return 0;
        }
    }

    public static ArrayList<Ibu> getAllIbu(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Ibu> ibus = realm.where(Ibu.class).findAll();
        ArrayList<Ibu> ibuList = new ArrayList<>(ibus);
        return ibuList;
    }

    public static ArrayList<Anak> getAllAnak(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Anak> anaks = realm.where(Anak.class).findAll();
        ArrayList<Anak> anakList = new ArrayList<>(anaks);
        return anakList;
    }

    public static ArrayList<Anak> cariAnakByIdIbu(ArrayList<Anak> anakArrayList, String idIbu) {
        ArrayList<Anak> anakByIdIbu = new ArrayList<>();
        for (Anak anak : anakArrayList) {
            if (anak.getIdIbu().equals(idIbu)) {
                anakByIdIbu.add(anak);
            }
        }
        return anakByIdIbu;
    }

    public static void clearAll(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
        realm.close();
    }
}
