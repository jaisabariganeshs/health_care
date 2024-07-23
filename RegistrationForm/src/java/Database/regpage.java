/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nivedha.S
 */
public class regpage extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            String Name=request.getParameter("Name");
            String Email=request.getParameter("Email");
            String Phone=request.getParameter("Phone");
            String Address=request.getParameter("Address");
            String Password=request.getParameter("Password");
            String age=request.getParameter("age");
            String gender=request.getParameter("gender");
             
            DateFormat dateformat =new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
            Date date=new Date();
            String time=dateformat.format(date);
            System.out.println("Date and time "+time);
            
            Connection con=SQLconnection.getconnection();
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            
            ResultSet www=st1.executeQuery("Select * from users where email='"+Email+"'");
            int count=0;
            while(www.next())
            {
            count++;
            }
           if(count >0)
           {
           response.sendRedirect("register.jsp?MailExist");
           }
           else{
           
           try{
               
             int i=st2.executeUpdate("insert into users(name, email, phone, address, pass, regtime,age,gender)values('"+Name+"','"+Email+"','"+Phone+"','"+Address+"','"+Password+"','"+time+"','"+age+"','"+gender+"')");
              if(i !=0) 
              {
                  System.out.println("Success");
                  response.sendRedirect("User.jsp?Success");
              }
              else{
                  System.out.println("Failed");
                  response.sendRedirect("register.jsp?Failed");
              }
           
           }
           catch(Exception sss){
           sss.printStackTrace();
           }

           }
   
        } catch (SQLException ex) {
            Logger.getLogger(regpage.class.getName()).log(Level.SEVERE, null, ex);
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
