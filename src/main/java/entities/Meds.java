//package entities;
//
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//
//@Entity @Table(name = "Meds")
//public class Meds implements Serializable {
//	
//	
//	
//	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
//	private int idMed;
//	private String nameMed;
//	
//	
//	@ManyToOne
//	@JoinTable( name = "PATIENT_MEDS",
//    joinColumns = @JoinColumn( name = "idMed" ),
//    inverseJoinColumns = @JoinColumn( name = "idPatient" ) )
//	private List<Patient> patients = new ArrayList<>();
//	
//	public int getIdMed() {
//		return idMed;
//	}
//	public void setIdMed(int idMed) {
//		this.idMed = idMed;
//	}
//	public String getNameMed() {
//		return nameMed;
//	}
//	public void setNameMed(String nameMed) {
//		this.nameMed = nameMed;
//	}
//	public List<Patient> getPatients() {
//		return patients;
//	}
//	public void setPatients(List<Patient> patients) {
//		this.patients = patients;
//	}
//	@Override
//	public String toString() {
//		return "Meds [idMed=" + idMed + ", nameMed=" + nameMed + ", patients=" + patients + "]";
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(idMed, nameMed, patients);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Meds other = (Meds) obj;
//		return idMed == other.idMed && Objects.equals(nameMed, other.nameMed)
//				&& Objects.equals(patients, other.patients);
//	}
//
//}
