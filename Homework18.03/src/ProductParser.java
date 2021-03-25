import java.util.HashMap;
import java.util.Map;

public class ProductParser {
    public Map<String, Map<String, Integer>> parse(String[] lines) {
        Map<String, Map<String, Integer>> mapMap = new HashMap<>();

        for (String line : lines) {
            String[] split = line.split(" ");

            String name = split[0];
            String productName = split[1];
            Integer value = Integer.parseInt(split[2]);

            Map<String, Integer> last = mapMap.getOrDefault(name, new HashMap<>());

            Integer lastVal = last.getOrDefault(productName, 0);
            last.put(productName, value + lastVal);

            mapMap.put(name, last);

        }
        return mapMap;
    }
}
