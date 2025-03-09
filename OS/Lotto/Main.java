package Lotto;

public class Main {
    public static void main(String[] args) {
        resultThreads(1);
        resultThreads(2);
        resultThreads(3);
        resultThreads(4);



    }
    private static void resultThreads(int amountOfThreads){
        long l1 = System.nanoTime();
        Spil spil = new Spil(10_000_000, amountOfThreads);
        long l2 = System.nanoTime();

        System.out.println("Antal tråde: "+amountOfThreads+" - Tid: " + ((l2-l1)/1000000) + " ms");
        //printResult(spil);
    }

    private static void printResult(Spil spil){
        System.out.println("__________________________");

        System.out.println("Antal kuponer med x antal rigtige:");
        int[] resultat = spil.getResultat();
        int count = 0;
        for (int i = 0; i < resultat.length; i++) {
            System.out.println(i + ": " + resultat[i]);
            count += resultat[i];
        }
        System.out.println("Count: " + count);
    }
}
