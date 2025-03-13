package opgave02;

public class MyThread extends Thread{
    private String navn;
    private int flag;
    private Faelles faelles;

    public MyThread(String navn, Faelles faelles, int flagIndex){
        this.navn = navn;
        this.faelles = faelles;
        this.flag = flagIndex;
    }

    public void run() {
        for (int j=0; j<100;j++) {

            Main.setFlag(flag, true);
            Main.setTurn(returnOther());
            while (Main.getFlag(returnOther()) && Main.getTurn() ==returnOther());

            faelles.kritiskSection();
            Main.setFlag(flag, false);


            faelles.tagerRandomTid(1_000_000);
            //Hvis dette kald af tagerRandomTid øges mindskes der fejl
            //Fordi at man mindsker risikoen for at de kører over hinanden.
        }
        System.out.println(Faelles.getCount());
    }

    private int returnOther(){
        return flag == 0 ? 1 : 0;
    }
}
