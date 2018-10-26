package koLizja.encje;

import lombok.Data;

@Data
public class Uczenie {

    private int idKursu;
    private int peselKursanta;
    private int idInstruktoraTeorii;
    private int idInstruktoraPraktyki;
    private String dataRozpoczecia;
    private int podejsciaTeoria;
    private int podejsciaPraktyka;

    public Uczenie(Kurs kurs, Kursant kursant, Instruktor instruktorTeorii, Instruktor instruktorPraktyki) {
        this.idKursu = kurs.getId();
        this.peselKursanta = kursant.getPesel();
        this.idInstruktoraTeorii = instruktorTeorii.getId();
        this.idInstruktoraPraktyki = instruktorPraktyki.getId();
    }

    //test
    public Uczenie(Kurs kurs) {

    }
}
