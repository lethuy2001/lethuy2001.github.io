package Dao;

import java.util.List;

import Entities.User;

public interface UserDao {
	User findById( Integer id ) ;
	User create ( User entity  );
	User update ( User entity  );
	User delete ( int id  );
	User findByEmail( String email ) ;
	List<User> findAll() ; 
}
