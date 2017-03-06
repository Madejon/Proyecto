

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
 * Servlet implementation class Borrar
 */
@WebServlet("/Borrar")
public class Borrar extends HttpServlet {
	private java.sql.Connection conexion = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Borrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
PrintWriter mensajes = response.getWriter();
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/administracioninventario", "usuario",
				"admin");
			Statement s= conexion.createStatement();
			String x=request.getParameter("producto");
			
			ResultSet resultado= s.executeQuery("SELECT identrada FROM entradas WHERE producto='"+x+"'");
			
			while (resultado.next()){
				
				int id= resultado.getInt("identrada");
				s.executeUpdate("DELETE FROM entradas WHERE identrada="+id);
			
			}
			
			mensajes.println("Registros actualizados");
		
			resultado.close();
			conexion.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
