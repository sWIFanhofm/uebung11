package ueb11;

public class Restaurant {
    public static void main(String[] args) {
        Durchreiche<Speise> d = new DurchreicheImpl<>(4);

        new Thread(new Koch("Friedrich", 3, d)).start();

        new Thread(new Kellner("Anna", 1, d)).start();
        new Thread(new Kellner("Sarah", 2, d)).start();
    }
}
