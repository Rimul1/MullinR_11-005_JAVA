public class City {
    //название города
    //список заказов, сделанных в этом городе одним покупателем (массив Order[])

    String name;
    Order[] orders;

    public void setName(String name) {
        this.name = name;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public Order[] getOrders() {
        return orders;
    }

    public long getOrdersCount() {
        return orders != null ? orders.length : 0;
    }


    public City(String name, Order[] orders) {
        this.name = name;
        this.orders = orders;
    }
}
