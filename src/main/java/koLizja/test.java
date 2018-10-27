package koLizja;

import koLizja.encje.Instruktor;
import koLizja.encje.Kurs;
import koLizja.encje.Kursant;
import koLizja.generatory.GeneratorInstruktorow;
import koLizja.generatory.GeneratorKursantow;
import koLizja.generatory.GeneratorKursow;
import koLizja.generatory.GeneratorUczenie;

import java.util.ArrayList;
import java.util.List;

public class test {

    static int iloscKursantow = 20;
    static int iloscInstruktorow = 10;
    static int iloscUczen = 40;

    public static void main(String[] args) {

        GeneratorKursantow generatorKursantow = new GeneratorKursantow();
        GeneratorInstruktorow generatorInstruktorow = new GeneratorInstruktorow();
        GeneratorKursow generatorKursow = new GeneratorKursow();

        List<Kursant> kursanci = new ArrayList<Kursant>();
        List<Instruktor> instruktorzy = new ArrayList<Instruktor>();
        List<Kurs> kursy;

        long start = System.currentTimeMillis();

        int i = 0;
        while(i < iloscKursantow) {
           kursanci.add(generatorKursantow.create(i));
            i+=1;
        }

        instruktorzy = generatorInstruktorow.createEveryType();

//        int j = 0;
//        while(j < iloscInstruktorow) {
//            instruktorzy.add(generatorInstruktorow.create(j));
//            j++;
//        }
        kursy = generatorKursow.createEveryType();

//        OutputFile outputFile = new OutputFile();
        OutputFile.create(kursy,"kursy");
        OutputFile.create(instruktorzy,"instuktorzy");
        OutputFile.create(kursanci,"kursanci");

        System.out.println("Czas generowania:\n"
                + iloscInstruktorow + " instruktorow\n"
                + iloscKursantow + " kursantow\n"
                + (System.currentTimeMillis()-start)/1000+ " s");
        System.out.println("Generowanie uczenia");
        start = System.currentTimeMillis();

        GeneratorUczenie generatorUczenie = new GeneratorUczenie(kursy, kursanci, instruktorzy);
        generatorUczenie.create(iloscUczen);

        System.out.println("Stworzone uczenia: " + generatorUczenie.getStworzoneUczenia());
        OutputFile.create(generatorUczenie.getUczenie(), "uczenia");

        System.out.println("Czas generowania uczenia: " + (System.currentTimeMillis()-start)/1000 + " s");
    }


}
