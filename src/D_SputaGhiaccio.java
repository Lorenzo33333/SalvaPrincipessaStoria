public class D_SputaGhiaccio extends Drago implements Runnable{
    private Principessa principessaDaCatturare;

    public D_SputaGhiaccio(String nome, Principessa principessa) {
        super(nome);
        this.principessaDaCatturare = principessa;
    }
    @Override
    public void run() {
        for (int i = 0; (i < 5) && !Thread.interrupted(); i++) {
            double numeroRandom = Math.random();
            if (numeroRandom > 0.5 && "libera".equals(principessaDaCatturare.getStato())) {
                principessaDaCatturare.setStato("catturata");
                principessaDaCatturare.setCarceriere(this);
                System.out.println(this.getNome() + " ha catturato la principessa " + principessaDaCatturare.getNome());
            }
            System.out.println(this.getNome() + " sputa fuoco e si libera nell'aria! Gioia immensa, al battito " + (1 + i));
        }
    }
}