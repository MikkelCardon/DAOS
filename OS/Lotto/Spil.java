package Lotto;

public class Spil {
    Lottoraek trækning;
    Lottoraek[] kuponer;
    int[] resultat = new int[8];

    public Spil(int antalKuponer, int threads) {
        trækning = new Lottoraek();

        kuponer = new Lottoraek[antalKuponer];
        for (int i = 0; i < antalKuponer; i++) {
            kuponer[i] = new Lottoraek();
        }
        if (threads <= 1){
            resultatUdenTraad();
        }else {
            threadCreate(threads);
        }
    }

    private void threadCreate(int amountOfThreads){
        int n = kuponer.length;
        int numberOfThreads = amountOfThreads;
        int chunkSize = n / numberOfThreads;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numberOfThreads-1) ? n : start + chunkSize;
            threads[i] = new Thread(new UdrengResultat(start, end, this)); //Parameter afhænger af klassen
            threads[i].start();
        }

        for (Thread thread : threads) {
            try{
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

    }

    private void resultatUdenTraad(){
        for (int i = 0; i < kuponer.length; i++) {
            int antalRigtige = trækning.antalrigtige(kuponer[i]);
            resultat[antalRigtige]++;
        }
    }


    public Lottoraek getTrækning() {
        return trækning;
    }

    public Lottoraek[] getKuponer() {
        return kuponer;
    }

    public int[] getResultat() {
        return resultat;
    }
}
