/* 
 * Está es la parte con la que el Html rellenar conecta y con la cual nos permitrá rellenar nuestra base de datoss 
 */

//Importamos las librerías necesarias para que podamos conectar con la base de datos y que nos muestre los mensajes

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inventario
 */
@WebServlet("/Inventario")
public class Inventario extends HttpServlet {
	private java.sql.Connection conexion = null;                    // Declaramos la variable para poser conectar con la tabla y la base de datos
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inventario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//Definimos la variable mensajes que será del tipo PrintWriter  a la cual le damos el valor de la llamada el método getWriter  mostrará al usuario los mensajes por pantalla
		
		PrintWriter mensajes = response.getWriter();

//Conectamos con la BBDD para poder empezar a trabajar sobre ella y cuando ac<bemos haremos cerraremos la conexión con la BBDD mediante conexión.close 		


		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/administracioninventario", "usuario",
					"admin");
			Statement s = conexion.createStatement();
			s.executeUpdate("INSERT INTO entradas VALUES (NULL, '" + request.getParameter("producto") + "','"
					+ request.getParameter("cantidad") + "','" + request.getParameter("precio") + "','" + request.getParameter("categoria") +"','"	+ request.getParameter("stockmin") + "')");
			mensajes.println("Tu registro se ha guardado correctamente");
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
