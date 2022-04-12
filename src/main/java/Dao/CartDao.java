package Dao;

import java.util.List;

import Entities.Cart;

public interface CartDao {
	Cart create( Cart entity) ;
	Cart update( Cart entity) ;
	Cart delete( Cart entity) ;
	List<Cart> findAll( int id ) ;
}
