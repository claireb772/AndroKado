package com.example.androkado.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {

    private int id;
    private String nomAmis;
    private String numberTel;

    public Contact() {
    }

    public Contact(int id, String nomAmis, String numberTel) {
        this.id = id;
        this.nomAmis = nomAmis;
        this.numberTel = numberTel;
    }


    protected Contact(Parcel in) {
        id = in.readInt();
        nomAmis = in.readString();
        numberTel = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getNomAmis() {
        return nomAmis;
    }

    public void setNomAmis(String nomAmis) {
        this.nomAmis = nomAmis;
    }

    public String getNumberTel() {
        return numberTel;
    }

    public void setNumberTel(String numberTel) {
        this.numberTel = numberTel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nomAmis);
        parcel.writeString(numberTel);

    }

}
