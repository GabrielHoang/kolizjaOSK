package koLizja.generatory;

import com.github.javafaker.Faker;
import koLizja.encje.Kursant;

import java.util.Locale;

public class GeneratorKursantow extends GeneratorAbstract{

    public Kursant create(int id) {

        Kursant kursant = new Kursant();

        String pesel = Integer.toString(faker.number().numberBetween(8,9)) //pierwsza cyfra roku
                + Integer.toString(faker.number().numberBetween(0,9)) //druga cyfra roku
                + Integer.toString(faker.number().numberBetween(0,0)) //0 jako pierwsza cyfra miesiąca
                + Integer.toString(faker.number().numberBetween(1,9)) //1-9 jako druga cyfra miesiąca
                + Integer.toString(faker.number().numberBetween(10,28)) //10-28 dzień
                + Integer.toString(faker.number().numberBetween(10000,99999)); //końcówka numeru pesel

        kursant.setPesel(pesel);
        kursant.setImie(faker.name().firstName());
        kursant.setNazwisko(faker.name().lastName());
        kursant.setAdres(faker.address().city()
                + " " + faker.address().streetAddress());
        kursant.setNumTel(faker.phoneNumber().cellPhone());

        return kursant;
    }
}
