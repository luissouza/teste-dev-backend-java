package br.com.please.api.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.please.api.contract.repository.BaseRepository;
import br.com.please.api.util.RequestResult;

public class BaseRepositoryImpl<T> implements BaseRepository<T> {
	
	private EntityManager entity;	
	
	public BaseRepositoryImpl() {		
	}

	@Inject
	public BaseRepositoryImpl(EntityManager entity) {		
		this.entity = entity;
	}

	public RequestResult insert(T obj) {
		
		RequestResult result = new RequestResult();
		
		try {
			entity.getTransaction().begin();
			entity.persist(obj);
			entity.getTransaction().commit();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			entity.getTransaction().rollback();
		}
		
		return result;		
	}
	
	public RequestResult update(T obj) {
		
		RequestResult result = new RequestResult();
		
		try {
			entity.getTransaction().begin();
			entity.merge(obj);
			entity.getTransaction().commit();
			
			return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            entity.getTransaction().rollback();
        }
		
		return result;		
	}
	
}
