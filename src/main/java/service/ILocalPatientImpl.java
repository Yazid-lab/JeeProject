package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Meds;
import entities.Patient;


@Stateless
public class ILocalPatientImpl implements ILocalPatient {

	@PersistenceContext(unitName="UP_gestioncabinet")
	EntityManager em;
	@Override
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub
		em.persist(patient);
	}

	@Override
	public List<Patient> listPatients() {
		Query req=em.createQuery("select p from Patient p");
		return req.getResultList();	
	}

	@Override
	public Patient selectPatientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePatient(Patient patient,Meds med) {
		Query query=em.createQuery("UPDATE Patient p SET p.namePatient = :newname , p.emailPatient = :newemail , p.countryPatient = :newcountry , p.medtaken= :med "
	              + "WHERE p.idPatient = :enteredid");
		query.setParameter("newname",patient.getNamePatient());
		query.setParameter("newemail",patient.getEmailPatient());
		query.setParameter("newcountry",patient.getCountryPatient());
		query.setParameter("enteredid",patient.getIdPatient());	
		query.setParameter("med", med);
		
		return  query.executeUpdate()>0;
	}

	@Override
	public boolean deletePatient(int id) {
		Query query=em.createQuery("DELETE FROM Patient p WHERE p.idPatient = :idc");
		int deletedCount = query.setParameter("idc", id).executeUpdate();
		return deletedCount>0;
	}

}
