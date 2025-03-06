public class Printer extends Thread{
    String besked;
    int delay;
    int count;

    public Printer(String besked, int delay, int count) {
        this.besked = besked;
        this.delay = delay;
        this.count = count;
    }

    @Override
    public void run(){
        for (int i = 0; i < count; i++) {
            try{
                System.out.println(besked);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
