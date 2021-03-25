public class GoodConvertor {
    private static final String DIVIDER = ":";

    public String goodToString(Goods good) {
        return good.getName() + DIVIDER + good.getCount();
    }

    public Goods stringToGood(String string) {
        String[] splited = string.split(DIVIDER);
        return new Goods(splited[0], Integer.parseInt(splited[1]));
    }
}
