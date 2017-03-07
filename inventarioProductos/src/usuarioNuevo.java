/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
@WebServlet(urlPatterns = {"/usuarioNuevo"})
public class usuarioNuevo extends HttpServlet {
    Connection conn = null;
   

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
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/administracioninventario","usuario","admin");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO usuarios VALUES (NULL,'"+request.getParameter("Nombre")+"','"+request.getParameter("Apellidos")+"','"+request.getParameter("correo")+"','"+request.getParameter("Pass")+"')");
            conn.close();
            JOptionPane.showMessageDialog(null,"Usuario registrado.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }catch (SQLException e){ 
            e.printStackTrace();
        }catch (ClassNotFoundException e){
                e.printStackTrace();
        }
        
    }

   
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
}
