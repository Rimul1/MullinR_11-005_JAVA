import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {


        List<String> strings = Files.lines(Paths.get("C:/Users/admin/Downloads/orders.txt")).collect(Collectors.toList());

        ProductParser productParser = new ProductParser();
        Map<String, Map<String, Map<String, Integer>>> mapMap = productParser.parse(strings);

        List<Buyer> buyers = new ArrayList<>();
        for (Map.Entry<String, Map<String, Map<String, Integer>>> nameCityEntry : mapMap.entrySet()) {
            Buyer buyer = new Buyer(nameCityEntry.getKey());
            for (Map.Entry<String, Map<String, Integer>> cityOrderEntry : nameCityEntry.getValue().entrySet()) {
                City city = new City(cityOrderEntry.getKey()); //создать  в city

                for (Map.Entry<String, Integer> orderCountEntry : cityOrderEntry.getValue().entrySet()) {
                    city.getOrders().add(new Order(orderCountEntry.getKey(), orderCountEntry.getValue()));
                }

                buyer.getCities().add(city);
            }

            buyers.add(buyer);
        }

        Set<Buyer> buyers1 = new TreeSet<>(new BuyerByNameComparator());
        buyers1.addAll(new ArrayList<>(buyers));


        Set<Buyer> buyers2 = new TreeSet<>(new BuyerByOrdersCountComparator());
        buyers2.addAll(new ArrayList<>(buyers));

        writeBuyers(buyers1, "set.txt");

        writeBuyers(buyers2, "notes3.txt");

    }

    private static void writeBuyers(Set<Buyer> buyers2, String s) {
        try (FileWriter writer = new FileWriter(s, true)) {
            for (Buyer buyer : buyers2) {
                List<String> lines = buyerToString(buyer);
                for (String line : lines) {
                    System.out.println(line);
                    writer.write(line);
                    writer.append("\n");
                    writer.flush();
                }
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


    private static void print(Set<Buyer> buyers2) {
        for (Buyer buyer1 : buyers2) {
            System.out.println(buyer1.getNameBuyer());
            for (City city : buyer1.getCities()) {
                System.out.println(city.getName());
                for (Order order : city.getOrders()) {
                    System.out.println(order.getNameGoods());
                }
            }
        }
    }

    private static List<String> buyerToString(Buyer buyer) {
        List<String> results = new ArrayList<>();
        for (City city : buyer.getCities()) {
            for (Order order : city.getOrders()) {
                results.add(createLine(buyer.getNameBuyer(), city.getName(), order.getNameGoods(), order.getItem()));
            }
        }
        return results;
    }


    private static String createLine(String name, String cityName, String goodName, Integer count) {
        return String.format("%s|%s|%s|%d", name, cityName, goodName, count);
    }
}
