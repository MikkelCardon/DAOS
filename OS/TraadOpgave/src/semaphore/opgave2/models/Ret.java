package semaphore.opgave2.models;

import java.util.Random;

public enum Ret {


    PASTA(200), PIZZA(220), SALAT(150), DESSERT(100), MEGET_SVÆR_RET(3000), FORRETTER(80), HOVEDRETTER(180), SØDE_RETTER(500);


    private int tilberedningstid;
    Ret(int tilberedningsTid) {
        this.tilberedningstid = tilberedningsTid;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public int getTilberedningstid() {
        return tilberedningstid;
    }

    public static Ret getDish() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(Ret.values().length);

        return Ret.values()[randomIndex];
    }
}
