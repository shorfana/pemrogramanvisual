/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.koneksi.database;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author Shorfana
 */
public class koneksi {
    public Properties mypanel, myLanguage;
    private String strNamePanel;

    public koneksi() {

    }

    public String SettingPanel(String nmpanel) {
        try {
            mypanel = new Properties();
            mypanel.load(new FileInputStream("lib/database.ini"));
            strNamePanel = mypanel.getProperty(nmpanel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    e.getMessage(), "Error", 
                    JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return strNamePanel;
    }
    
}