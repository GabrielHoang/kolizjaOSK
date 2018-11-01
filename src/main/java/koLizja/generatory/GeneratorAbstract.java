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

    //KURS
    protected int GODZINY_KURSU = 30;
    //ustawienia generowanie numeru PESEL
    protected int ILOSC_ZADANA = 300000;
    protected int PIERWSZA_CYFRA_ROKU_OD = 7;
    protected int PIERWSZA_CYFRA_ROKU_DO = 9;
    protected int DRUGA_CYFRA_ROKU_OD = 0;
    protected int DRUGA_CYFRA_ROKU_DO = 9;
    protected int PIERWSZA_CYFRA_MIESIACA_OD = 0;
    protected int PIERWSZA_CYFRA_MIESIACA_DO = 0;
    protected int DRUGA_CYFRA_MIESIACA_OD = 1;
    protected int DRUGA_CYFRA_MIESIACA_DO = 9;
    protected int DNI_OD = 10;
    protected int DNI_DO = 28;
    protected int KONIEC_NUMERU_OD = 10000;
    protected int KONIEC_NUMERU_DO = 99999;


    //UCZENIE

    //co ile kursantow generator zmienia grupe godzinowa kursow
    protected int PORCJA_KURSANTOW = 100;
    //co ilu kursantow generator przechodzi do kolejnego terminu kursu
    protected int KURSANCI_NA_TERMIN = 1000;

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
    protected  Date DATA_PIERWSZEGO_UCZENIA = new Date(2018, 1, 1);
    protected  Date DATA_OSTATNIEGO_UCZENIA = new Date(2018, 11, 1);
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

    //ZMIANY
    //nie mniejsza niz zmienna z liczbaDni z main'a , bo inaczej nic w danym punkcie nie wygeneruje
    protected int DNI_NOWY_KURSANT = 14;
    protected int DNI_NOWY_INSTRUKTOR = 30;
    protected int DNI_ROZWOJ_INSTRUKTORA = 28;

}

//TODO usuniecie niepotrzebnych stalych