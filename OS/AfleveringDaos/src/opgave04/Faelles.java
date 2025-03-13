package opgave04;

import java.util.Random;

public class Faelles {
    private static int count = 0;

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

    public synchronized void kritiskSection(){
        int temp;
        temp = count;
        tagerRandomTid(1);
        //Hvis denne mindskes, så sker der færre fejl.
        //Fordi at det er tiden fra at man læser værdien til at man ændrer den.
        count = temp + 1;
    }
}
