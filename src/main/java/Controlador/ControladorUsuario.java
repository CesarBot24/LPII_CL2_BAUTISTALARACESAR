package Controlador;

import java.awt.Window;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TblProductoImp;
import Dao.TblUsuarioImp;
import model.TblProductocl2;
import model.TblUsuariocl2;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorUsuario() {
		super();
		// TODO Auto-generated constructor stub
	} // fin del constructor

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	} // fin del metodo doget

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		TblUsuarioImp crud2 = new TblUsuarioImp();
		List<TblUsuariocl2> listadousuarios = crud2.ListarUsuarios();

		boolean validacion = false;
		for (TblUsuariocl2 lis : listadousuarios) {
			if (lis.getUsuariocl2().equals(usuario) && lis.getPasswordcl2().equals(password))
				validacion = true;
		}

		if (validacion) {
			TblProductoImp crud = new TblProductoImp();
			List<TblProductocl2> listadoproductos = crud.ListarProductos();
			request.setAttribute("listadoproductos", listadoproductos);
			request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
	} // Fin del metodo dopost

}
