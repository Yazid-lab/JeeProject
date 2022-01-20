package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity @Table(name = "Patients")
public class Patient implements Serializable {



	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//	@ManyToOne
//	@JoinTable( name = "PATIENT_MEDS",
//	joinColumns = @JoinColumn( name = "idPatient" ),
//	inverseJoinColumns = @JoinColumn( name = "idMed" ) )
//	private List<Meds> meds =new ArrayList<>();
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
	//	public void setMeds(List<Meds> meds) {
	//		this.meds = meds;
	//	}
	//	@Override
	//	public String toString() {
	//		return "Patient [idPatient=" + idPatient + ", namePatient=" + namePatient + ", emailPatient=" + emailPatient
	//				+ ", countryPatient=" + countryPatient + ", meds=" + meds + "]";
	//	}
	//	@Override
	//	public int hashCode() {
	//		return Objects.hash(countryPatient, emailPatient, idPatient, meds, namePatient);
	//	}
	//	@Override
	//	public boolean equals(Object obj) {
	//		if (this == obj)
	//			return true;
	//		if (obj == null)
	//			return false;
	//		if (getClass() != obj.getClass())
	//			return false;
	//		Patient other = (Patient) obj;
	//		return Objects.equals(countryPatient, other.countryPatient) && Objects.equals(emailPatient, other.emailPatient)
	//				&& idPatient == other.idPatient && Objects.equals(meds, other.meds)
	//				&& Objects.equals(namePatient, other.namePatient);
	//	}

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
