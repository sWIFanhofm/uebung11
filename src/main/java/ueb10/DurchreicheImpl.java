package ueb10;

import java.util.LinkedList;
import java.util.Queue;

public class DurchreicheImpl<T> implements Durchreiche<T> {
	private Queue<T> queue = new LinkedList<>();
	private int maxSize;

	public DurchreicheImpl(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public T get() {
		synchronized(queue) {
			while (queue.size() == 0) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			T o = queue.remove();

			queue.notifyAll();

			return o;
		}
	}

	@Override
	public void put(T o) {
		synchronized(queue) {
			while (queue.size() >= maxSize) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			queue.add(o);
			queue.notifyAll();
		}
	}
}
