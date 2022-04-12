package Dao;

import java.util.List;

import Entities.Category;

public class CategoryDaolmpl extends AbstractDao<Category> implements CategoryDao{

	@Override
	public List<Category> findAll() {
		return super.findAl( Category.class, true);
	}

	@Override
	public Category findById( Integer id ) {
		return super.findById( Category.class , id);
	}
	
	@Override
	public Category create( Category entity ) {
		return super.create(entity);
	}
	
	@Override
	public Category update(Category entity ) {
		return super.update(entity);
	}

	@Override
	public Category delete(int id) {
		Category category = this.findById(id) ;
		category.setStatus(id);
		return super.update(category);
	}
	 
}
