package com.example.androkado.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {
    private int id;
    private String nom;
    private float prix;
    private String description;
    private float note;
    private String url;
    private boolean isAchete;

    public Article() {
    }

    public Article(String nom, float prix, String description, float note, String url, boolean isAchete) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.note = note;
        this.url = url;
        this.isAchete = isAchete;
    }

    public Article(int id, String nom, float prix, String description, float note, String url, boolean isAchete) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.note = note;
        this.url = url;
        this.isAchete = isAchete;
    }

    protected Article(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        prix = in.readFloat();
        description = in.readString();
        note = in.readFloat();
        url = in.readString();
        isAchete = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeFloat(prix);
        dest.writeString(description);
        dest.writeFloat(note);
        dest.writeString(url);
        dest.writeByte((byte) (isAchete ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAchete() {
        return isAchete;
    }

    public void setAchete(boolean achete) {
        isAchete = achete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Article { nom= %s, prix=%s, description= %s, note= %s, url= %s, isAchete= %s }",
                nom, prix, description, note, url, isAchete);
    }
}
