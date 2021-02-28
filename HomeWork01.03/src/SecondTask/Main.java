package SecondTask;

public class Main {
    public static void main(String[] args) {
        Linkedlist<Integer> integerLinkedlisst = new Linkedlist<>();

        integerLinkedlisst.add(1);
        integerLinkedlisst.add(2);
        integerLinkedlisst.add(3);
        integerLinkedlisst.add(4);
        integerLinkedlisst.add(5);


        System.out.println(integerLinkedlisst.get(1));
        System.out.println(integerLinkedlisst.get(2));
        System.out.println(integerLinkedlisst.get(3));
        System.out.println(integerLinkedlisst.get(4));
    }
}
