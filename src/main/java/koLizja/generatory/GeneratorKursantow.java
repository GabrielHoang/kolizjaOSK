package koLizja.generatory;

import com.github.javafaker.Faker;
import koLizja.encje.Kursant;

import java.util.Locale;

public class GeneratorKursantow extends GeneratorAbstract{

    private GeneratorPeseli generatorPeseli = GeneratorPeseli.getInstance();

    public Kursant create(int id) {

        Kursant kursant = new Kursant();

        kursant.setPesel(generatorPeseli.getNumer(id));
        kursant.setImie(faker.name().firstName());
        kursant.setNazwisko(faker.name().lastName());
        kursant.setAdres(faker.address().city()
                + " " + faker.address().streetAddress());
        kursant.setNumTel(faker.phoneNumber().cellPhone());

        return kursant;
    }

    public GeneratorKursantow() {
        generatorPeseli.printRozmiarListy();
    }


}
