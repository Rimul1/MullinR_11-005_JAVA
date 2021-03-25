import java.util.Comparator;

public class BuyerByNameComparator implements Comparator<Buyer> {
    
    @Override
    public int compare(Buyer o1, Buyer o2) {
        return Integer.compare(o1.getNameBuyer().length(), o2.getNameBuyer().length());
    }
}