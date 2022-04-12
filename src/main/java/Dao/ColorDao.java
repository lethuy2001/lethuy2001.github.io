package Dao;

import java.util.List;

import Entities.Color;

public interface ColorDao {
	List<Color> findAll() ;
	Color findById( Integer id );
}
