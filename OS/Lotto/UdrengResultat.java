package Lotto;

public class UdrengResultat implements Runnable{
    private int start;
    private int slut;
    private Spil spil;

    public UdrengResultat(int start, int slut, Spil spil) {
        this.start = start;
        this.slut = slut;
        this.spil = spil;
    }

    @Override
    public void run() {
        int[] resultat = spil.getResultat();
        Lottoraek trækning = spil.getTrækning();
        Lottoraek[] kuponer = spil.getKuponer();

        for (int i = start; i < slut; i++) {
            int antalRigtige = trækning.antalrigtige(kuponer[i]);

            synchronized (resultat){
                resultat[antalRigtige]++;
            }
        }
    }


}
