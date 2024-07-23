/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package FileServer;

import Database.SQLconnection;
import com.oreilly.servlet.MultipartRequest;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.security.Key;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nivedha.S
 */
@MultipartConfig(maxFileSize = 16177215)
public class Upload extends HttpServlet {
public static final String ALGO = "AES";
    public static byte[] keyValue = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    File file;
    final String filepath = "C:\\Users\\Nivedha.S\\Music\\Files\\";
    File file1;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            MultipartRequest m = new MultipartRequest(request, filepath);
            file = m.getFile("dfile");
            String des=m.getParameter("des");
            String filename = file.getName();
            String path = file.getPath();
            String extension = "";
            int f = filename.lastIndexOf('.');
            if (f > 0) {
                extension = filename.substring(f + 1);
            }
            String ftype = extension;
            System.out.println("path " + path);
            System.out.println("ftype " + ftype);
            System.out.println("fname " + filename);
            HttpSession user = request.getSession(true);
            String uid = user.getAttribute("uid").toString();
            String uname = user.getAttribute("uname").toString();
            String umail = user.getAttribute("umail").toString();
            Connection conn = SQLconnection.getconnection();
            Connection con = SQLconnection.getconnection();
            Random RANDOM = new SecureRandom();
            int PASSWORD_LENGTH = 16;
            String letters = "378AIJKLM5CD4NOP126EFGHB9";
            String ke = "";
            for (int i = 0; i < PASSWORD_LENGTH; i++) {
                int index = (int) (RANDOM.nextDouble() * letters.length());
                ke += letters.substring(index, index + 1);
            }
            String val = ke;
            String Dkey = val;

            BufferedReader brq = new BufferedReader(new FileReader(filepath + filename));
            StringBuffer sbq = new StringBuffer();
            String tempq = null;

            while ((tempq = brq.readLine()) != null) {
                sbq.append(tempq + "\n");
            }
            keyValue = val.getBytes();
            String fenc = encryption(sbq.toString());
            

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String time = dateFormat.format(date);
            System.out.println("current Date " + time);
            String pathf = filepath + umail;
            File newFolder = new File(pathf);
            boolean created = newFolder.mkdirs();
            file1 = new File(pathf + "//" + filename);

            System.out.println("\n\nCheck Point----->   " + fenc);
            FileWriter fw = new FileWriter(file1);
            fw.write(fenc);
            fw.close();
            
            
           
            String sql = "insert into fileupload(fname, fcontent, fdes, uid, uname, ftime,dkey) values (?, ?, ?, ?, ?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, filename);
            statement.setString(2, fenc);
            statement.setString(3, des);
            statement.setString(4, uid);
            statement.setString(5, uname);
            statement.setString(6, time);
            statement.setString(7, Dkey);
            
            int row = statement.executeUpdate();
            if (row > 0) {
                response.sendRedirect("FileUpload.jsp?Success");
            } else {
                response.sendRedirect("FileUpload.jsp?Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

public static String encryption(String data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    public static String decryption(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    public static Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue, ALGO);
    }

    static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if (val != -1) {
            bw.write(buf);
        }
    }
}
