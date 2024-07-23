/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Database;

import MailSetup.Mail;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nivedha.S
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            /* TODO output your page here. You may use following sample code. */
            String mail = request.getParameter("email");
            String pass = request.getParameter("pass");

            System.out.println("Check User name And Password : " + mail + pass);
            Connection con = SQLconnection.getconnection();
            Statement st = con.createStatement();
            Statement sto = con.createStatement();
            try {
                ResultSet rs = st.executeQuery("SELECT * FROM users where email='" + mail + "' AND pass='" + pass + "' ");
                if (rs.next()) {
                    session.setAttribute("uname", rs.getString("name"));
                    session.setAttribute("umail", rs.getString("email"));
                    session.setAttribute("uid", rs.getString("id"));

                    Random vv = new SecureRandom();
                    int PASSWORD_LENGTH = 5;
                    String letters = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    String OTP = "";
                    for (int i = 0; i < PASSWORD_LENGTH; i++) {
                        int index = (int) (vv.nextDouble() * letters.length());
                        OTP += letters.substring(index, index + 1);
                        System.out.println("OTP- "+OTP);
                    }

                    int i = sto.executeUpdate("update users set otp ='" + OTP + "' where email='" + mail + "' ");
                    String msggg = "Your OTP: " + OTP;
                    Mail ma = new Mail();
                    ma.secretMail(msggg, "OTP", mail);
                    response.sendRedirect("otp.jsp");
                } else {
                    response.sendRedirect("User.jsp?Failed");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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

}
