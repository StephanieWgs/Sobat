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

    public static boolean cekKredensial(String username, String password) {
        Realm realm = Realm.getDefaultInstance();
        UserLogin user = realm.where(UserLogin.class).equalTo("username", username).findFirst();
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
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
    public ArrayList<Ibu> getAllIbu(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Ibu> ibus = realm.where(Ibu.class).findAll();
        ArrayList<Ibu> ibuList = new ArrayList<>(ibus);
        return ibuList;
    }

    public ArrayList<Anak> getAllAnak(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Anak> anaks = realm.where(Anak.class).findAll();
        ArrayList<Anak> anakList = new ArrayList<>(anaks);
        return anakList;
    }

    public static void clearAll(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
        realm.close();
    }
}
