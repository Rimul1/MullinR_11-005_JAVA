public class Order {
    private String nameGoods;
    private int item;

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public int getItem() {
        return item;
    }

    public Order(String nameGoods, int item) {
        this.nameGoods = nameGoods;
        this.item = item;
    }


}
