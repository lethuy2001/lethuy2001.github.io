package Dao;

import java.util.List;

import Entities.Color;

public class ColorDaolmpl extends AbstractDao<Color> implements ColorDao {

	@Override
	public List<Color> findAll() {
		return super.findAl( Color.class , false);
	}

	@Override
	public Color findById(Integer id) {
		return super.findById( Color.class , id);
	}

}
