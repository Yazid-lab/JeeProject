package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Patients")
public class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToMany
	@JoinTable(name = "patient_meds",joinColumns = @JoinColumn(name="patient_id"),inverseJoinColumns = @JoinColumn(name="meds_id"))
	private List<Meds> medsTaken= new ArrayList<>();
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPatient;
	private String namePatient;
	private String emailPatient;
	private String countryPatient;
	
	
	
	
	public Patient() {
		super();
	}

	

	public Patient(List<Meds> medsTaken, int idPatient, String namePatient, String emailPatient,
			String countryPatient) {
		super();
		this.medsTaken = medsTaken;
		this.idPatient = idPatient;
		this.namePatient = namePatient;
		this.emailPatient = emailPatient;
		this.countryPatient = countryPatient;
	}



	public Patient(String namePatient, String emailPatient, String countryPatient) {
		super();
		this.namePatient = namePatient;
		this.emailPatient = emailPatient;
		this.countryPatient = countryPatient;
	}

	@Override
	public String toString() {
		return "Patient [medsTaken=" + medsTaken + ", idPatient=" + idPatient + ", namePatient=" + namePatient
				+ ", emailPatient=" + emailPatient + ", countryPatient=" + countryPatient + "]";
	}

	public Patient(int idPatient, String namePatient, String emailPatient, String countryPatient) {
		super();
		this.idPatient = idPatient;
		this.namePatient = namePatient;
		this.emailPatient = emailPatient;
		this.countryPatient = countryPatient;
	}
	
	public List<Meds> getMedsTaken() {
		return medsTaken;
	}



	public void setMedsTaken(List<Meds> medsTaken) {
		this.medsTaken = medsTaken;
	}



	public void addMed(Meds med) {
		medsTaken.add(med);
		med.getPatients().add(this);
	
	}
	public void removeMed(Meds med) {
		medsTaken.remove(med);
		med.getPatients().remove(this);
	}


	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public String getNamePatient() {
		return namePatient;
	}
	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}
	public String getEmailPatient() {
		return emailPatient;
	}
	public void setEmailPatient(String emailPatient) {
		this.emailPatient = emailPatient;
	}
	public String getCountryPatient() {
		return countryPatient;
	}
	public void setCountryPatient(String countryPatient) {
		this.countryPatient = countryPatient;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryPatient, emailPatient, idPatient, medsTaken, namePatient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(countryPatient, other.countryPatient) && Objects.equals(emailPatient, other.emailPatient)
				&& idPatient == other.idPatient && Objects.equals(medsTaken, other.medsTaken)
				&& Objects.equals(namePatient, other.namePatient);
	}





}
