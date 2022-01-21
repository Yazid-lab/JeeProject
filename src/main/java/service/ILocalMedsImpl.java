package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Meds;


@Stateless
public class ILocalMedsImpl implements ILocalMeds {
	@PersistenceContext(unitName="UP_gestioncabinet")
	EntityManager em;

	@Override
	public void addMeds(Meds med) {
		em.persist(med);
	}

	@Override
	public List<Meds> listMeds() {
		Query req=em.createQuery("select m from Meds m");
		return req.getResultList();	
	}

	@Override
	public Meds selectMeds(int id) {
		return em.find(Meds.class, id);
	}

	@Override
	public boolean updateMeds(Meds med) {
		Query query=em.createQuery("UPDATE Meds m SET m.nameMed = :newname "
	              + "WHERE m.idMed = :enteredid");
		query.setParameter("newname",med.getNameMed());
		query.setParameter("enteredid",med.getIdMed());	
		
		
		return  query.executeUpdate()>0;
	}

	@Override
	public boolean deleteMeds(int id) {
		Query query=em.createQuery("DELETE FROM Meds m WHERE m.idMed= :idm");
		int deletedCount = query.setParameter("idm", id).executeUpdate();
		return deletedCount>0;
	}

}
