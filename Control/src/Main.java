import java.io.*;
import java.util.*;

public class Main<buyers2> {
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

        List<Buyer> buyerList = new ArrayList<>();

        Set<Buyer> buyers1 = new TreeSet<>(new BuyerByNameComparator()
                .thenComparing(new BuyerByCityCountComparator()
                        .thenComparing(new BuyerByOrdersCountComparator())));
        buyers1.addAll(buyerList);


        Set<Buyer> buyers2 = new TreeSet<>(new BuyerByOrdersCountComparator()
                .thenComparing(new BuyerByCityCountComparator()
                        .thenComparing(new BuyerByNameComparator())));
        buyers2.addAll(buyerList);


        List<Buyer> buyers = new ArrayList<>();
        Map<String, Map<String, Map<String, Integer>>> mapmap = new HashMap<>();
        for (Map.Entry<String, Map<String, Map<String, Integer>>> nameCityEntry : mapmap.entrySet()) {
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

        for (Buyer buyer : buyers1) {
            List<String> lines = buyerToString(buyer);
            for (String line : lines) {
                try(FileWriter writer = new FileWriter("set.txt", false))
                {

                    writer.write(line);

                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
            }
        }

        for (Buyer buyer : buyers2) {
            List<String> lines = buyerToString(buyer);
            for (String line : lines) {
                try(FileWriter writer = new FileWriter("notes3.txt", false))
                {

                    writer.write(line);

                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
            }
        }

            f(buyers2);
        }

        private static void f (Set < Buyer > buyers2) {
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

        private static List<String> buyerToString (Buyer buyer){
            List<String> results = new ArrayList<>();
            for (City city : buyer.getCities()) {
                for (Order order : city.getOrders()) {
                    results.add(createLine(buyer.getNameBuyer(), city.getName(), order.getNameGoods(), order.getItem()));
                }
            }
            return results;
        }


        private static String createLine (String name, String cityName, String goodName, Integer count){
            return String.format("%s|%s|%s|%d", name, cityName, goodName, count);
        }
    }
