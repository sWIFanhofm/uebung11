package ueb10;

public class Koch implements Runnable {
	private final String name;
	private int n;
	private Durchreiche<Speise> d;

	Koch(String name, int n, Durchreiche<Speise> d) {
		this.name = name;
		this.n = n;
		this.d = d;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < n; i++) {
				Speise s = new Speise("Essen " + i);

				// warten bis die Speise fertig gekocht ist
				Thread.sleep((int) (Math.random() * 3000));

				d.put(s);
				System.out.println(name + " hat " + s.toString() + " in die Durchreiche gestellt");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
