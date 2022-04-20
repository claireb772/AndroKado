package com.example.androkado;

public class Article {
    private String nom;
    private int prix;
    private String description;
    private float note;
    private String url;
    private boolean isAchete;

    public Article(String nom, int prix, String description, float note, String url, boolean isAchete) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.note = note;
        this.url = url;
        this.isAchete = isAchete;
    }

    public Article() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
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
}
