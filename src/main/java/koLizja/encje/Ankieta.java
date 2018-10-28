package koLizja.encje;

import koLizja.Kategoria;
import lombok.Data;

@Data
public class Ankieta {

    String timeStamp;
    String imieNazwiskoInstruktoraTeorii;
    int poziomWiedzyInstruktoraTeorii;
    int sposobPrzekazywaniaWiedzyTeoria;
    int atmosferaZajecTeorii;
    int ocenaPrzygotowaniaTeorii;
    String instruktorSpoznialSieTeoria;
    String extraUwagi1;

    String imieNazwiskoInstruktoraPraktyki;
    int poziomWiedzyInstruktoraPraktyki;
    int sposobPrzekazywaniaWiedzyPraktyka;
    int atmosferaZajecPraktyki;
    int ocenaPrzygotowaniaPraktyki;
    String instruktorSpoznialSiePraktyka;
    String extraUwagi2;

    Kategoria kategoria;
    int ogolnaOcenaKursu;
    String skadWieszOSzkole;
    String napiszeNaTrojmiescie;
    String poleceZnajomym;

    String imie;
    String nazwisko;
    int wiek;
    String pesel;

    public String toString() {
        return timeStamp + ';' +
                imieNazwiskoInstruktoraTeorii + ';' +
                Integer.toString(poziomWiedzyInstruktoraTeorii) + ';' +
                Integer.toString(sposobPrzekazywaniaWiedzyTeoria) + ';' +
                Integer.toString(atmosferaZajecTeorii) + ';' +
                Integer.toString(ocenaPrzygotowaniaTeorii)  + ';' +
                instruktorSpoznialSieTeoria + ';' +
                extraUwagi1 + ';' +

                imieNazwiskoInstruktoraPraktyki + ';' +
                Integer.toString(poziomWiedzyInstruktoraPraktyki) + ';' +
                Integer.toString(sposobPrzekazywaniaWiedzyPraktyka) + ';' +
                Integer.toString(atmosferaZajecPraktyki) + ';' +
                Integer.toString(ocenaPrzygotowaniaPraktyki) + ';' +
                instruktorSpoznialSiePraktyka + ';' +
                extraUwagi2 + ';' +

                kategoria  + ';' +
                Integer.toString(ogolnaOcenaKursu) + ';' +
                skadWieszOSzkole + ';' +
                napiszeNaTrojmiescie + ';' +
                poleceZnajomym + ';' +

                imie + ';' +
                nazwisko + ';' +
                Integer.toString(wiek) + ';' +
                pesel+ '\r' + '\n';
    }

}
