public class Buyer {
    //имя
    //список городов, в которых покупатель делал заказы (City[])
    //
    String nameBuyer;
    City[] cities;

    public void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public String getNameBuyer() {
        return nameBuyer;
    }

    public City[] getCities() {
        return cities;
    }

    public Buyer(String nameBuyer, City[] cities) {
        this.nameBuyer = nameBuyer;
        this.cities = cities;
    }
}
