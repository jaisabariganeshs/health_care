/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nivedha.S
 */
public class SQLconnection {
    
static Connection con;

    
    /**
     *
     * @return
     */
    public static Connection getconnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/regform", "root", "root");
        } catch (Exception e) {
        }
        return con;
    }
}

    

