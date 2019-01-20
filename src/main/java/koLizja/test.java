package koLizja;

import koLizja.encje.*;
import koLizja.generatory.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class test {

    static int iloscKursantow = 150000;
    static int iloscInstruktorow = 20000;
    static int iloscUczen = 250000;
    static int liczbaDni = 360;
    static int iloscUczenZmian = 500;

    //przy true generuje mala/pokazowa ilosc danych
    static boolean maloDanych = false;

    public static void main(String[] args) {

        GeneratorKursantow generatorKursantow = new GeneratorKursantow();
        GeneratorInstruktorow generatorInstruktorow = new GeneratorInstruktorow();
        GeneratorKursow generatorKursow = new GeneratorKursow();
        GeneratorUczenie generatorUczenie;
        GeneratorWynikowAnkiet generatorWynikowAnkiet;

        //Listy z wygenerowanymi danymi
        List<Kursant> kursanci = new ArrayList<Kursant>();
        List<Instruktor> instruktorzy = new ArrayList<Instruktor>();
        List<Kurs> kursy;
        List<Uczenie> uczenia;

        //zmienne
        int i;
        float  elapsedTime;
        Instant start, end;

        System.out.println("---------------------------------------");
        System.out.println("Wprowadzone dane:");
        System.out.println("kursanci: " + iloscKursantow);
        System.out.println("instruktorzy: " + iloscInstruktorow);
        System.out.println("uczenia: " + iloscUczen);
        System.out.println("---------------------------------------");
        start = Instant.now();

        //Generowanie danych
        for(i = 1; i <= iloscKursantow; i++) {
            kursanci.add(generatorKursantow.create(i));
        }
        for(i = 1; i <= iloscInstruktorow; i++) {
            instruktorzy.add(generatorInstruktorow.create(i));
        }
        kursy = generatorKursow.createEveryType();

        generatorUczenie = new GeneratorUczenie(kursy,kursanci,instruktorzy);
        generatorUczenie.create(iloscUczen);
        uczenia = generatorUczenie.getUczenie();
        //-------------------------------------------------------
        //generowanie ankiet zajmuje dużo czasu
        generatorWynikowAnkiet = new GeneratorWynikowAnkiet(instruktorzy,kursy,kursanci,uczenia);
        generatorWynikowAnkiet.create();
        //-------------------------------------------------------
        //zapis do plików
        OutputFile.createCsv(kursanci,"kursanci");
        OutputFile.createCsv(instruktorzy,"instruktorzy");
        OutputFile.createCsv(kursy, "kursy");
        OutputFile.createCsv(uczenia, "uczenia");
        OutputFile.createCsv(generatorWynikowAnkiet.getAnkiety(),"ankiety");

        end = Instant.now();
        System.gc();
        elapsedTime = Duration.between(start,end).toMillis()/1000;
        System.out.println("Wygenerowane:");
        System.out.println("kursanci: " + kursanci.size());
        System.out.println("instruktorzy: " + instruktorzy.size());
        System.out.println("kursy: " + kursy.size());
        System.out.println("uczenia: " + uczenia.size());
        System.out.println("ankiety: " + generatorWynikowAnkiet.getAnkiety().size());
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("W czasie: " + elapsedTime);
    }


}
