package br.com.please.api.service;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.please.api.domain.Usuario;
import br.com.please.api.repository.UsuarioRepositoryImpl;
import br.com.please.api.util.RequestResult;

public class UsuarioServiceTest {

	private UsuarioServiceImpl usuarioService = new UsuarioServiceImpl(new UsuarioRepositoryImpl(getConnection()));
		
	@Test
	public void login(){
		
		RequestResult result = new RequestResult();
		
		Usuario usuario = new Usuario();
		usuario.setEmail("os.luisgustavo@gmail.com");
		usuario.setSenha("dhn0018");
		
		result = usuarioService.doLogin(usuario);
		
		assertNotNull(result.getListObj());		
	}
	
	@Test
	public void getByEmail(){
		
		
	}
	
	private EntityManager getConnection(){
		
		EntityManager entity = null;
		
		try{
			entity = Persistence.createEntityManagerFactory("please-api-persistence-unit").createEntityManager();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return entity;
	}
}
