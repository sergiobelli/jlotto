package net.sb.jlotto.cli.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sb.jlotto.srv.core.Constants;
import net.sb.jlotto.srv.core.model.Estrazione;

/**
 * @author sbelli
 */
public class FileHandler {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public Estrazione readFile() {
        Estrazione estrazione = null;
        FileInputStream f_in = null;
        try {
            f_in = new FileInputStream(Constants.SER_FILE_NAME);
            ObjectInputStream obj_in = new ObjectInputStream(f_in);
            estrazione = (Estrazione) obj_in.readObject();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                f_in.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
        return estrazione;
    }

    public void writeFile(Estrazione estrazione) {
        ObjectOutputStream obj_out = null;
        try {
            FileOutputStream f_out =
                    new FileOutputStream(Constants.SER_FILE_NAME);
            obj_out = new ObjectOutputStream(f_out);
            obj_out.writeObject(estrazione);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                obj_out.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
    }
}
