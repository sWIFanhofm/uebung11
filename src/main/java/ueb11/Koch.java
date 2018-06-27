package ueb11;

public class Koch implements Runnable {

    private String name;
    private int anzahlSpeise;
    private Durchreiche<Speise> d;

    public Koch(String name, int anzahlSpeise, Durchreiche<Speise> d){
        this.name = name;
        this.anzahlSpeise = anzahlSpeise;
        this.d = d;
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < anzahlSpeise; i++){
                Speise s = new Speise("Speise: " + i);

                Thread.sleep((int) (Math.random()*3000));

                d.put(s);

                System.out.println(name + " hat " + s.toString() + " in die Durchreiche gestellt.");
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
