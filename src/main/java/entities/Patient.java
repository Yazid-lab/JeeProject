package entities;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

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
	private Set<Meds> medsTaken;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPatient;
	private String namePatient;
	private String emailPatient;
	private String countryPatient;
	
	
	
	
	public Patient() {
		super();
	}

	public Patient(String namePatient, String emailPatient, String countryPatient) {
		super();
		this.namePatient = namePatient;
		this.emailPatient = emailPatient;
		this.countryPatient = countryPatient;
	}

	public Patient(int idPatient, String namePatient, String emailPatient, String countryPatient) {
		super();
		this.idPatient = idPatient;
		this.namePatient = namePatient;
		this.emailPatient = emailPatient;
		this.countryPatient = countryPatient;
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
		return Objects.hash(countryPatient, emailPatient, idPatient, namePatient);
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
				&& idPatient == other.idPatient && Objects.equals(namePatient, other.namePatient);
	}





}
