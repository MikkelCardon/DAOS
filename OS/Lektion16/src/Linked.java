import java.util.Iterator;
import java.util.LinkedList;

public class Linked {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);

        linkedList.add(1, 2);
        linkedList.add(4);

        linkedList.add(10, 2);
    }
}
