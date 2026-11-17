import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Principessa principessa = new Principessa("Aurora");
        ArrayList<Thread> dragos = new ArrayList<>();

        D_SputaFuoco drago1 = new D_SputaFuoco("Tyde", principessa);
        D_LanciaSassi drago2 = new D_LanciaSassi("Jack", principessa);
        D_SputaGhiaccio drago3 = new D_SputaGhiaccio("Rex", principessa);

        Thread t1 = new Thread(drago1);
        Thread t2 = new Thread(drago2);
        Thread t3 = new Thread(drago3);

        dragos.add(t1);
        dragos.add(t2);
        dragos.add(t3);

        Thread sangiorgio = new Thread(new Cavaliere("San Giorgio", dragos.get(1)));
        for (Thread t : dragos) {
            t.start();
        }
        System.out.println("I draghi sono partiti per distruggere i villaggi e cercare la principessa");
        sangiorgio.start();
        try {
            sangiorgio.join();
            for (Thread t : dragos) {
                t.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Il cavaliere ha atterrato il drago e la missione è conclusa");

        StringBuilder builder = new StringBuilder();
        builder.append("C'era una volta la principessa ").append(principessa.getNome()).append(" che rischiava di essere catturata dai draghi. ");
        builder.append("Il cavaliere San Giorgio si è lanciato in una pericolosa missione per sconfiggere la minaccia. ");
        builder.append("Dopo una lotta senza esclusione di colpi, il cavaliere è riuscito a fermare i draghi. ");
        builder.append("Il regno è finalmente salvo e la pace è tornata tra gli abitanti.");

        // Salvataggio della storia tramite la classe WriteIntoFile e il JFileChooser
        WriteIntoFile writeIntoFile = new WriteIntoFile();
        writeIntoFile.ScriviDentroUnFile(builder.toString());
    }
}
