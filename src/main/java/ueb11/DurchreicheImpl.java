package ueb11;

import java.util.LinkedList;
import java.util.Queue;

public class DurchreicheImpl<T> implements Durchreiche<T> {

    private Queue<T> queue = new LinkedList<>();
    private int maxAnzahl;

    public DurchreicheImpl(int maxAnzahl){
        this.maxAnzahl = maxAnzahl;
    }

    @Override
    public T get() {
        T object = null;
        synchronized (queue){
            while(queue.size() == 0){
                try{
                    queue.wait();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            object = queue.remove();

            queue.notifyAll();
        }


        return object;
    }

    @Override
    public void put(T o) {
        synchronized (queue) {
            while (queue.size() >= maxAnzahl) {
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
