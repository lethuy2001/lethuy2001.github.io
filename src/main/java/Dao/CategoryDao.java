package Dao;

import java.util.List;

import Entities.Category;

public interface CategoryDao {
	List<Category> findAll() ;
	Category findById( Integer id) ;
	Category create( Category entity );
	Category update( Category entity );
	Category delete( int id )
;}
