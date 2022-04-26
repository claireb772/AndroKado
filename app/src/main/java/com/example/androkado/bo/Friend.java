package com.example.androkado.bo;

public class Friend {

    private String nomAmis;
    private String numberTel;

    public Friend() {
    }

    public Friend(String nomAmis, String numberTel) {
        this.nomAmis = nomAmis;
        this.numberTel = numberTel;
    }

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
}
