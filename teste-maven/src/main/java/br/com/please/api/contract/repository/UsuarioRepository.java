package br.com.please.api.contract.repository;

import java.util.List;

public interface UsuarioRepository<Usuario> extends BaseRepository<Usuario>{

	/**
	 * M�todo para listar uus�rios
	 * */
	List<Usuario> list();
	
	/**
	 * M�todo para listar todos os usu�rios
	 * */
	List<Usuario> listAll();
	
	/**
	 * M�todo para excluir usu�rio
	 * */
	Usuario delete(int id);
	
	/**
	 * M�todo para recuperar usu�rio pelo id
	 * */
	Usuario getById(int id);
	
	/**
	 * M�todo para recuperar usu�rio pelo email
	 * */
	List<Usuario> getByEmail(String email);
}
