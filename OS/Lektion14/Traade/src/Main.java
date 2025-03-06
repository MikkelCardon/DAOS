public class Main {
    public static void main(String[] args) {
        Printer velkommen = new Printer("Velkommen", 200, 2);
        Printer godmorgen = new Printer("Godmorgen", 500, 4);

        velkommen.start();
        godmorgen.start();
    }
}
