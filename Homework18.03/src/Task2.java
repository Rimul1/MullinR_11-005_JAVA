import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Map<String, Map<String,Integer>> mapMap = new HashMap<>();

        Scanner in = new Scanner(System.in);
        String line;
        while (!(line = in.nextLine()).equals("Q")){
            String[] split = line.split(" ");
            String name = split[0];
            String productName = split[1];
            Integer value = Integer.parseInt(split[2]);

            Map<String, Integer> last = mapMap.getOrDefault(name,new HashMap<>());

            Integer lastValue = last.getOrDefault(productName, 0);
            last.put(productName,value + lastValue);
            mapMap.put(name, last);

        }

        for (Map.Entry<String,Map<String,Integer>> entry : mapMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Integer> entryVal : entry.getValue().entrySet()){
                System.out.println(entryVal.getKey() + " - " + entryVal.getValue());
            }
        }

    }
}
