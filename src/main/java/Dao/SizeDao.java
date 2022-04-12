

package Dao;

import java.util.List;

import Entities.Size;

public interface SizeDao {
	 List<Size> findAll() ;
	 Size findById( Integer id );
}
