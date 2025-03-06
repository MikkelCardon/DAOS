package Optaelling;

import java.util.Random;

public class Optaelling{

    private static String[] muligeNavne = {"Allan", "Bodil", "Camilla", "Dorthe", "Erik", "Frede", "Gitte", "Henning", "Ib", "John" };

    private static int[] optaelling = new int[muligeNavne.length];
    private static int[] optaellingTråd = new int[muligeNavne.length];

    private static int antalStemmer = 100_000_000;

    private static String[] stemmer = new String[antalStemmer];

    public static void optaelling(){
        for (String s : stemmer) {
            for (int i = 0; i < muligeNavne.length; i++) {
                if (muligeNavne[i].equals(s)){
                    optaelling[i]++;
                    break;
                }
            }
        }
    }

    public static void optaellingtraad()  {
        int mid = stemmer.length / 2;

        TraadKlasse t1 = new TraadKlasse(0, mid, stemmer);
        TraadKlasse t2 = new TraadKlasse(mid+1, stemmer.length, stemmer);

        try{
            t1.start();
            t2.start();

            t1.join();
            t2.join();
            int[] t1Array = t1.getOptaelling();
            int[] t2Array = t2.getOptaelling();

            for (int i = 0; i < muligeNavne.length; i++) {
                optaellingTråd[i] = t1Array[i] + t2Array[i];
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillArray(){
        Random random = new Random();
        for(int i = 0; i<stemmer.length; i++){
            stemmer[i] = muligeNavne[random.nextInt(10)];
        }
    }

    public static void printArray(){
        for(int i = 0; i<stemmer.length; i++){
            System.out.print(stemmer[i] + " ");
        }
        System.out.println();
    }

    public static void printOptaelling(){
        for(int i = 0; i < optaelling.length; i++){
            System.out.println(muligeNavne[i] + " har fået " + optaelling[i] + " stemmer");
        }
    }
    public static String[] getMuligeNavne(){
        return muligeNavne;
    }

    public static int getAntalStemmer() {
        return antalStemmer;
    }
}
