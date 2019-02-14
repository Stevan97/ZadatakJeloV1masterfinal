package com.example.zadatakjelov1masterfinal.model;

import java.util.Arrays;

public class Jelo {

    private int id;
    private String image;
    private String naziv;
    private String opis;
    private double kalorije;
    private double cena;
    private Category category;
    private String[] sastojci;

    public Jelo() {
        this.naziv = "Klikni na Jelo Ispod";
        this.opis = "Odaberi Jelo za opis";
        this.image = "null.jpg";
        this.sastojci = new String[0];
    }

    public Jelo(int id, String image, String naziv, String opis, double kalorije, double cena,Category category, String[] sastojci) {
        this.id = id;
        this.image = image;
        this.naziv = naziv;
        this.opis = opis;
        this.kalorije = kalorije;
        this.cena = cena;
        this.category = category;
        this.sastojci = sastojci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getKalorije() {
        return kalorije;
    }

    public void setKalorije(double kalorije) {
        this.kalorije = kalorije;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        String text;
        text = "Naziv Jela: " + naziv + "\n" + "Opis: " + opis + "\n" + "Kalorije: " + kalorije + "\n" + "Cena: " + cena + "\n" + "Sastojci: " + Arrays.toString(sastojci);
        text = text.replace("[", "");
        text = text.replace("]", "");
        text = text.trim();
        return text;
    }
}
