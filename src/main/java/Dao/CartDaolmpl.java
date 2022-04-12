package Dao;

import java.util.List;

import Entities.Cart;

public class CartDaolmpl extends AbstractDao<Cart> implements CartDao{

	@Override
	public List<Cart> findAll( int id ) {
		String spl = "SELECT c FROM Cart c where c.user.id = ?0" ;
		return super.findMany( Cart.class , spl, id);
	}
	
	@Override 
	public Cart create( Cart entity ) {
		return super.create(entity);
	}

}
