package opgave04;

public class Main {

    public static void main(String[] args) {
        Faelles faelles = new Faelles();

        MyThread t1 = new MyThread("Tråd1", faelles, 0);
        MyThread t2 = new MyThread("Tråd2", faelles, 1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Faelles.getCount());
    }
}
