package opgave;

import opgave.models.Ret;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Køkken {
    private ArrayList<Ret> ordreListe = new ArrayList<>();

    Semaphore semaphore = new Semaphore(1);

    public synchronized void addOrdre(Ret ret) {
        ordreListe.add(ret);
        notify();
    }

    public synchronized Ret cookDish() {
        if (ordreListe.isEmpty()) {
            try {
                System.out.println("Køkkenet venter på ordre");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            return ordreListe.removeFirst();
    }




    public ArrayList<Ret> getOrdreListe() {
        return ordreListe;
    }
}
