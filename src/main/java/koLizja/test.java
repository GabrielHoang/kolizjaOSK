package koLizja;

import koLizja.encje.*;
import koLizja.generatory.*;

import java.util.ArrayList;
import java.util.List;

public class test {

    static int iloscKursantow = 300000;
    static int iloscInstruktorow = 1000;
    static int iloscUczen = 500000;
    static int liczbaDni = 60;
    static int iloscUczenZmian = 500;

    //przy true generuje mala/pokazowa ilosc danych
    static boolean maloDanych = false;

    public static void main(String[] args) {

        GeneratorKursantow generatorKursantow = new GeneratorKursantow();
        GeneratorInstruktorow generatorInstruktorow = new GeneratorInstruktorow();
        GeneratorKursow generatorKursow = new GeneratorKursow();

        List<Kursant> kursanci = new ArrayList<Kursant>();
        List<Instruktor> instruktorzy = new ArrayList<Instruktor>();
        List<Kurs> kursy = new ArrayList<>();
        List<Ankieta> ankiety;

        if (maloDanych) {
            iloscInstruktorow=6;
            iloscKursantow=10;
            iloscUczen=10;
            iloscUczenZmian=10;
        }

        long start = System.currentTimeMillis();

        int i = 0;
        while(i < iloscKursantow) {
           kursanci.add(generatorKursantow.create(i));
            i+=1;
        }

        if (maloDanych) {
            instruktorzy = generatorInstruktorow.createEveryType();
        } else {
            int j = 0;
            while(j < iloscInstruktorow) {
                instruktorzy.add(generatorInstruktorow.create(j));
                j++;
            }
        }

        kursy = generatorKursow.createEveryType();




        OutputFile.createBulk(kursy,"kursy");
        OutputFile.createBulk(instruktorzy,"instruktorzy");
        OutputFile.createBulk(kursanci,"kursanci");

        System.out.println(iloscInstruktorow + " instruktorow\n"
                + iloscKursantow + " kursantow\n"
                + "Czas generowania:\n" +(System.currentTimeMillis()-start)/1000+ " s");
        System.out.println("Generowanie uczenia");
        start = System.currentTimeMillis();

        GeneratorUczenie generatorUczenie = new GeneratorUczenie(kursy, kursanci, instruktorzy);

        if (maloDanych) {
            generatorUczenie.ustawieniaMalychDanych(1,2,2);
        }

        generatorUczenie.create(iloscUczen);

        System.out.println("Stworzone uczenia: " + generatorUczenie.getStworzoneUczenia());
        OutputFile.createBulk(generatorUczenie.getUczenie(), "uczenia");
        System.out.println("Czas generowania uczenia: " + (System.currentTimeMillis()-start)/1000 + " s");

        //zmiany w czasie
        System.out.println("GENEROWANIE ZMIAN");

        List<Kursant> nowiKursanci = new ArrayList<Kursant>();
        List<Instruktor> nowiInstruktorzy = new ArrayList<Instruktor>();
        List<Ankieta> noweAnkiety = new ArrayList<>();

        GeneratorZmian generatorZmian = new GeneratorZmian(liczbaDni, instruktorzy, kursanci, generatorUczenie);
        nowiKursanci = generatorZmian.createKursanci();
        nowiInstruktorzy = generatorZmian.createInstruktorzy(iloscInstruktorow);

        if(!maloDanych) {
            nowiInstruktorzy.addAll(generatorZmian.modifyInstruktorzy());
        }


        OutputFile.createBulk(nowiInstruktorzy,"instruktorzy_t2");
        OutputFile.createBulk(nowiKursanci,"kursanci_t2");

        System.out.println("Stworzono dodatkowych instruktorow i kursantow");


        //generowanie nowego zbioru uczen
        System.out.println("Generuje nowe uczenia");
        GeneratorUczenie generatorUczenieZmiany = new GeneratorUczenie(kursy,nowiKursanci,instruktorzy);
        generatorUczenieZmiany.wlaczTrybAktualizacji(nowiInstruktorzy);
        generatorUczenieZmiany.setKolejnyTerminKursow(generatorUczenie.getKolejnyTerminKursow());
        if (maloDanych) {
            generatorUczenieZmiany.ustawieniaMalychDanych(2,4,2);
        }
        generatorUczenieZmiany.create(iloscUczenZmian);
        OutputFile.createBulk(generatorUczenieZmiany.getUczenie(),"uczenie_t2");


        //generowanie nowych ankiet

//        System.out.println("Generowanie ankiet");
//        start = System.currentTimeMillis();
//        GeneratorWynikowAnkiet generatorWynikowAnkiet =
//                new GeneratorWynikowAnkiet(instruktorzy,kursy,kursanci,generatorUczenie.getUczenie());
//        generatorWynikowAnkiet.create();
//        ankiety = generatorWynikowAnkiet.getAnkiety();
//        System.out.println("Czas generowania ankiet: " + (System.currentTimeMillis()-start)/1000 + " s");
//        System.out.println("Rozpoczynam zapis ankiet do pliku");
//        start = System.currentTimeMillis();
//        OutputFile.createBulk(ankiety,"ankiety");
//        System.out.println("Czas zapisu ankiet: " + (System.currentTimeMillis()-start)/1000 + " s");
//
//        GeneratorWynikowAnkiet generatorWynikowAnkietZmiany =
//                new GeneratorWynikowAnkiet(instruktorzy,kursy,nowiKursanci,generatorUczenieZmiany.getUczenie());
//        generatorWynikowAnkietZmiany.create();
//        noweAnkiety = generatorWynikowAnkietZmiany.getAnkiety();
//        OutputFile.createBulk(noweAnkiety,"ankiety_t2");


    }



}
