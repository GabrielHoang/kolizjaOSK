package koLizja.generatory;

import com.github.javafaker.Faker;
import koLizja.Kategoria;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class GeneratorAbstract {

    //uzyskanie polskiej wersji danych z generatora
    protected Faker faker = new Faker(new Locale("pl"));
    //format daty w stringu
    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    protected Random random = new Random();

    //KURSANCI

    //INSTRUKTORZY
    protected Date NAJSTARSZY_INSTR = new Date(1980,1,1);
    protected Date NAJMLODSZY_INSTR = new Date(1993,12,31);
    //po ilu dniach od uzyskania pełnoletności uzyskuje uprawnienia
    protected int CZAS_ZDOBYCIA_UPRAWNIEN = 1800;
    //po ilu dniach od uzyskania uprawnień uzyskuje zatrudneinie
    protected int CZAS_ZDOBYCIA_ZATRUDNIENIA = 720;

    //KURS
    protected int GODZINY_KURSU = 30;

    //UCZENIE
    protected int ILOSC_UCZEN = 1000000;
    //udzialy poszczegolnych kategorii w ilosci uczen. Razem musza wynosic 1.0
    protected double UDZIAL_KAT_A = 0.2;
    protected double UDZIAL_KAT_B = 0.7;
    protected double UDZIAL_KAT_C = 0.1;
    //szansa na to ze kursant poza kursem podstawowym ma kurs uzupelniajacy
    protected double SZANSA_NA_KURS_UZUP = 0.4;
    //minimalna  i maksymalna ilosc kursow realizowana przez jednego kursanta
    protected int MIN_ILOSC_KURSOW = 1;
    protected int MAX_ILOSC_KURSOW = 6;
    //instruktor teorii moze uczyc wiecej kursantow niz instruktor praktyki.
    protected int MAX_UCZNIOW_NA_INS_TEORII = 200;
    protected int MAX_UCZNIOW_NA_INS_PRAKTYKI = 15;
    //odstep czasowy dla kolejnych kursow
    protected int DNI_DO_KOLEJNEGO_KURSU = 7;
    //godziny poszczegolnych kursow
    protected String TABELA_GODZIN_KURSOW_PODST[] =
            {
                    "9.00",
                    "10.00",
                    "11.00",
                    "12.00",
                    "13.00",
                    "14.00",
                    "15.00",
                    "16.00",
                    "17.00",
                    "18.00"
            };
    protected String TABELA_GODZIN_KURSOW_UZUP[] =
            {
                    "10.00",
                    "11.00",
                    "12.00",
                    "13.00",
                    "14.00",
                    "15.00",
                    "16.00",
                    "17.00",
                    "18.00",
                    "19.00",
            };
    protected int ILOSC_OFEROWANYCH_GODZIN_KURSOW = TABELA_GODZIN_KURSOW_PODST.length;
    //ilosc kursow podczas roku
    protected int KURSY_ROCZNIE = (365/DNI_DO_KOLEJNEGO_KURSU)
            * Kategoria.values().length* TABELA_GODZIN_KURSOW_PODST.length;
    //maksymalna ilosc kursatow przypadajacych na
    protected int MIN_UCZNIOW_NA_KURS_A = 20;
    protected int MAX_UCZNIOW_NA_KURS_A = 50;
    protected int MIN_UCZNIOW_NA_KURS_B = 30;
    protected int MAX_UCZNIOW_NA_KURS_B = 100;
    protected int MIN_UCZNIOW_NA_KURS_C = 20;
    protected int MAX_UCZNIOW_NA_KURS_C = 40;
    //daty w ktorych rozpoczynaja sie kursy. Dzieki temu kursant moze chodzic na wszystkie kursy o tej samej godzinie
    //ale w innych dniach. (uproszczenie dla generowania)
    protected Date KURS_A_DATA_OD = new Date(2018,1,1);
    protected Date KURS_B_DATA_OD = new Date(2018,1,2);
    protected Date KURS_C_DATA_OD = new Date(2018,1,3);
    //minimalna i maksymalna ilosc podejsc kursanta do egzaminow teoretycznych i praktycznych
    protected int MIN_ILOSC_EGZ = 1;
    protected int MAX_ILOSC_EGZ_TEORII = 3;
    protected int MAX_ILOSC_EGZ_PRAKTYKI = 4;


}

//TODO usuniecie niepotrzebnych stalych