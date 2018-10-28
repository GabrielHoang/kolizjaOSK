package koLizja.generatory;

import koLizja.Kategoria;
import koLizja.encje.*;

import java.util.ArrayList;
import java.util.List;

public class GeneratorZmian extends GeneratorAbstract {

    private List<Instruktor> instruktorzy;
    private List<Kurs> kursy;
    private List<Kursant> kursanci;
    private List<Uczenie> uczenie;
    private List<Ankieta> ankiety;
    private int liczbaDni;


    public GeneratorZmian(int liczbaDni, List<Instruktor> instruktorzy, List<Kursant> kursanci) {
        this.instruktorzy = instruktorzy;
        this.kursanci = kursanci;
        this.liczbaDni = liczbaDni;
    }

    //zmiany w danych są zależne od liczby dni, jaka upłynęła

    public List<Kursant> createKursanci(){

        List<Kursant> nowiKursanci = new ArrayList<Kursant>();
        GeneratorKursantow generatorKursantow = new GeneratorKursantow();

        int i = 0;
        while(i < liczbaDni/DNI_NOWY_KURSANT) {
            nowiKursanci.add(generatorKursantow.create(i));
            i+=1;
        }

        return nowiKursanci;
    }

    public List<Instruktor> modifyInstruktorzy(){

        List<Instruktor> zmienieniInstruktorzy = new ArrayList<>();

        int i = 0;
        while(i < liczbaDni/DNI_ROZWOJ_INSTRUKTORA) {
            int index = random.nextInt(instruktorzy.size());
            if (instruktorzy.get(index).getKategorie().equals(Kategoria.B))
                instruktorzy.get(index).setKategorie(Kategoria.A);
            else if (instruktorzy.get(index).getKategorie().equals(Kategoria.A))
                instruktorzy.get(index).setKategorie(Kategoria.B);
            i+=1;
            zmienieniInstruktorzy.add(instruktorzy.get(index));
        }
        return zmienieniInstruktorzy;
    }

    public List<Instruktor> createInstruktorzy(){

        List<Instruktor> nowiInstruktorzy = new ArrayList<>();
        GeneratorInstruktorow generatorInstruktorów = new GeneratorInstruktorow();

        int i = 0;
        while(i < liczbaDni/DNI_NOWY_INSTRUKTOR) {
            nowiInstruktorzy.add(generatorInstruktorów.create(i));
            i+=1;
        }

        return nowiInstruktorzy;
    }

}
