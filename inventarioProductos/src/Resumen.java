

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resumen
 */
@WebServlet("/Resumen")
public class Resumen extends HttpServlet {
	private java.sql.Connection conexion = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resumen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter mensajes=response.getWriter();
		mensajes.println("<table border=1>");
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/administracioninventario", "usuario", "admin");
			Statement s=conexion.createStatement();
			ResultSet resultado=s.executeQuery("SELECT * from entradas where cantidad>=stockmin order by categoria");
		
		while(resultado.next())
		{
			
			mensajes.println("<tr><td>"+resultado.getObject("identrada")+"</td><td>"+resultado.getObject("producto")+"</td><td>"+resultado.getObject("cantidad")+"</td><td>"+resultado.getObject("precio")+"</td><td>"+resultado.getObject("categoria")+"</td><td>"+resultado.getObject("stockmin")+"</td></tr>");
		}
			conexion.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
			
		
		catch(ClassNotFoundException e){
			e.printStackTrace();
	
		}
		mensajes.println("</table>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
