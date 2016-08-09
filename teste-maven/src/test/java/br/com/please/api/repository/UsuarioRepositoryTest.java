package br.com.please.api.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.please.api.domain.Usuario;
import br.com.please.api.enums.StatusResult;
import br.com.please.api.util.CryptoUtil;
import br.com.please.api.util.RequestResult;

public class UsuarioRepositoryTest {
	
	private UsuarioRepositoryImpl usuarioRepositoryImpl = new UsuarioRepositoryImpl(getConnection());
	
	@Test
	public void insert(){		
		
		RequestResult result = new RequestResult();
		
		Usuario usuario = new Usuario();
		usuario.setSenha(CryptoUtil.crypto("dhn0018"));
		usuario.setEmail("os.luisgustavo@gmail.com");

		result = usuarioRepositoryImpl.insert(usuario);
		
		assertEquals(result.getStatusResult(), StatusResult.SUCCESS);		
	} 

	@Test
	public void getByEmail(){
		
		List<Usuario> usuarios = new ArrayList<Usuario>(); 
		usuarios = usuarioRepositoryImpl.getByEmail("os.luisgustavo@gmail.com");
		
		assertNotNull(usuarios);
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
