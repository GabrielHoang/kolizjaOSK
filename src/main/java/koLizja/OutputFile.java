package koLizja;

import java.io.FileWriter;
import java.util.List;

public class OutputFile {

    public static <T> void create(List<T> lista, String nazwa){

        try {

            FileWriter fileWriter = new FileWriter(nazwa+".bulk");
            for (T elem: lista) {
                fileWriter.write(elem.toString());
            }
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
