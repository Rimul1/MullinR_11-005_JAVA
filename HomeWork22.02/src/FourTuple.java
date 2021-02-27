public class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C>{
    public D four;

    public FourTuple(A first, B second, C third, D four) {
        super(first, second, third);
        this.four = four;
    }
}
