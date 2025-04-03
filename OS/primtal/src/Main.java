import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int amount = 10_000_000;
        generateArray(amount);

        udenTråd();
        medTråd();
    }

    public static void udenTråd(){
        count = 0;
        long l1 = System.nanoTime();
        for (int i = 0; i < intArray.size(); i++) {
            primtal(intArray.get(i));
        }
        long l2 = System.nanoTime();

        System.out.println("Uden tråd " + (l2 - l1) / 1_000_000 + " ms");
        System.out.println(count);
    }

    public static void medTråd(){
        count = 0;
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < intArray.size()/2; i++) {
                primtal(intArray.get(i));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = (intArray.size()/2)+1; i < intArray.size(); i++) {
                primtal(intArray.get(i));
            }
        });

        long l1 = System.nanoTime();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long l2 = System.nanoTime();

        System.out.println("Med tråd: " + (l2 - l1) / 1_000_000 + " ms");
        System.out.println(count);
    }

    private static ArrayList<Integer> intArray = new ArrayList<>();
    private static int count;

    public static void generateArray(int amount){
        Random rand = new Random();

        for (int i = 0; i < amount; i++) {
            intArray.add(rand.nextInt(1_000)+1);
        }
    }

    public static void primtal(int number){
        if (number < 2){
            return;
        }
        if (number == 2){
            synchronized (Main.class) {
                count++;
            }
            return;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                return;
            }
        }
        synchronized (Main.class) {
            count++;
        }
    }
}
