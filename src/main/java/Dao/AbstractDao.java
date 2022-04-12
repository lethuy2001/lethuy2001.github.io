package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Untils.JpaUntil;

public class AbstractDao<T> {
	public static final EntityManager em = JpaUntil.getManager() ;
	
	@SuppressWarnings("deprecation")
	@Override
	public void finalize() throws Throwable {
		this.em.close(); 
		super.finalize();
	}
	
	public T findById( Class<T> clazz , Integer id ) {
		return this.em.find(clazz, id) ;
	}
	
	public List<T> findAl( Class<T> clazz , boolean existActive){
		String entityName = clazz.getSimpleName() ;
		StringBuilder sql = new StringBuilder() ;
		sql.append("SELECT o FROM ").append(entityName).append(" o") ;
		if( existActive == true ) {
			sql.append(" WHERE o.status = 0 ");
		}
		TypedQuery<T> query = this.em.createQuery(sql.toString() , clazz );
		return query.getResultList();
	}
	
	public List<T> findAl( Class<T> clazz , boolean existActive , int pageNumber , int pageSize){
		String entityName = clazz.getSimpleName() ;
		StringBuilder sql = new StringBuilder() ;
		sql.append("SELECT o FROM ").append(entityName).append(" o") ;
		if( existActive == true ) {
			sql.append(" WHERE o.status = 0 ");
		}
		TypedQuery<T> query = this.em.createQuery(sql.toString() , clazz );
		query.setFirstResult(( pageNumber -1 ) * pageSize);
		query.setMaxResults(pageSize ) ;
		return query.getResultList();
	}
	
	public T findOne( Class<T> clazz , String sql , Object ...prams) {
		TypedQuery<T> query = this.em.createQuery( sql , clazz );
		for( int i=0 ; i<prams.length ; i++ ) {
			query.setParameter(i, prams[i]) ;
		}
		List<T> result = query.getResultList();
		if( result.isEmpty() ) {
			return null ;
		}
		return result.get(0) ;
	}
	
	public List<T> findMany( Class<T> clazz , String sql , Object ...prams) {
		TypedQuery<T> query = this.em.createQuery( sql , clazz );
		for( int i=0 ; i<prams.length ; i++ ) {
			query.setParameter(i, prams[i]) ;
		}
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery( Class<T> clazz , String sql , Object ...prams) {
		TypedQuery<T> query = this.em.createQuery( sql , clazz );
		for( int i=0 ; i<prams.length ; i++ ) {
			query.setParameter(i, prams[i]) ;
		}
		return (List<Object[]>) query.getResultList();
	}
	
	public T create( T entity ) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(entity);
			this.em.getTransaction().commit();
			return entity ;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			throw e ;
		}
	}
	
	public T update( T entity ) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(entity);
			this.em.getTransaction().commit();
			return entity ;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			throw e ;
		}
	}
	
	public T delete( T entity ) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(entity);
			this.em.getTransaction().commit();
			return entity ;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			throw e ;
		}
	}
}
