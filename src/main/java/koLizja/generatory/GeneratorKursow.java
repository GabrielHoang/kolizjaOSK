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
        kurs.setNazwa("Kurs kategorii " + kategoria.toString() + " | " + typ.toString() + " | " + id);
        kurs.setKategoria(kategoria);
        kurs.setTyp(typ);
        if (typ == Typ.PODSTAWOWY)
            kurs.setGodziny(TABELA_GODZIN_KURSOW_PODST[id% TABELA_GODZIN_KURSOW_PODST.length]);
        else
            kurs.setGodziny(TABELA_GODZIN_KURSOW_UZUP[id% TABELA_GODZIN_KURSOW_UZUP.length]);

        return kurs;
    }

    public List<Kurs> createEveryType() {

        List<Kurs> kursy = new ArrayList<Kurs>();
        int i = 0;
        for(Kategoria kat : Kategoria.values()) {
            for(Typ typ : Typ.values()) {
                for(int godzina : TABELA_GODZIN_KURSOW_PODST) {
                    kursy.add(create(i,kat,typ));
                    i++;
                }
            }
        }
        return kursy;
    }
}
