package semaphore.opgave2.traad;

import semaphore.opgave2.Køkken;
import semaphore.opgave2.models.Ret;

public class Kok extends Thread{
    private Køkken køkken;
    private int amount = 10;
    private static int id = 1;
    private int kokId;
    private String kokNavn;

    public Kok(Køkken køkken, int amount, String kokNavn) {
        this.køkken = køkken;
        this.amount = amount;
        this.kokId = id++;
        this.kokNavn = kokNavn;
    }

    public void run() {
        for (int i = 0; i < amount; i++) {
            Ret ret = køkken.cookDish();
            int cookingTime = ret.getTilberedningstid();

            try {
                Thread.sleep(cookingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(kokNavn+" "+kokId+" har lavet " + ret + " og det tog " + cookingTime + " ms");
        }
    }
}
