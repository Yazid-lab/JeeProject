package service;

import java.util.List;

import javax.ejb.Local;

import entities.Meds;

@Local
public interface ILocalMeds {
	public void addMeds(Meds med);
	public List<Meds> listMeds();
	public Meds selectMeds(int id);
	public boolean updateMeds(Meds med);
	public boolean deleteMeds(int id);

}
