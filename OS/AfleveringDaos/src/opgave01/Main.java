package opgave01;

public class Main {
    public static void main(String[] args) {
        Faelles faelles = new Faelles();

        MyThread t1 = new MyThread("Tråd1", faelles);
        MyThread t2 = new MyThread("Tråd2", faelles);

        t1.start();
        t2.start();
    }
}
