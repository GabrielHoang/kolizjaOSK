package koLizja;

import koLizja.encje.Instruktor;
import koLizja.encje.Kurs;
import koLizja.encje.Kursant;
import koLizja.generatory.GeneratorInstruktorow;
import koLizja.generatory.GeneratorKursantow;
import koLizja.generatory.GeneratorKursow;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {

    static int iloscKursantow = 100000;
    static int iloscInstruktorow = 100000;
    static int iloscKursow = 100000;



    public static void main(String[] args) {

        GeneratorKursantow generatorKursantow = new GeneratorKursantow();
        GeneratorInstruktorow generatorInstruktorow = new GeneratorInstruktorow();
        GeneratorKursow generatorKursow = new GeneratorKursow();

        List<Kursant> kursanci = new ArrayList<Kursant>();
        List<Instruktor> instruktorzy = new ArrayList<Instruktor>();
        List<Kurs> kursy = new ArrayList<Kurs>();

        long start = System.currentTimeMillis();

        int i = 0;
        while(i < 100) {
            kursanci.add(generatorKursantow.create(i));
            instruktorzy.add(generatorInstruktorow.create(i));
            kursy.add(generatorKursow.create(i));
            i+=1;
        }

        System.out.println((System.currentTimeMillis()-start)/1000);

        OutputFile outputFile = new OutputFile();
        outputFile.create(kursanci,"lista kursantow");

    }



}
