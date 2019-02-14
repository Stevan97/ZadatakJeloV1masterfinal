package com.example.zadatakjelov1masterfinal.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String naziv;
    private List<Jelo> jela;

    public Category() {
        this.jela = new ArrayList<>();
    }

    public Category(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Jelo> getJela() {
        return jela;
    }

    public void setJela(List<Jelo> jela) {
        this.jela = jela;
    }

    @Override
    public String toString() {
        return "Category{" +
                "naziv='" + naziv + '\'' +
                '}';
    }
}
