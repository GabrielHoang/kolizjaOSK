package koLizja.generatory;

import koLizja.Kategoria;
import koLizja.encje.Ankieta;
import koLizja.encje.Instruktor;
import koLizja.encje.Kurs;
import koLizja.encje.Kursant;

import java.util.ArrayList;
import java.util.List;

public class GeneratorZmian extends GeneratorAbstract {

    private List<Instruktor> instruktorzy;
    private List<Kurs> kursy;
    private List<Kursant> kursanci;
    private GeneratorUczenie generatorUczenie;
    private List<Ankieta> ankiety;
    private int liczbaDni;


    public GeneratorZmian(int liczbaDni, List<Instruktor> instruktorzy, List<Kursant> kursanci,GeneratorUczenie generatorUczenie) {
        this.instruktorzy = instruktorzy;
        this.kursanci = kursanci;
        this.liczbaDni = liczbaDni;
        this.generatorUczenie = generatorUczenie;
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
            Instruktor instruktor;
            Instruktor nowyInstruktor;
            Kategoria wczesniejszaKategoria = null;
            int index = random.nextInt(instruktorzy.size());
            if (instruktorzy.get(index).getKategorie().equals(Kategoria.A)) {
                instruktorzy.get(index).setKategorie(Kategoria.B);
                wczesniejszaKategoria = Kategoria.A;
            }

            else if (instruktorzy.get(index).getKategorie().equals(Kategoria.B)){
                instruktorzy.get(index).setKategorie(Kategoria.C);
                wczesniejszaKategoria = Kategoria.B;
            }
            else {
                instruktorzy.get(index).setKategorie(Kategoria.A);
                wczesniejszaKategoria = Kategoria.C;
            }
            instruktor = instruktorzy.get(index);
            /*
            try{
                for(Uczenie ucz : generatorUczenie.getUczenie()) {
                    if (ucz.getIdInstruktoraPraktyki() == instruktor.getId()) {
                        nowyInstruktor = generatorUczenie.znajdzInstruktora(wczesniejszaKategoria, Uprawnienia.P);
                        ucz.setIdInstruktoraPraktyki(nowyInstruktor.getId());
                    }
                    else  if (ucz.getIdInstruktoraTeorii() == instruktor.getId()) {
                        nowyInstruktor = generatorUczenie.znajdzInstruktora(wczesniejszaKategoria, Uprawnienia.T);
                        ucz.setIdInstruktoraTeorii(nowyInstruktor.getId());
                    }
                }
            }catch (Exception e ) {
                e.printStackTrace();
            } */

            i++;
            zmienieniInstruktorzy.add(instruktor);
        }
        return zmienieniInstruktorzy;
    }

    public List<Instruktor> createInstruktorzy(int id){

        List<Instruktor> nowiInstruktorzy = new ArrayList<>();
        GeneratorInstruktorow generatorInstruktorów = new GeneratorInstruktorow();

        int i = id;
        while(i < (id+liczbaDni/DNI_NOWY_INSTRUKTOR)) {
            nowiInstruktorzy.add(generatorInstruktorów.create(i));
            i+=1;
        }

        return nowiInstruktorzy;
    }

}
