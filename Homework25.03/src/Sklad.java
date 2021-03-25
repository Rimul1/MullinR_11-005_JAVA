public interface Sklad {
    void add(Goods good);

    void removeByName(String name);

    void changeCountByName(String name, Integer count);

    Goods getByName(String name);

    void printSklad();
}
