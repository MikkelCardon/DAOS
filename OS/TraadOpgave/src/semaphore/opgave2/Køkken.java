package semaphore.opgave2;

import semaphore.opgave2.models.Ret;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Køkken {
    private ArrayList<Ret> ordreListe = new ArrayList<>();

    private Semaphore availableOrders = new Semaphore(0);
    private Semaphore access = new Semaphore(1);

    public void addOrdre(Ret ret) {
        try {
            access.acquire();
            ordreListe.add(ret);

            access.release();
            availableOrders.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Ret cookDish() {
        try {
            availableOrders.acquire();
            access.acquire();

            Ret ret = ordreListe.removeFirst();
            access.release();
            return ret;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
