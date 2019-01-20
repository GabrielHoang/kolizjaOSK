package koLizja.generatory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

//Generator peseli najprzód generuje określoną ilość unikalnych peseli (po kolei dla zadanej liczby),
//MIESZA JE, po czym możliwe jest wyciągnięcie z jego listy peselu po jego numerze id.

public class GeneratorPeseli extends GeneratorAbstract{

    private static GeneratorPeseli instance;
    private List<String> listaPeseli = new ArrayList<>();

    private final static Logger logger = Logger.getLogger(Logger.class.getName());


    private GeneratorPeseli() {
        int rokPierwszaCyfra, rokDrugaCyfra, miesiacPierwszaCyfra, miesiacDrugaCyfra, dzien, koniecNumeru;
        //ilosc danych generowana domyslnie to 5130
        //generowanie z lekkim nadmiarem
        //int iloscObrotowPetli = ILOSC_ZADANA/5080;

        //to jest poor programming example
        for(rokPierwszaCyfra = PIERWSZA_CYFRA_ROKU_OD; rokPierwszaCyfra <= PIERWSZA_CYFRA_ROKU_DO; rokPierwszaCyfra++) {
            for(rokDrugaCyfra = DRUGA_CYFRA_ROKU_OD; rokDrugaCyfra <= DRUGA_CYFRA_ROKU_DO; rokDrugaCyfra++) {
                for(miesiacPierwszaCyfra = PIERWSZA_CYFRA_MIESIACA_OD; miesiacPierwszaCyfra<=PIERWSZA_CYFRA_MIESIACA_DO; miesiacPierwszaCyfra++) {
                    for(miesiacDrugaCyfra = DRUGA_CYFRA_MIESIACA_OD; miesiacDrugaCyfra<=DRUGA_CYFRA_MIESIACA_DO;miesiacDrugaCyfra++) {
                        for(dzien = DNI_OD; dzien <=DNI_DO; dzien++) {
                            for(koniecNumeru = KONIEC_NUMERU_OD; koniecNumeru<=KONIEC_NUMERU_DO; koniecNumeru++) {
                                listaPeseli.add((
                                        Integer.toString(rokPierwszaCyfra)
                                                + Integer.toString(rokDrugaCyfra)
                                                + Integer.toString(miesiacPierwszaCyfra)
                                                + Integer.toString(miesiacDrugaCyfra)
                                                + Integer.toString(dzien)
                                                + Integer.toString(koniecNumeru))
                                );
                            }
                        }
                    }
                }
            }
        }


        Collections.shuffle(listaPeseli);
    }

    public static GeneratorPeseli getInstance() {
        if(instance==null) {
            instance = new GeneratorPeseli();
        }
        return instance;
    }

    public String getNumer(int i) {
        return listaPeseli.get(i);
    }
    public void printRozmiarListy() {
        logger.info("Lista zawiera: " + listaPeseli.size());
    }

}
