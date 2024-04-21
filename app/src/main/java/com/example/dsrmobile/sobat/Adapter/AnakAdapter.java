package com.example.dsrmobile.sobat.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dsrmobile.sobat.Model.Anak;
import com.example.dsrmobile.sobat.R;
import com.example.dsrmobile.sobat.util.Util;

import java.util.ArrayList;
import android.content.SharedPreferences;

public class AnakAdapter extends ArrayAdapter<Anak> {

    private ArrayList<Anak> anakArrayList;
    Context context;

    public AnakAdapter(ArrayList<Anak> anakArrayList, Context context) {
        super(context,R.layout.item_list_layout,anakArrayList);
        this.anakArrayList = anakArrayList;
        this.context = context;
    }

    private static class MyViewHolder{
        ImageView imageAnak;
        TextView namaAnak;
        TextView umurAnakV1;
        TextView umurAnakV2;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Anak anak = getItem(position);
        final View result;

        MyViewHolder myViewHolder = new MyViewHolder();

        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_layout,parent,false);

            myViewHolder.imageAnak = (ImageView) convertView.findViewById(R.id.imageAnak);
            myViewHolder.namaAnak = (TextView) convertView.findViewById(R.id.namaAnak);
            myViewHolder.umurAnakV1 = (TextView) convertView.findViewById(R.id.umurAnakV1);
            myViewHolder.umurAnakV2 = (TextView) convertView.findViewById(R.id.umurAnakV2);

            convertView.setTag(myViewHolder);
        }
        else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        result = convertView;
        if (anak.getGenderAnak().equalsIgnoreCase("Laki-laki")) {
            myViewHolder.imageAnak.setImageResource(R.drawable.boy);
        } else {
            myViewHolder.imageAnak.setImageResource(R.drawable.girl);
        }

        // Simpan ID anak sebagai tag pada convertView
        convertView.setTag(R.id.idAnak, anak.getIdAnak());

        myViewHolder.namaAnak.setText(anak.getNamaAnak());
        myViewHolder.umurAnakV1.setText("Masuk tahun ke-" +anak.getUmurAnak());
        myViewHolder.umurAnakV2.setText(anak.getUmurAnak() + " tahun");

        return result;
    }

}
