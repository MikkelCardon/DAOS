package opgave;

import opgave.traad.Kok;
import opgave.traad.Tjener;

public class Main {
    public static void main(String[] args) {
        Køkken køkken = new Køkken();

        Tjener tjener = new Tjener(køkken, 20);
        Kok kok = new Kok(køkken, 10, "Big kok");
        Kok kok2 = new Kok(køkken, 10, "Little kok");

        tjener.start();
        kok.start();
        kok2.start();
    }
}
