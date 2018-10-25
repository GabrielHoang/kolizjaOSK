package koLizja.generatory;

import com.github.javafaker.Faker;

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
    //minimalna  i maksymalna ilosc kursow realizowana przez jednego kursanta
    protected int MIN_ILOSC_KURSOW = 1;
    protected int MAX_ILOSC_KURSOW = 5;
    //instruktor teorii moze uczyc wiecej kursantow niz instruktor praktyki.
    protected int MAX_UCZNIOW_NA_INS_TEORII = 200;
    protected int MAX_UCZNIOW_NA_INS_PRAKTYKI = 15;
    //odstep czasowy dla kolejnych kursow
    protected int DNI_DO_KOLEJNEGO_KURSU = 14;
    //godziny poszczegolnych kursow
    protected String TABELA_GODZIN [] =
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
                    "19.00"
            };
    //maksymalna ilosc kursatow przypadajacych na kurs
    protected int MAX_UCZNIOW_NA_KURS = 30;
    //ilosc lat dla ktorych beda generowane dane (DATA_OD -> DATA_OD + LATA DANYCH)
    protected int LATA_DANYCH = 3;
    protected Date DATA_OD = new Date(2018,1,1);
    protected Date DATA_DO = new Date(
            DATA_OD.getYear()+LATA_DANYCH,
            DATA_OD.getMonth(),
            DATA_OD.getDay());

    //minimalna i maksymalna ilosc podejsc kursanta do egzaminow teoretycznych i praktycznych
    protected int MIN_ILOSC_EGZ = 0;
    protected int MAX_ILOSC_EGZ_TEORII = 3;
    protected int MAX_ILOSC_EGZ_PRAKTYKI = 4;


}
