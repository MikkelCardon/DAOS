public class TestKlasse {

    public static void main(String[] args) {

        SnaksagligPerson jacob = new SnaksagligPerson("Jacob", 200);
        SnaksagligPerson ulla = new SnaksagligPerson("Ulla", 100);
        SnaksagligPerson hans = new SnaksagligPerson("Hans", 50);

        jacob.start();
        ulla.start();
        hans.start();

    }

}
