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


}

