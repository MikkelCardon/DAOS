package Lotto;

import java.util.Random;

public class Lottoraek {
    private boolean[] række = new boolean[37];


    public Lottoraek() {
        for (int j = 0; j < 37; j++)
            række[j] = false;
        int antal = 0;
        Random r = new Random();

        while (antal < 7) {
            int tal = Math.abs(r.nextInt() % 36 + 1);
            if (!række[tal]) {
                række[tal] = true;
                antal++;
            }
        }
    }

    public boolean[] getRække() {
        return række;
    }

    public int antalrigtige(Lottoraek rigtig) {
        int x = 0;
        for (int j = 1; j < 37; j++)
            if (this.række[j] && rigtig.række[j])
                x++;
        return x;
    }

}

