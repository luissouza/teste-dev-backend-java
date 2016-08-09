package br.com.please.api.contract.service;

import java.util.List;

import br.com.please.api.util.RequestResult;

public interface UsuarioService<Usuario> extends BaseService<Usuario>{

	List<Usuario> list();
	
	List<Usuario> listAll();
	
	Usuario getById(int id);
	
	RequestResult delete(int id);
	
	List<Usuario> getByEmail(String email);
	
	RequestResult doLogin(Usuario usuario);	
}
