package ueb10;

public class Restaurant {
	public static void main(String[] args) throws InterruptedException {
		Durchreiche<Speise> d = new DurchreicheImpl<>(5);

		new Thread(new Koch("Hans", 4, d)).start();
		new Thread(new Koch("Peter", 6, d)).start();

		new Thread(new Bedienung("Albert", 3, d)).start();
		new Thread(new Bedienung("Gisela", 4, d)).start();
		new Thread(new Bedienung("Bernd", 3, d)).start();
	}
}
