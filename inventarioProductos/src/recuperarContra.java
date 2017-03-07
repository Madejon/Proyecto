/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
/**
 *
 * @author usuario
 */
@WebServlet(urlPatterns = {"/recuperarContra"})
public class recuperarContra extends HttpServlet {
    Connection conn=null;
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
        int con=0;
        String contrasena;
        correo c = new correo();
        String correo_ = request.getParameter("correo");
        
        try{
                Class.forName("org.gjt.mm.mysql.Driver");
                conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/distribuciones_linai","usuario_","admin");
                Statement stmt = conn.createStatement();
                ResultSet resultado =stmt.executeQuery("SELECT Correo FROM usuarios");
                while (resultado.next()) { 
                        if(correo_.equals(resultado.getString("Correo"))){
                            resultado.close();
                            con=1;
                            resultado =stmt.executeQuery("SELECT Contrasena FROM usuarios WHERE Correo= '"+correo_+"'");
                            while(resultado.next()){
                                contrasena=resultado.getString("Contrasena");
                                Properties p = new Properties();
                                c.setAsunto("Mensaje automático para recuperar su contraseña en Distribuciones Linai SA");
                                c.setMensaje("Su contraseña es "+contrasena);
                                c.setUsuarioCorreo("distribuciones.linai@gmail.com");
                                c.setContra("123linai456");
                                p.put("mail.smtp.host", "smtp.gmail.com");
                                p.setProperty("mail.smtp.starttls.enable", "true");
                                p.setProperty("mail.smtp.port", "587");
                                p.setProperty("mail.smtp.user", c.getUsuarioCorreo());
                                p.setProperty("mail.smtp.auth", "true");
                                Session s = Session.getDefaultInstance(p,null);
                                BodyPart texto = new MimeBodyPart();
                                texto.setText(c.getMensaje());
                                MimeMultipart m = new MimeMultipart();
                                m.addBodyPart(texto);
                                MimeMessage mensaje = new MimeMessage(s);
                                mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
                                mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correo_));
                                mensaje.setSubject(c.getAsunto());
                                mensaje.setContent(m);
                                Transport t = s.getTransport("smtp");
                                t.connect(c.getUsuarioCorreo(),c.getContra());
                                t.sendMessage(mensaje, mensaje.getAllRecipients());
                                t.close();
                            }
                            
                        }        
                }  
                if(con==0){
                    JOptionPane.showMessageDialog(null, "Lo sentimos email no encontrado.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }    
                
            }catch (SQLException e){ 
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            
            } catch (MessagingException ex) {
            Logger.getLogger(recuperarContra.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
}
