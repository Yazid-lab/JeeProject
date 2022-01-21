package service;

import java.util.List;

import javax.ejb.Stateless;

import entities.Meds;


@Stateless
public class ILocalMedsImpl implements ILocalMeds {

	@Override
	public void addMeds(Meds med) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Meds> listMeds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meds selectMeds(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMeds(Meds med) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMeds(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
