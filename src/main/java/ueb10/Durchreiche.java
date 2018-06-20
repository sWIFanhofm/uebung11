package ueb10;

public interface Durchreiche<T> {
	/**
	 * Etwas aus der Durchreiche nehmen.
	 * @return
	 */
	T get();

	/**
	 * Etwas in die Durchreiche stellen.
	 * @param o
	 */
	void put(T o);
}

