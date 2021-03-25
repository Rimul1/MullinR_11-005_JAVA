import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
      /*  String[] strings = new String[]{
                "Вася | Казань | ручка |5",
                "Вася | Нижний Новгород | карандаш |3",
                "Петя | Пермь | книга |2",
                "Петя | Екатеринбург | книга |3",
                "Вася | Саратов | книга |1",
                "Петя | Самара | ручка |4"};*/

        ArrayList<String> strings = new ArrayList<>();
        try {
            File file = new File("C:/Users/admin/Downloads/orders.txt");

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                strings.add(line);
                line = reader.readLine();

            }
        } catch (FileNotFoundException e) { // Закинули в лист
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProductParser productParser = new ProductParser();
        Map<String, Map<String, Map<String, Integer>>> mapMap = productParser.parse(strings);

        for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : mapMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Map<String, Integer>> entryVal : entry.getValue().entrySet()) {
                System.out.println(entryVal.getKey() + " - " + entryVal.getValue());
            }
        }

    }
}
