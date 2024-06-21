package Controlador;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.namedparam.ParsedSql;

import Dao.TblProductoImp;
import model.TblProductocl2;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblProductocl2 producto = new TblProductocl2();
		TblProductoImp crud = new TblProductoImp();
		List<TblProductocl2> listadoproductos = crud.ListarProductos();
		
		request.setAttribute("listadoproductos", listadoproductos);
		request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		double preVenta = Double.parseDouble(request.getParameter("preVenta"));
		double preCompra = Double.parseDouble(request.getParameter("preCompra"));
		String estado = request.getParameter("estado");
		String descripcion = request.getParameter("descripcion");		
		TblProductocl2 producto = new TblProductocl2();
		TblProductoImp crud = new TblProductoImp();
		producto.setNombrecl2(nombre);
		producto.setPreciocompcl2(preCompra);
		producto.setPrecioventacl2(preVenta);
		producto.setEstadocl2(estado);
		producto.setDescripcl2(descripcion);
		
		crud.RegistrarProducto(producto);
		List<TblProductocl2> listadoproductos = crud.ListarProductos();
		request.setAttribute("listadoproductos", listadoproductos);
		request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
	}

}
