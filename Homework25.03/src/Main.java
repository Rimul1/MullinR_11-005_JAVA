
public class Main {
    public static void main(String[] args) {
        String fileName = "sklad.txt";
        Sklad sklad = new FileSklad(fileName,new GoodConvertor());

        sklad.add(new Goods("Apple", 5));
        sklad.add(new Goods("Apple1", 6));
        sklad.add(new Goods("Apple2", 8));
        sklad.add(new Goods("Apple3", 5));
        sklad.removeByName("Apple");
        sklad.changeCountByName("Apple1", 23);
        System.out.println(sklad.getByName("Apple2").getName());
        sklad.printSklad();
    }
}
