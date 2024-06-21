package Test;

import Dao.TblProductoImp;
import model.TblProductocl2;
import java.util.*;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TblProductocl2 producto = new TblProductocl2();
		TblProductoImp crud = new TblProductoImp();
		
		/*producto.setDescripcl2("prueba");
		producto.setEstadocl2("disponible");
		producto.setNombrecl2("prueba");
		producto.setPrecioventacl2(244.50);
		producto.setPreciocompcl2(300.00);
		crud.RegistrarProducto(producto);
		*/
		List<TblProductocl2> listado = crud.ListarProductos();
		for(TblProductocl2 lis : listado){
			System.out.println(lis.getIdproductocl2()+" "+lis.getNombrecl2());
		}
	}

}
