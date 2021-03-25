import java.util.*;

public class ProductParser {
    public Map<String,Map<String ,Map<String, Integer>>> parse(List<String> lines) {
        Map<String,Map<String, Map<String, Integer>>> mapMap = new HashMap<>();

        for (String line : lines) {
            String[] split = line.split("\\|");

            String name = split[0];
            String nameCity = split[1];
            String productName = split[2];
            Integer value = Integer.parseInt(split[3]);



            Map<String, Map<String, Integer>> nameMap = mapMap.getOrDefault(name, new HashMap<>());
            Map<String,Integer> cityMap  = nameMap.getOrDefault(nameCity, new HashMap<>());

            Integer lastVal = cityMap.getOrDefault(productName, 0);
            cityMap.put(productName, value + lastVal);
            nameMap.put(nameCity, cityMap);
            mapMap.put(name,nameMap);

        }
        return mapMap;
    }
}
