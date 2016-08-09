package br.com.please.api.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.please.api.contract.repository.UsuarioRepository;
import br.com.please.api.domain.Usuario;
import br.com.please.api.enums.StatusMessage;
import br.com.please.api.enums.StatusResult;
import br.com.please.api.util.MessageResult;
import br.com.please.api.util.RequestResult;

@RequestScoped
public class UsuarioRepositoryImpl extends BaseRepositoryImpl<Usuario> implements UsuarioRepository<Usuario> {

	private EntityManager entity;
	
	public UsuarioRepositoryImpl() {	
		super();
	}
		
	@Inject
	public UsuarioRepositoryImpl(EntityManager entity) throws RuntimeException {
		super(entity);		
		this.entity = entity;
	}	
	
	public RequestResult insert(Usuario usuario) throws RuntimeException{
		
		RequestResult result = new RequestResult();
		
		try{		
			this.entity.getTransaction().begin();
			this.entity.persist(usuario);		
			this.entity.getTransaction().commit();			
			result.setObj(usuario);
			result.setStatusResult(StatusResult.SUCCESS);
			
		}catch(Exception ex){
			this.entity.getTransaction().rollback();
			result.setStatusResult(StatusResult.ERROR);
			result.getMessages().add(new MessageResult(StatusMessage.ERROR, ex.getMessage()));
		}
		
		return result;
	}
	
	public RequestResult update(Usuario usuario) throws RuntimeException{
		
		RequestResult result = new RequestResult();
		
		try {
			this.entity.getTransaction().begin();
			this.entity.merge(usuario);
			this.entity.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}	
		
	public Usuario delete(int id) throws RuntimeException {
		
		Usuario usuario = new Usuario();
		
		try {		
			
			entity.getTransaction().begin();
			usuario = entity.find(Usuario.class, id);
            entity.remove(usuario);
            entity.getTransaction().commit();
            
            return usuario;
        } catch (Exception ex) {
            ex.printStackTrace();
            entity.getTransaction().rollback();
        }
		
		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listAll() throws RuntimeException{
		
		List<Usuario> list = new ArrayList<Usuario>();		
		list = this.entity.createQuery("SELECT u FROM Usuario u").getResultList();
		
		return list;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> list() throws RuntimeException {			
		
		StringBuilder jpql = new StringBuilder();		
		jpql.append("FROM Usuario u WHERE u.usuario_lixeira = 'N' ");		
		
		
		
		Query query = entity.createQuery(jpql.toString());
		
		
		
		return query.getResultList();
	}
	
	public Usuario getById(int id) throws RuntimeException{

		return entity.find(Usuario.class, id);	
		
	}	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getByEmail(String email){			
		
		Query query = this.entity.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");		
		query.setParameter("email", email);
		
		return query.getResultList();	
	}
}
