package koLizja.encje;

import koLizja.Kategoria;
import koLizja.Uprawnienia;
import lombok.Data;

@Data
public class Instruktor {

    private int id;
    private String imie;
    private String nazwisko;
    private Uprawnienia uprawnienia;
    private Kategoria kategorie;
    private String dataZatrudnienia;
    private String dataUrodzenia;
    private String dataUprawnien;
    private String numTel;
    private String adres;

    public String toString(){
        String str = Integer.toString(id) + ';' + imie + ';' + nazwisko + ';' + uprawnienia + ';'
                    + kategorie + ';' +  dataZatrudnienia + ';' + dataUrodzenia + ';' + dataUprawnien + ';'
                    + numTel + ';' + adres;
        return str;
    }

}
