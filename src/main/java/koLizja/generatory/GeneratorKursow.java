package koLizja.generatory;


import koLizja.Kategoria;
import koLizja.Typ;
import koLizja.encje.Kurs;

import java.util.ArrayList;
import java.util.List;

public class GeneratorKursow extends GeneratorAbstract {

    public Kurs create(int id, Kategoria kategoria, Typ typ) {

        Kurs kurs = new Kurs();
        kurs.setId(id);
        kurs.setNazwa("Kurs kategorii " + typ.toString() + " | " + kategoria.toString() + " | " + id);
        kurs.setKategoria(kategoria.toString());
        kurs.setTyp(typ.toString());
        kurs.setGodziny(TABELA_GODZIN[id%TABELA_GODZIN.length]);

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
