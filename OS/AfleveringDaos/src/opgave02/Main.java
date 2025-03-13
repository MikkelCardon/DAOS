package opgave02;

public class Main {
    private static boolean[] flag = {false, false};
    private static int turn = 0;

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

    public static boolean getFlag(int index) {
        return flag[index];
    }

    public static void setFlag(int index, boolean bool) {
        flag[index] = bool;
    }

    public static int getTurn() {
        return turn;
    }

    public static void setTurn(int turn) {
        Main.turn = turn;
    }
}
