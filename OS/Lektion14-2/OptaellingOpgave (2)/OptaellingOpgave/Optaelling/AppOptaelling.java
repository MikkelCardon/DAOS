package Optaelling;

public class AppOptaelling {

    public static void main(String[] args) {
        long l1,l2;

        timeDifference();


//        Optaelling.Optaelling.fillArray();
//        //Optaelling.Optaelling.printArray();
//
//        l1 = System.nanoTime();
//        Optaelling.Optaelling.optaelling();
//        //Optaelling.Optaelling.optaellingtraad();
//        l2 = System.nanoTime();
//        Optaelling.Optaelling.printOptaelling();
//
//        System.out.println();
//        System.out.println("Koeretiden er: " + (l2-l1)/1000000);
//
//        System.out.println("__________________________");




    }
    public static void timeDifference(){
        long l1, l2;
        long l3, l4;
        Optaelling.fillArray();

        System.out.println("ANTAL STEMMER: " + Optaelling.getAntalStemmer());

        l1 = System.nanoTime();
        Optaelling.optaelling();
        l2 = System.nanoTime();

        l3 = System.nanoTime();
        Optaelling.optaellingtraad();
        l4 = System.nanoTime();

        System.out.println("NORMAL:");
        System.out.println("Koeretiden er: " + (l2-l1)/1000000 + " ms");

        System.out.println("TRÅD:");
        System.out.println("Koeretiden er: " + (l4-l3)/1000000 + " ms");
        System.out.println("Tråd forskel: " + (((l4-l3)/1000000)-((l2-l1)/1000000)) + " ms");
    }
}
