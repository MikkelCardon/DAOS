package opgave01;

public class MyThread extends Thread{
    private String navn;
    private Faelles faelles;

    public MyThread(String navn, Faelles faelles){
        this.navn = navn;
        this.faelles = faelles;
    }

    public void run() {
        for (int j=0; j<100;j++) {
            faelles.kritiskSection();
            faelles.tagerRandomTid(1_000_000);
            //Hvis dette kald af tagerRandomTid øges mindskes der fejl
            //Fordi at man mindsker risikoen for at de kører over hinanden.
        }
        System.out.println(Faelles.getCount());
    }
}
