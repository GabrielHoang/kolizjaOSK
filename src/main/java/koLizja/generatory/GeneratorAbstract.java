package koLizja.generatory;

import com.github.javafaker.Faker;
import koLizja.Kategoria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class GeneratorAbstract {

    //uzyskanie polskiej wersji danych z generatora
    protected Faker faker = new Faker(new Locale("pl"));
    //format daty w stringu
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    protected Random random = new Random();

    //KURSANCI

    //INSTRUKTORZY
    protected Date NAJSTARSZY_INSTR = new Date(80,1,1);
    protected Date NAJMLODSZY_INSTR = new Date(93,12,31);
    //po ilu dniach od uzyskania pełnoletności uzyskuje uprawnienia
    protected int CZAS_ZDOBYCIA_UPRAWNIEN = 1800;
    //po ilu dniach od uzyskania uprawnień uzyskuje zatrudneinie
    protected int CZAS_ZDOBYCIA_ZATRUDNIENIA = 720;

    //UCZENIE
    //minimalna  i maksymalna ilosc kursow realizowana przez jednego kursanta
    protected int MIN_ILOSC_KURSOW = 1;
    protected int MAX_ILOSC_KURSOW = 6;
    //odstep czasowy dla kolejnych kursow
    protected int DNI_DO_KOLEJNEGO_KURSU = 7;
    //godziny poszczegolnych kursow
    protected int TABELA_GODZIN_KURSOW_PODST[] =
            {
                    30,
                    35,
                    45,
                    60,
                    75,
                    90
            };
    protected int TABELA_GODZIN_KURSOW_UZUP[] =
            {
                    15,
                    10,
                    7,
                    5,
                    3,
                    2
            };
    protected int ILOSC_OFEROWANYCH_GODZIN_KURSOW = TABELA_GODZIN_KURSOW_PODST.length;
    //obecny rok
    protected int OBECNY_ROK = Calendar.getInstance().get(Calendar.YEAR);
    //domyślną wartością dla generowanej daty jest 1900 - stąd 118 aby uzyskać rok 2018
    protected Date KURS_A_DATA_OD = new Date(118,1,1);
    protected Date KURS_B_DATA_OD = new Date(118,1,2);
    protected Date KURS_C_DATA_OD = new Date(118,1,3);
    //minimalna i maksymalna ilosc podejsc kursanta do egzaminow teoretycznych i praktycznych
    protected int MIN_ILOSC_EGZ = 1;
    protected int MAX_ILOSC_EGZ_TEORII = 3;
    protected int MAX_ILOSC_EGZ_PRAKTYKI = 4;

    //ANKIETA

    //po ilu dniach ankieta zostala uzupelniona (data rozpoczecia kursu +  dni do rozwiazania ankiety)
    protected int DNI_DO_ROZWIAZANIA_ANKIETY = 90;
    //wiedlki ocen wystawianych przez kursantow
    protected int MIN_OCENA_INSTRUKTORA = 4;
    protected int MAX_OCENA_INSTRUKTORA = 10;

}
