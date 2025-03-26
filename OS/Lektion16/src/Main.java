import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        Thread popThread = new Thread(() -> {

            for (int i = 0; i < 4; i++) {
                stack.pop();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread pushThread = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                stack.push(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        popThread.start();
        pushThread.start();
    }
}
