package Dao;

import java.util.List;

import Entities.Product;

public class ProductDaolmpl extends AbstractDao<Product> implements ProductDao{

	@Override
	public Product findById(Integer id) {
		return super.findById( Product.class, id );
	}

	@Override
	public List<Product> findAll() {
		return super.findAl( Product.class , true);
	}
	
	@Override
	public Product create( Product entity ) {
		return super.create(entity) ;
	}
	
	@Override
	public Product update( Product entity ) {
		return super.update(entity) ;
	}
	
	@Override
	public Product delete( int id ) {
		Product product = super.findById( Product.class , id) ;
		product.setStatus(1);
		return super.update(product) ;
	}

	@Override
	public List<Product> findMany( int id ) {
		String sql = "Select p from Product p where p.category.id = ?0 and p.status = 0" ;
		return super.findMany( Product.class , sql , id);
	}
	

}
