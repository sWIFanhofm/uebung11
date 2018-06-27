package ueb11;

public class Kellner implements Runnable {

    private String name;
    private int anzahlSpeise;
    private Durchreiche<Speise> d;

    public Kellner(String name, int anzahlSpeise, Durchreiche<Speise> d){
        this.name = name;
        this.anzahlSpeise = anzahlSpeise;
        this.d = d;
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < anzahlSpeise; i++){
                Speise s = d.get();

                System.out.println(name + " hat " + s.toString() + " aus der Durchreiche genommen.");

                Thread.sleep((int) Math.random()* 3000);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
