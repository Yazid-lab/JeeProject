package service;


import java.util.List;
import javax.ejb.Local;
import entities.Patient;



@Local
public interface ILocalPatient {
	public void addPatient(Patient patient);
	public List<Patient> listPatients();
	public Patient selectPatient(int id);
	public boolean updatePatient(Patient patient);
	public boolean deletePatient(int id);

}
