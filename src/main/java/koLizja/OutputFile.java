package koLizja;

import koLizja.encje.Instruktor;

import java.io.FileWriter;
import java.util.List;

public class OutputFile {

    private static <T> void create(List<T> lista, String nazwa, String rozszerzeniePliku){

        try {

            FileWriter fileWriter = new FileWriter(nazwa+rozszerzeniePliku);
            for (T elem: lista) {
                fileWriter.write(elem.toString() + "\r\n");
            }
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static <T> void createBulk(List<T> lista, String nazwa){
        create(lista,nazwa,".bulk");
    }

    public static <T> void createCsv(List<T> lista, String nazwa){
    create(lista,nazwa,".csv");
    }

    public static <T> void createUpdate(List<Instruktor> lista, String nazwa){

        try {

            FileWriter fileWriter = new FileWriter(nazwa+".sql");
            for (Instruktor elem: lista) {
                fileWriter.write(elem.toStringForUpdate() + "\r\n");
            }
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
