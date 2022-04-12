package Dao;

import java.util.List;

import Entities.Size;

public class SizeDaolmpl extends AbstractDao<Size> implements SizeDao {

	@Override
	public List<Size> findAll() {
		return super.findAl( Size.class , false);
	}

	@Override
	public Size findById(Integer id) {
		return super.findById( Size.class , id);
	}

}
