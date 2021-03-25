import java.util.Arrays;
import java.util.List;

public class City {
    //название города
    //список заказов, сделанных в этом городе одним покупателем (массив Order[])

    String name;
    List<Order> orders;

    public void setName(String name) {
        this.name = name;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public long getOrdersCount() {
        return orders != null ? orders.size() : 0;
    }


    public City(String key) {
        this.name = key;
    }
}
