import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteIntoFile {
    public String ScriviDentroUnFile(String testo) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleziona il file in cui salvare la storia");
        int selezioneutente = fileChooser.showSaveDialog(null);

        if (selezioneutente != JFileChooser.APPROVE_OPTION) {
            System.out.println("Operazione annullata dall'utente.");
            return null;
        }

        File fileSelezionato = fileChooser.getSelectedFile();
        System.out.println("File selezionato: " + fileSelezionato.getAbsolutePath());

        try (FileWriter scrittoreFile = new FileWriter(fileSelezionato)) {
            scrittoreFile.write(testo + System.lineSeparator());
            System.out.println("Salvataggio della storia avvenuto con successo!");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file: " + e.getMessage());
        }

        return null;
    }
}