package koLizja.encje;

import koLizja.Kategoria;
import koLizja.Typ;
import lombok.Data;

@Data
public class Kurs {

    private int id;
    private String nazwa;
    private Kategoria kategoria;
    private Typ typ;
    private int godziny;

    public String toString(){
        String str = Integer.toString(id) + ';' + nazwa + ';' + kategoria + ';' + typ + ';' + godziny + '\r' + '\n';
        return str;
    }

}

