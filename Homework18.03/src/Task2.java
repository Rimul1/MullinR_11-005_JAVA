import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String[] strings = new String[]{
                "Вася Kazan ручка 5" ,
                "Вася карандаш 3" ,
                "Петя книга 2" ,
                "Петя книга 3" ,
                "Вася книга 1" ,
                "Петя ручка 4" };

        ProductParser productParser = new ProductParser();
        Map<String,Map<String,Integer>> mapMap = productParser.parse(strings);

        for (Map.Entry<String,Map<String,Integer>> entry : mapMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Integer> entryVal : entry.getValue().entrySet()){
                System.out.println(entryVal.getKey() + " - " + entryVal.getValue());
            }
        }

    }
}
