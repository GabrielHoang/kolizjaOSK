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
    private String dataUprawnien;
    private String dataUrodzenia;
    private String numTel;
    private String adres;

    public String toString(){
        String str = Integer.toString(id) + ';' + imie + ';' + nazwisko + ';' + uprawnienia + ';'
                    + kategorie + ';' +  dataZatrudnienia + ';' + dataUprawnien + ';' + dataUrodzenia + ';'
                    + numTel + ';' + adres;
        return str;
    }

    public String toStringForUpdate(){
        String str = "UPDATE dbo.Instruktor SET Kategorie='" + kategorie + "' WHERE ID_instr=" + Integer.toString(id);
        return str;
    }

}
