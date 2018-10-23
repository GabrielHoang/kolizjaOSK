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

    protected Random random = new Random(10);

    //KURSANCI

    //INSTRUKTORZY
    protected Date OLDEST_INSTR = new Date(1980,1,1);
    protected Date YOUNGEST_INSTR = new Date(1993,12,31);
    //po ilu dniach od uzyskania pełnoletności uzyskuje uprawnienia
    protected int CZAS_ZDOBYCIA_UPRAWNIEN = 1800;
    //po ilu dniach od uzyskania uprawnień uzyskuje zatrudneinie
    protected int CZAS_ZDOBYCIA_ZATRUDNIENIA = 720;

    //KURS
    protected int GODZINY_KURSU = 30;

}
