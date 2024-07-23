/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileServer;

/**
 *
 * @author Nivedha.S
 */
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.net.ftp.FTPClient;

public class FTPcon {

    FTPClient client = new FTPClient();
    FileInputStream fis = null;
    boolean status;

    /**
     *
     * @param file
     * @return
     */
    public boolean upload(File file) {
        try {
            System.out.println("Check------------------------------------->1");
            client.connect("ftp.drivehq.com");
            client.login("", "");
            client.enterLocalPassiveMode();
            fis = new FileInputStream(file);
            System.out.println("Check------------------------------------->2");
            status = client.storeFile("/" + file.getName(), fis);
            //file path of drive storage
            client.logout();
            fis.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        if (status) {
            System.out.println("success");
            return true;
        } else {
            System.out.println("failed");
            return false;

        }

    }
}
