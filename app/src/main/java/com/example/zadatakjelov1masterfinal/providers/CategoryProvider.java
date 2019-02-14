package com.example.zadatakjelov1masterfinal.providers;

import com.example.zadatakjelov1masterfinal.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryProvider {

    public static List<Category> getCategorys() {
        List<Category> kategorije = new ArrayList<>();
        kategorije.add(new Category(0,"Rostilj"));
        kategorije.add(new Category(1,"Pice"));
        kategorije.add(new Category(2,"Corbe"));
        return kategorije;
    }

    public static List<String> getCategorysNames() {
        List<String> listaImena = new ArrayList<>();
        for (Category c: getCategorys()) {
            listaImena.add(c.getNaziv());
        }
        return listaImena;
    }

    public static Category getCategoryById(int id) {
        switch (id) {
            case 1:
                return new Category(0,"Rostilj");
            case 2:
                return new Category(1,"Pice");
            case 3:
                return new Category(2,"Corbe");
            default:
                return null;
        }
    }

}