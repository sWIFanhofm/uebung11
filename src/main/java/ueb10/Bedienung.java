package ueb10;

public class Bedienung implements Runnable {
	private final String name;
	private int n;
	Durchreiche<Speise> d;

	Bedienung(String name, int n, Durchreiche<Speise> d) {
		this.name = name;
		this.n = n;
		this.d = d;
	}

	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			Speise s = d.get();
			System.out.println(name + " hat " + s + " aus der Durchreiche genommen.");

			try {
				Thread.sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
