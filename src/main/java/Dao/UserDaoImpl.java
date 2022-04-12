package Dao;

import java.util.List;

import Entities.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDao{

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById( User.class, id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return super.findAl( User.class, true );
	}
	
	
  
	@Override
	public User create( User entity ) {
		return super.create(entity) ;
	}
	
	@Override
	public User update( User entity ) {
		return super.update(entity) ;
	}
	
	@Override
	public User delete( int id ) {
		User user = this.findById(id) ;
		user.setStatus(1);
		return super.update(user) ;
	}

	@Override
	public User findByEmail(String email) {
		String sql = "select o from User o where o.email = ?0" ;
		return super.findOne( User.class, sql, email );
	}
}
