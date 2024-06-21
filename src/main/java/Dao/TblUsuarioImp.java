package Dao;

import javax.persistence.EntityManager;
import java.util.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuario;
import model.TblProductocl2;
import model.TblUsuariocl2;

public class TblUsuarioImp implements IUsuario{

	@Override
	public List<TblUsuariocl2> ListarUsuarios() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("LPII_CL2_BAUTISTALARACESAR");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TblUsuariocl2> listadousuarios = emanager.createQuery("select p from TblUsuariocl2 p", TblUsuariocl2.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listadousuarios;
	}


}
