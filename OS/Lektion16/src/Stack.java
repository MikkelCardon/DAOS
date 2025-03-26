public class Stack {
    private class Element {
        int info;
        Element next;

        Element(int n, Element e) {
            info = n;
            next = e;
        }
    }

    private Element first;

    public Stack() {
        first = null;
    }

    public synchronized void push(int n) {
        first = new Element(n, first);
        System.out.println(n);
        notify();
    }

    public synchronized int pop() {
        if (first == null) {
            System.out.println("Stacken er tom");
            try {
                System.out.println("Venter...");
                wait();
                int n = first.info;
                first = first.next;
                return n;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int n = first.info;
        first = first.next;
        System.out.println(n);
        return n;
    }

    public boolean is_empty() {
        return first == null;
    }
}
