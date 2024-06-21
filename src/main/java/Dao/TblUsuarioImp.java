package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuario;
import model.TblUsuariocl2;

public class TblUsuarioImp implements IUsuario{

	@Override
	public TblUsuariocl2 BuscarUsuario(TblUsuariocl2 usuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("LPII_CL2_BAUTISTALARACESAR");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TblUsuariocl2 busUsuario = emanager.find(TblUsuariocl2.class, usuario.getIdusuariocl2());
		emanager.getTransaction().commit();
		emanager.close();
		return busUsuario;
	}


}
