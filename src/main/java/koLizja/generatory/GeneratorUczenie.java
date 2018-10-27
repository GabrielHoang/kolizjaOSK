package koLizja.generatory;

import koLizja.Kategoria;
import koLizja.Typ;
import koLizja.Uprawnienia;
import koLizja.encje.Instruktor;
import koLizja.encje.Kurs;
import koLizja.encje.Kursant;
import koLizja.encje.Uczenie;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Data
public class GeneratorUczenie extends GeneratorAbstract{

    private List<Kurs> kursy;
    private List<Kursant> kursanci;
    private List<Instruktor> instruktorzy;
    private List<Uczenie> uczenie = new ArrayList<Uczenie>();

    private ListIterator<Kurs> kursIterator;
    private ListIterator<Kursant> kursantIterator;
    private ListIterator<Instruktor> instruktorIterator;
    private ListIterator<Uczenie>uczenieIterator;

    int stworzoneUczenia = 0;
    int kolejnyTerminKursow = 0;
    int porcjaKursantow = 0;
    int godzinaZajec = 0;

    public GeneratorUczenie(List<Kurs> kursy, List<Kursant> kursanci, List<Instruktor> instruktorzy) {
        this.kursy = kursy;
        this.kursanci = kursanci;
        this.instruktorzy = instruktorzy;
        this.kursIterator = kursy.listIterator();
        this.kursantIterator = kursanci.listIterator();
        this.instruktorIterator = instruktorzy.listIterator();
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

        while (kursantIterator.hasNext() || stworzoneUczenia < zadanychUczen) {


            if(kursantIterator.nextIndex() % 100 == 0) {
                porcjaKursantow++;
                godzinaZajec++;
                godzinaZajec = godzinaZajec % ILOSC_OFEROWANYCH_GODZIN_KURSOW;
            }

            if(kursantIterator.nextIndex() % 1000 == 0) {
                kolejnyTerminKursow++;
            }

            kursant = kursantIterator.next();

            //dla kazdego kursanta jest losowany zestaw kursow na ktore zostanie zapisany
            int iloscWylosowanychKursow = random.nextInt(MAX_ILOSC_KURSOW)+MIN_ILOSC_KURSOW;
            stworzoneUczenia+=iloscWylosowanychKursow;

            Kursant finalKursant = kursant;
            //poniższy IntStream to generator liczb w podanym zakresie. Wygeneruje ich tyle ile wynosi
            //iloscWylosowanychKursow i dla kazdej liczby z IntStream stworzy nowy kurs.
            //TODO do dodania pozostale pola uczenia
              IntStream.range(1,6).distinct().limit(iloscWylosowanychKursow).forEach(
                wylosowanyWariant -> uczenie.add(new Uczenie(
                        przypiszKurs(wylosowanyWariant),
                        finalKursant,
                        przypiszInstruktora(wylosowanyWariant,Uprawnienia.T),
                        przypiszInstruktora(wylosowanyWariant,Uprawnienia.P)
                ))
            );



        }
        System.out.println("Stworzone uczenia: " +stworzoneUczenia);


    }

    public Kurs przypiszKurs(int wariant) {
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

    public Kurs znajdzKurs(Kategoria kat, Typ typ, int godz) throws Exception {

        boolean found = false;
        Kurs szukanyKurs = null;
        kursIterator = kursy.listIterator();

        while(!found && kursIterator.nextIndex() != kursy.size()) {
            szukanyKurs = kursIterator.next();
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

    public Instruktor przypiszInstruktora(int wariant, Uprawnienia uprawnienia) {
        try {
            switch (wariant) {
                case 1 : return znajdzInstruktora(Kategoria.A,uprawnienia);
                case 2 : return znajdzInstruktora(Kategoria.A,uprawnienia);
                case 3 : return znajdzInstruktora(Kategoria.B,uprawnienia);
                case 4 : return znajdzInstruktora(Kategoria.B,uprawnienia);
                case 5 : return znajdzInstruktora(Kategoria.C,uprawnienia);
                case 6 : return znajdzInstruktora(Kategoria.C,uprawnienia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //jesli po podjeciu prob == wielkosc listy instruktorow nie znajdzie instruktora o takiej kombinacji
    //wychodzi z petli i rzuca blad
    public Instruktor znajdzInstruktora(Kategoria kat, Uprawnienia upr) throws Exception {

        boolean found = false;
        Instruktor instruktor = null;
        int proby = 0;

        while(!found) {
            instruktor = instruktorzy.get(random.nextInt(instruktorzy.size()));

            if(instruktor.getUprawnienia() == upr
            && instruktor.getKategorie() == kat) {
                found = true;
            }

            if(!found) {
                proby++;
            }

            if (proby == instruktorzy.size()) {
                throw new Exception("Nie znaleziono instruktora dla kategorii: " + kat
                + " i uprawnieniach: " + upr);
            }
        }

        return  instruktor;
    }



}
