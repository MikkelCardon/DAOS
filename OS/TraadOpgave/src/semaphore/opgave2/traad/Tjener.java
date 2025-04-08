package semaphore.opgave2.traad;

import semaphore.opgave2.Køkken;
import semaphore.opgave2.models.Ret;

public class Tjener extends Thread{

    private Køkken køkken;
    private int amount;

    public Tjener(Køkken køkken, int amount) {
        this.køkken = køkken;
        this.amount = amount;
    }

    public void run() {
        for (int i = 0; i < amount; i++) {
            køkken.addOrdre(Ret.getDish());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
