package koLizja.generatory;

import koLizja.Kategoria;
import koLizja.ZrodloWiedzyOSzkole;
import koLizja.encje.*;
import lombok.Getter;

import java.awt.*;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class GeneratorWynikowAnkiet extends GeneratorAbstract {

    private List<Instruktor> instruktorzy;
    private List<Kurs> kursy;
    private List<Kursant> kursanci;
    private List<Uczenie> uczenie;
    @Getter
    private List<Ankieta> ankiety = new ArrayList<Ankieta>();

    public GeneratorWynikowAnkiet(List<Instruktor> instruktorzy, List<Kurs> kursy, List<Kursant> kursanci, List<Uczenie> uczenie) {
        this.instruktorzy = instruktorzy;
        this.kursy = kursy;
        this.kursanci = kursanci;
        this.uczenie = uczenie;
    }

    //to generowanie nie uwzglednia dodatkowych uwag mozliwych do pozostawienia pokazdej sekcji ankiety
    public void create() {
        for (Uczenie ucz : uczenie) {
            try {
                Ankieta ankieta = new Ankieta();
                ankieta.setTimeStamp(df.format(getTimeStamp(ucz.getDataRozpoczecia())));
                //TEORIA
                ankieta.setImieNazwiskoInstruktoraTeorii(getImieNazwiskoInstruktoraById(ucz.getIdInstruktoraTeorii()));
                ankieta.setPoziomWiedzyInstruktoraTeorii(losujDomyslnyPrzedzial());
                ankieta.setSposobPrzekazywaniaWiedzyTeoria(losujDomyslnyPrzedzial());
                ankieta.setAtmosferaZajecTeorii(losujDomyslnyPrzedzial());
                ankieta.setOcenaPrzygotowaniaTeorii(losujDomyslnyPrzedzial());
                ankieta.setInstruktorSpoznialSieTeoria(losujTakNie());
                ankieta.setExtraUwagi1("brak");
                //PRAKTYKA
                ankieta.setImieNazwiskoInstruktoraPraktyki(getImieNazwiskoInstruktoraById(ucz.getIdInstruktoraPraktyki()));
                ankieta.setPoziomWiedzyInstruktoraPraktyki(losujDomyslnyPrzedzial());
                ankieta.setSposobPrzekazywaniaWiedzyPraktyka(losujDomyslnyPrzedzial());
                ankieta.setAtmosferaZajecPraktyki(losujDomyslnyPrzedzial());
                ankieta.setOcenaPrzygotowaniaPraktyki(losujDomyslnyPrzedzial());
                ankieta.setInstruktorSpoznialSiePraktyka(losujTakNie());
                ankieta.setExtraUwagi2("brak");
                //INFO
                ankieta.setKategoria(getKategoriaKursuById(ucz.getIdKursu()));
                ankieta.setSkadWieszOSzkole(losujZrodloWiedzy().toString());
                ankieta.setNapiszeNaTrojmiescie(losujTakNie());
                ankieta.setPoleceZnajomym(losujTakNie());
                //METRYKA
                ankieta.setImie(getKursantByPesel(ucz.getPeselKursanta()).getImie());
                ankieta.setNazwisko(getKursantByPesel(ucz.getPeselKursanta()).getNazwisko());
                ankieta.setWiek(getWiekKursanta(ucz));
                ankieta.setPesel(ucz.getPeselKursanta());

                ankiety.add(ankieta);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }






    }

    private Date getTimeStamp(String dataRozpoczecia) throws ParseException {
        Date date = df.parse(dataRozpoczecia);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_WEEK,DNI_DO_ROZWIAZANIA_ANKIETY);
        return  calendar.getTime();
    }

    private String getImieNazwiskoInstruktoraById(int id) throws Exception {
        Instruktor instruktor = getInstruktorById(id);
        return instruktor.getImie() + " " + instruktor.getNazwisko();
    }

    private Instruktor getInstruktorById(int id) throws Exception {
        boolean found = false;
        Instruktor instruktor = null;
        ListIterator<Instruktor> iteraorInstruktorzy = instruktorzy.listIterator();
        while(!found && iteraorInstruktorzy.hasNext()) {
            instruktor = iteraorInstruktorzy.next();
            if(instruktor.getId() == id) {
                found = true;
            }
        }
        if (instruktor == null) {
            throw new Exception("Nie znaleziono instruktora o id: " + id);
        }
        return instruktor;
    }

    private Kategoria getKategoriaKursuById(int id) throws Exception {
        Kurs kurs = getKursById(id);
        return kurs.getKategoria();
    }

    private Kurs getKursById(int id) throws Exception {
        boolean found = false;
        Kurs kurs = null;
        ListIterator<Kurs> iteratorKurs = kursy.listIterator();
        while(!found && iteratorKurs.hasNext()) {
            kurs = iteratorKurs.next();
            if(kurs.getId()==id) {
                found = true;
            }
        }
        if (kurs == null) {
            throw new Exception("Nie znaleziono kursu o id " + id);
        }
        return kurs;
    }

    private String losujTakNie() {
        boolean rezultat = random.nextBoolean();
        if(rezultat) {
            return "tak";
        } else {
            return "nie";
        }
    }

    private int losujDomyslnyPrzedzial() {
        return random.nextInt(MAX_OCENA_INSTRUKTORA)+MIN_OCENA_INSTRUKTORA;
    }

    private ZrodloWiedzyOSzkole losujZrodloWiedzy() {
        return ZrodloWiedzyOSzkole.values()[random.nextInt(ZrodloWiedzyOSzkole.values().length)];
    }

    private Kursant getKursantByPesel(String pesel) throws Exception {
        boolean found = false;
        Kursant kursant = null;
        ListIterator<Kursant> iteratorKursant = kursanci.listIterator();
        while(!found && iteratorKursant.hasNext()) {
            kursant = iteratorKursant.next();
            if(kursant.getPesel()==pesel) {
                found = true;
            }
        }
        if(kursant==null) {
            throw new Exception("Nie znaleziono kursanta o numerze pesel: " + pesel);
        }
        return kursant;
    }

    private int getWiekKursanta(Uczenie uczenie) {
        int wiek = OBECNY_ROK - (1900+Integer.parseInt(uczenie.getPeselKursanta().substring(0,2)));
        return wiek;
    }

}
