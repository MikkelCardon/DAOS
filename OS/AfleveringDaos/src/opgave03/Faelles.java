package opgave03;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Faelles {
    private static int count = 0;
    private Semaphore s = new Semaphore(1);

    public void tagerRandomTid(int max){
        Random r = new Random();
        int nymax = Math.abs(r.nextInt())% max +1;

        int randomTal;
        for (int outer = 0; outer < nymax; outer++) {
            for (int inner = 0; inner < nymax; inner++) {
                randomTal = (outer + inner) - (inner-outer);
            }
        }

    }

    public static int getCount() {
        return count;
    }

    public void kritiskSection(){
        try {
            s.acquire();
            int temp;
            temp = count;
            tagerRandomTid(1);
            //Hvis denne mindskes, så sker der færre fejl.
            //Fordi at det er tiden fra at man læser værdien til at man ændrer den.
            count = temp + 1;
            s.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
