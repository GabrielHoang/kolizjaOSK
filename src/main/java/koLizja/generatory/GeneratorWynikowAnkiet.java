package koLizja.generatory;

import koLizja.Kategoria;
import koLizja.ZrodloWiedzyOSzkole;
import koLizja.encje.*;
import lombok.Getter;

import java.text.ParseException;
import java.util.*;

public class GeneratorWynikowAnkiet extends GeneratorAbstract {

    //listy z gotowymi danymi
    private List<Instruktor> instruktorzy;
    private List<Kurs> kursy;
    private List<Kursant> kursanci;
    private List<Uczenie> uczenie;
    //iterator dla głównej części generatora (uczenie)
    private ListIterator<Uczenie> uczenieIterator;
    //zmienne
    private Uczenie currentUczenie;
    int i = 0;
    //wyjściowa lista ankiet
    @Getter
    private List<Ankieta> ankiety = new ArrayList<Ankieta>();

    public GeneratorWynikowAnkiet(List<Instruktor> instruktorzy, List<Kurs> kursy, List<Kursant> kursanci, List<Uczenie> uczenie) {
        this.instruktorzy = instruktorzy;
        this.kursy = kursy;
        this.kursanci = kursanci;
        this.uczenie = uczenie;
        this.uczenieIterator = uczenie.listIterator();
    }

    //to generowanie nie uwzglednia dodatkowych uwag mozliwych do pozostawienia pokazdej sekcji ankiety
    public void create() {
        while(uczenieIterator.hasNext()) {
            try {
                i++;
                currentUczenie = uczenieIterator.next();
                Ankieta ankieta = new Ankieta();
                ankieta.setTimeStamp(df.format(getTimeStamp(currentUczenie.getDataRozpoczecia())));
                //TEORIA
                ankieta.setImieNazwiskoInstruktoraTeorii(getImieNazwiskoInstruktoraById(currentUczenie.getIdInstruktoraTeorii()));
                ankieta.setPoziomWiedzyInstruktoraTeorii(losujDomyslnyPrzedzial());
                ankieta.setSposobPrzekazywaniaWiedzyTeoria(losujDomyslnyPrzedzial());
                ankieta.setAtmosferaZajecTeorii(losujDomyslnyPrzedzial());
                ankieta.setOcenaPrzygotowaniaTeorii(losujDomyslnyPrzedzial());
                ankieta.setInstruktorSpoznialSieTeoria(losujTakNie());
                ankieta.setExtraUwagi1("brak");
                //PRAKTYKA
                ankieta.setImieNazwiskoInstruktoraPraktyki(getImieNazwiskoInstruktoraById(currentUczenie.getIdInstruktoraPraktyki()));
                ankieta.setPoziomWiedzyInstruktoraPraktyki(losujDomyslnyPrzedzial());
                ankieta.setSposobPrzekazywaniaWiedzyPraktyka(losujDomyslnyPrzedzial());
                ankieta.setAtmosferaZajecPraktyki(losujDomyslnyPrzedzial());
                ankieta.setOcenaPrzygotowaniaPraktyki(losujDomyslnyPrzedzial());
                ankieta.setInstruktorSpoznialSiePraktyka(losujTakNie());
                ankieta.setExtraUwagi2("brak");
                //INFO
                ankieta.setIdKursu(currentUczenie.getIdKursu());
                ankieta.setOgolnaOcenaKursu((ankieta.getOcenaPrzygotowaniaPraktyki() +
                        ankieta.getOcenaPrzygotowaniaTeorii())/2);
                ankieta.setSkadWieszOSzkole(losujZrodloWiedzy(currentUczenie.getPeselKursanta()).toString());
                ankieta.setNapiszeNaTrojmiescie(losujTakNie());
                ankieta.setPoleceZnajomym(losujTakNie());
                //METRYKA
                ankieta.setImie(getKursantByPesel(currentUczenie.getPeselKursanta()).getImie());
                ankieta.setNazwisko(getKursantByPesel(currentUczenie.getPeselKursanta()).getNazwisko());
                ankieta.setWiek(getWiekKursanta(currentUczenie));
                ankieta.setPesel(currentUczenie.getPeselKursanta());

                ankiety.add(ankieta);
                System.out.println(i);

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
        return random.nextInt(MAX_OCENA_INSTRUKTORA - MIN_OCENA_INSTRUKTORA)+MIN_OCENA_INSTRUKTORA + 1;
    }

    private ZrodloWiedzyOSzkole losujZrodloWiedzy(String pesel) {
        String last = pesel.substring(pesel.length() - 1);
        return ZrodloWiedzyOSzkole.values()[Integer.parseInt(last)%4];
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
