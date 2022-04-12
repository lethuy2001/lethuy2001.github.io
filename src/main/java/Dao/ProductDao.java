package Dao;

import java.util.List;

import Entities.Product;

public interface ProductDao {
	Product findById( Integer id) ;
	Product create( Product entity ) ;
	Product update( Product entity ) ;
	Product delete( int id ) ;
	List<Product> findAll() ;
	List<Product> findMany( int id) ;
}
