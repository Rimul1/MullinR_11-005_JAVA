package SecondTask;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedlisst = new LinkedList<>();

        integerLinkedlisst.add(1);
        integerLinkedlisst.add(2);
        integerLinkedlisst.add(3);
        integerLinkedlisst.add(4);
        integerLinkedlisst.add(5);
        integerLinkedlisst.remove(3);
        for (Integer i : integerLinkedlisst) {
            System.out.println(i);
        }




    }
}
