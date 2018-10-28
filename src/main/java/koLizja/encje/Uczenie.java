package koLizja.encje;

import lombok.Data;

@Data
public class Uczenie {

    private int idKursu;
    private String peselKursanta;
    private int idInstruktoraTeorii;
    private int idInstruktoraPraktyki;
    private String dataRozpoczecia;
    private int podejsciaTeoria;
    private int podejsciaPraktyka;

    public Uczenie(Kurs kurs, Kursant kursant, Instruktor instruktorTeorii, Instruktor instruktorPraktyki,
                   String dataRozpoczecia, int podejsciaTeoria, int podejsciaPraktyka) {
        this.idKursu = kurs.getId();
        this.peselKursanta = kursant.getPesel();
        this.idInstruktoraTeorii = instruktorTeorii.getId();
        this.idInstruktoraPraktyki = instruktorPraktyki.getId();
        this.dataRozpoczecia = dataRozpoczecia;
        this.podejsciaTeoria = podejsciaTeoria;
        this.podejsciaPraktyka = podejsciaPraktyka;
    }

    public String toString(){
        String str = Integer.toString(idKursu) + ';' + peselKursanta + ';' + idInstruktoraTeorii + ';'
                + idInstruktoraPraktyki + ';' + dataRozpoczecia + ';' + Integer.toString(podejsciaTeoria) + ';'
                + Integer.toString(podejsciaPraktyka)  + '\r' + '\n';
        return str;
    }
}
