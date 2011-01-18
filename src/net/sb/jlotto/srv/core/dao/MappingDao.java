/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sb.jlotto.srv.core.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sb.jlotto.srv.core.model.CarattereValore;

/**
 *
 * @author sbelli
 */
public class MappingDao {

    private static final String path = "net.sb.jlotto.srv.core.mapping.properties";

    public List<CarattereValore> list() {
        return null;
    }

    public CarattereValore get(String carattere) {
        return null;
    }

    public void insert(CarattereValore carattereValore) {
        try {
            PrintWriter writer = new PrintWriter(new File(path));
            writer.println("."+carattereValore.getLettera()+"="+carattereValore.getValore());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MappingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(CarattereValore carattereValore) {

    }

    public void delete(CarattereValore carattereValore) {

    }


    public static final void main (String[] args) {
        MappingDao md = new MappingDao();
        md.insert(new CarattereValore("&", 2000));
    }
}
