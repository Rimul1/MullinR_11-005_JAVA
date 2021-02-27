public class main {
    public static void main(String[] args) {
        //1
        FourTuple<Integer, String, String, Integer> tuple = new FourTuple<>(432, "Color", "Orange", 23);
        System.out.println(tuple.first);
        System.out.println(tuple.third);
        // 1

        //2
        int[] mas = new int[]{2, 5, 2, 1, 6};
        for (int i : new RangeInterval(2, mas.length)) {
            mas[i] = 9;
        }

        for (int i : new Range(mas.length)) {
            System.out.printf("%d ", mas[i]);
        }
        System.out.println("");
        //2


        //3
        for (int i : new FibonacciRange(52)) {
            System.out.println(i);
        }
        //3
    }
}
