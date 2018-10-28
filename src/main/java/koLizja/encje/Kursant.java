package koLizja.encje;

import lombok.Data;

@Data
public class Kursant {

    private String pesel;
    private String imie;
    private String nazwisko;
    private String adres;
    private String numTel;

    public String toString(){
        String str = pesel + ';' + imie + ';' + nazwisko + ';' + adres + ';' + numTel  + '\r' + '\n';
        return str;
    }

}
