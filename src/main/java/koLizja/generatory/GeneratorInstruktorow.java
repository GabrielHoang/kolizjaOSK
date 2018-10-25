package koLizja.generatory;

import koLizja.Kategoria;
import koLizja.Uprawnienia;
import koLizja.encje.Instruktor;

import java.util.Date;
import java.util.concurrent.TimeUnit;


//trzeba napisac konstruktor z mozliwoscia wybrania posiadanych uprawnien (nasze T/P)

//instruktorzy maja od 22 do 38 lat
//uprawniena zdobywaja w wieku przynajmniej 21 lat + rand(5 lat)
//zatrudnieni w OSK najpóźniej
//max 15 lat stazu


public class GeneratorInstruktorow extends GeneratorAbstract{

    private Instruktor create(){

        Instruktor instruktor = new Instruktor();

        instruktor.setImie(faker.name().firstName());
        instruktor.setNazwisko(faker.name().lastName());
        instruktor.setKategorie(Kategoria.values()[random.nextInt(3)].toString());
        Date dataUrodzenia = faker.date().between(NAJSTARSZY_INSTR, NAJMLODSZY_INSTR);
        Date dataPelnoletnosci = (new Date(
                dataUrodzenia.getYear()+21,
                dataUrodzenia.getMonth(),
                dataUrodzenia.getDay()));
        Date dataUprawnien = faker.date().future(CZAS_ZDOBYCIA_UPRAWNIEN, TimeUnit.DAYS, dataPelnoletnosci);
        Date dataZatrudnienia = faker.date().future(CZAS_ZDOBYCIA_ZATRUDNIENIA,TimeUnit.DAYS,dataUprawnien);
        instruktor.setDataUrodzenia(sdf.format(dataUrodzenia.toString()));
        instruktor.setDataUprawnien(sdf.format(dataUprawnien.toString()));
        instruktor.setDataZatrudnienia(sdf.format((dataZatrudnienia.toString())));
        instruktor.setNumTel(faker.phoneNumber().cellPhone());
        instruktor.setAdres(faker.address().city()
                + " " + faker.address().streetAddress());

        return instruktor;
    }

    public Instruktor create (int id) {

        Instruktor instruktor = new Instruktor();
        instruktor.setId(id);
        instruktor.setUprawnienia(Uprawnienia.values()[random.nextInt(2)].toString());

        return instruktor;
    }

    public Instruktor create (int id, Uprawnienia uprawnienia) {

        Instruktor instruktor = new Instruktor();
        instruktor.setId(id);
        instruktor.setUprawnienia(uprawnienia.toString());

        return instruktor;
    }
}
