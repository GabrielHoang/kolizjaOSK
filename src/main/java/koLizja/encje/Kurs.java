package koLizja.encje;

import lombok.Data;

@Data
public class Kurs {

    private int id;
    private String nazwa;
    private String kategoria;
    private String typ;
    private int godziny;
}
