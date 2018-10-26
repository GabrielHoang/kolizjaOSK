package koLizja.generatory;

import koLizja.Kategoria;
import koLizja.Typ;
import koLizja.encje.Instruktor;
import koLizja.encje.Kurs;
import koLizja.encje.Kursant;
import koLizja.encje.Uczenie;

import java.util.List;

public class GeneratorUczenie extends GeneratorAbstract{

    List<Kurs> kursy;
    List<Kursant> kursanci;
    List<Instruktor> instruktorzy;
    List<Uczenie> uczenie;

    int stworzoneUczenia = 0;
    int kolejnyTerminKursow = 0;
    int porcjaKursantow = 0;
    int godzinaZajec = 0;

    public GeneratorUczenie(List<Kurs> kursy, List<Kursant> kursanci, List<Instruktor> instruktorzy) {
        this.kursy = kursy;
        this.kursanci = kursanci;
        this.instruktorzy = instruktorzy;
    }

    //Glowna metoda kreowania Uczenia. Kreator konczy prace jesli skoncza sie uczniowie lub osiagnie limit zadanych
    //uczen.
    //Uczenia generowane sa pakietami w ilosci po MAX_UCZNIOW_NA_KURS (domyslnie 100). Dla kazdego kolejnego pakietu
    //zwiekszamy porcjaKursantow i godzinaZajec o 1. Tzn ze przy przebiegu pierwszego pakietu generowane
    //sa uczenia dla 100 kursantow na godzine 9.00 dla pierwszego tygodnia zajec czyli KURS_#_DATA_OD.
    //kolejnyTerminKursow jest inkrementowany o 1 co 1000 kursantow - prowadzonych jest 10 roznych godzin na dany kurs
    //w tygodniu. Wplywa na DNI_DO_KOLEJNEGO_KURSU i na to jaka zostanie wygenerowana kolejna data kursu.
    public void create(int zadanychUczen) {



        Kursant kursant;
        Kurs kurs;
        Instruktor instruktor;

        while (kursanci.listIterator().hasNext() || stworzoneUczenia < zadanychUczen) {

            if(kursanci.listIterator().nextIndex() % 100 == 0) {
                porcjaKursantow++;
                godzinaZajec++;
                godzinaZajec = godzinaZajec % ILOSC_OFEROWANYCH_GODZIN_KURSOW;
            }

            if(kursanci.listIterator().nextIndex() % 1000 == 0) {
                kolejnyTerminKursow++;
            }






            //dla kazdego kursanta jest losowany zestaw kursow na ktore zostanie zapisany
            int iloscWylosowanychKursow = random.nextInt(MAX_ILOSC_KURSOW)+MIN_ILOSC_KURSOW;
            for(int i = 0; i < iloscWylosowanychKursow; i++) {
                random.ints(1,6).distinct().limit(iloscWylosowanychKursow).forEach(
                    wylosowanyWariant -> uczenie.add(new Uczenie(getKurs(wylosowanyWariant)))
                );
            }


        }


    }

    public Kurs getKurs(int wariant) {
        try {
            switch (wariant) {
                case 1 : return znajdzKurs(Kategoria.A,Typ.PODSTAWOWY,TABELA_GODZIN_KURSOW_PODST[godzinaZajec]);
                case 2 : return znajdzKurs(Kategoria.A,Typ.UZUPELNIAJACY,TABELA_GODZIN_KURSOW_UZUP[godzinaZajec]);
                case 3 : return znajdzKurs(Kategoria.B,Typ.PODSTAWOWY,TABELA_GODZIN_KURSOW_PODST[godzinaZajec]);
                case 4 : return znajdzKurs(Kategoria.B,Typ.UZUPELNIAJACY,TABELA_GODZIN_KURSOW_UZUP[godzinaZajec]);
                case 5 : return znajdzKurs(Kategoria.C,Typ.PODSTAWOWY,TABELA_GODZIN_KURSOW_PODST[godzinaZajec]);
                case 6 : return znajdzKurs(Kategoria.C,Typ.UZUPELNIAJACY,TABELA_GODZIN_KURSOW_UZUP[godzinaZajec]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //cos musi zwrocic
        return null;
    }

    public Kurs znajdzKurs(Kategoria kat, Typ typ, String godz) throws Exception {

        boolean found = false;
        Kurs szukanyKurs = null;

        while(!found && kursy.listIterator().hasNext()) {
            szukanyKurs = kursy.listIterator().next();
            if(szukanyKurs.getKategoria()==kat
            && szukanyKurs.getTyp() == typ
            && szukanyKurs.getGodziny() == godz) {
                found=true;
            }
        }

        if (szukanyKurs==null) {
            throw new Exception("Brak kursu kategorii " + kat.toString()
                    + " typ: " + typ.toString() + " o godzinie : " + godz);
        }

        return szukanyKurs;
    }




}
