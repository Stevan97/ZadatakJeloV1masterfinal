package com.example.zadatakjelov1masterfinal.providers;

import com.example.zadatakjelov1masterfinal.model.Category;
import com.example.zadatakjelov1masterfinal.model.Jelo;

import java.util.ArrayList;
import java.util.List;

public class JeloProvider {

    private static Category rostilj = new Category(0,"Rostilj");
    private static Category pice = new Category(1,"Pice");
    private static Category corbe = new Category(2,"Corbe");

    private static String[] sastojciPljeska = {"Meso, luk, soja"};
    private static String[] sastojciSpikovana = {"Meso, luk, soja, sir, sunka"};
    private static String[] sastojciCevapi = {"Junetina, biber, luk, so"};
    private static String[] sastojciPicaSunka = {"Kore, kackavalj, sunka, sir, sampinjoni"};
    private static String[] sastojciPicaKulen = {"Kore, kackavalj, kulen, sir, sampinjoni"};
    private static String[] sastojciCorbe = {"Krompir, ulje, brasno, voda"};



    public static List<Jelo> getJela() {
        List<Jelo> jela = new ArrayList<>();
        jela.add(new Jelo(0,"rostilj.jpg","Obicna Pljeskavica","70% Junece meso, 30% svinjsko",200,210,rostilj,sastojciPljeska));
        jela.add(new Jelo(1,"spikovana.jpg","Spikovana Pljeskavica","Pljeskavica sa sirom",250,280,rostilj,sastojciSpikovana));
        jela.add(new Jelo(2,"cevapi.jpg","Cevapi","Cevapi 10 kom",300,350,rostilj,sastojciCevapi));
        jela.add(new Jelo(3,"capricoza.jpg","Pizza Capricoza","Pizza sa sunkom",290,150,pice,sastojciPicaSunka));
        jela.add(new Jelo(4,"kulen.jpg","Pizza Kulen","Pizza sa kulenom i sirom",340,200,pice,sastojciPicaKulen));
        jela.add(new Jelo(5,"corba.jpg","Juneca Corba","Corba sa junetinom",100,120,corbe,sastojciCorbe));
        jela.add(new Jelo(6,"corba.jpg","Pileca Corba","Corba sa piletinom",120,130,corbe,sastojciCorbe));
        return jela;
    }

    public static List<String> getJelaNames() {
        List<String> listaImena = new ArrayList<>();
        for (Jelo j: getJela()) {
            listaImena.add(j.getNaziv());
        }
        return listaImena;
    }

    public static List<String> getJeloNameByCategoryId(int id) {
        List<String> listaImena = new ArrayList<>();
        for (Jelo j: getJela()) {
            if (j.getCategory().getId() == id) {
                listaImena.add(j.getNaziv());
            }
        }
        return listaImena;
    }

    public static Jelo jeloNull() {
        return new Jelo();
    }

    public static Jelo getJeloByName(String string) {
        for (Jelo j: getJela()) {
            if (j.getNaziv().equals(string)) {
                return j;
            }
        }
        return null;
    }

    public static List<String> getJeloById(int id) {

        List<String> listaImena = new ArrayList<>();
        for (Jelo j: getJela()) {
            if (j.getId() == id) {
                listaImena.add(j.getNaziv());

            }
        }
        return listaImena;

    }




}