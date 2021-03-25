import java.util.ArrayList;
import java.util.List;

public class Buyer {
    //имя
    //список городов, в которых покупатель делал заказы (City[])
    //
    private String nameBuyer;
    private List<City> cities = new ArrayList<>();

    public Buyer(String key) {
        this.nameBuyer = key;
    }

    public void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String getNameBuyer() {
        return nameBuyer;
    }

    public List<City> getCities() {
        return cities;
    }


    public long getOrdersCount() {
        long ordersCount = 0;

        for (City city : cities) {
            ordersCount += city.getOrders().size();
        }
        return ordersCount;
    }
}
