package asos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generator {

    private IReceiver receiver;

    public void setReceiver(IReceiver receiver) {
        this.receiver = receiver;
    }

    private String datafile = "src/main/resources/data.txt";
    private BufferedReader reader;

    public void run() {
        if (reader == null) {
            try {
                reader = new BufferedReader(new FileReader(datafile));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (true) {
            String msg;
            try {
                msg = reader.readLine();
            } catch (IOException ex) {
                return;
            }

            if (msg == null || msg.isEmpty()) {
                return;
            }

            receiver.put(msg);
        }
    }
}
