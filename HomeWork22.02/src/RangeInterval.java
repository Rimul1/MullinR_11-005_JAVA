import java.util.Random;

public class RangeInterval extends Range {
    public RangeInterval(int start, int end) {
        super(end);
        super.counter = start;
    }
}
