package koLizja.generatory;

import com.github.javafaker.Faker;
import koLizja.encje.Kursant;

import java.util.Locale;

public class GeneratorKursantow extends GeneratorAbstract{

    public Kursant create(int id) {

        Kursant kursant = new Kursant();
        //budowaie peselu (nalezy wziac pod uwage pierwsze 6 cyfr ktore odnosza sie do daty urodzenia)
        //do poprawienia
        kursant.setPesel(
                faker.number().numberBetween(85,99)
        +faker.number().numberBetween(01,12)
        +faker.number().numberBetween(01,31)
        +faker.number().numberBetween(10000,99999));
        kursant.setImie(faker.name().firstName());
        kursant.setNazwisko(faker.name().lastName());
        kursant.setAdres(faker.address().city()
                + " " + faker.address().streetAddress());
        kursant.setNumTel(faker.phoneNumber().cellPhone());

        return kursant;
    }
}
