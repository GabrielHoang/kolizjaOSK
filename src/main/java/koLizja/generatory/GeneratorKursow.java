package koLizja.generatory;

import koLizja.Kategoria;
import koLizja.Typ;
import koLizja.encje.Kurs;

import java.util.ArrayList;
import java.util.List;

public class GeneratorKursow extends GeneratorAbstract {

    //generator full random, z domyślną nazwą kursu i z zmodyfikowaną

    public Kurs create(int id) {
        Kurs kurs = new Kurs();
        kurs.setId(id);
        kurs.setTyp(Typ.values()[random.nextInt(2)].toString());
        kurs.setKategoria(Kategoria.values()[random.nextInt(3)].toString());
        kurs.setNazwa("Kurs kategorii " + kurs.getKategoria() + " | " + kurs.getTyp() + " | " + id);
        kurs.setGodziny(GODZINY_KURSU);

        return kurs;
    }

    public Kurs create(int id, Kategoria kategoria, Typ typ) {

        Kurs kurs = new Kurs();
        kurs.setId(id);
        kurs.setNazwa("Kurs kategorii " + typ.toString() + " | " + kategoria.toString() + " | " + id);
        kurs.setKategoria(kategoria.toString());
        kurs.setTyp(typ.toString());
        kurs.setGodziny(TABELA_GODZIN[id%TABELA_GODZIN.length]);

        return kurs;
    }
    public Kurs create(int id, String nazwa, Kategoria kategoria, Typ typ) {

        Kurs kurs = create(id,kategoria,typ);
        kurs.setId(id);
        kurs.setNazwa(nazwa);
        kurs.setKategoria(kategoria.toString());
        kurs.setTyp(typ.toString());

        return kurs;
    }

    public List<Kurs> createEveryType() {

        List<Kurs> kursy = new ArrayList<Kurs>();
        int i = 0;
        for(Kategoria kat : Kategoria.values()) {
            for(Typ typ : Typ.values()) {
                for(String godzina : TABELA_GODZIN) {
                    kursy.add(create(i,kat,typ));
                    i++;
                }
            }
        }
        return kursy;
    }
}
