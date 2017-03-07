/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
@WebServlet(urlPatterns = {"/servletSalida"})
public class servletSalida extends HttpServlet {
    Connection conn=null;
    int con=0;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
        request.getRequestDispatcher("salida.jsp").forward(request, response);
        
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
        String email= request.getParameter("Email");
        String contra = request.getParameter("Pass");
        
            try{
                Class.forName("org.gjt.mm.mysql.Driver");
                conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/administracioninventario","usuario","admin");
                Statement stmt = conn.createStatement();
                ResultSet resultado =stmt.executeQuery("SELECT email FROM usuarios");
                while (resultado.next()) { 
                        if(email.equals(resultado.getString("email"))){
                            resultado =stmt.executeQuery("SELECT contrasena FROM usuarios WHERE email = '"+email+"'");
                            while (resultado.next()) { //Es mas correcto poner el next en el while, te hace lo mismo que tenias en tu antiguo codigo pero en menos lineas y mas limpio
                                if(contra.equals(resultado.getString("contrasena"))){
                                    HttpSession httpsession = request.getSession();
                                    httpsession.getAttribute(request.getParameter("Nombre"));
                                    request.getRequestDispatcher("salida.jsp").forward(request, response);
                                    con=1;
                                }
                                    
                   
                            }
                        }
                }
                if(con==0){
                    JOptionPane.showMessageDialog(null, "Lo sentimos, su email no existe o contraseña inválida");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                
            conn.close();
            }catch (SQLException e){ 
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            
            }
       
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   


