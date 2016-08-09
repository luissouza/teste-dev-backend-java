package br.com.please.api.contract.repository;

import java.util.List;

public interface UsuarioRepository<Usuario> extends BaseRepository<Usuario>{

	/**
	 * Método para listar uusários
	 * */
	List<Usuario> list();
	
	/**
	 * Método para listar todos os usuários
	 * */
	List<Usuario> listAll();
	
	/**
	 * Método para excluir usuário
	 * */
	Usuario delete(int id);
	
	/**
	 * Método para recuperar usuário pelo id
	 * */
	Usuario getById(int id);
	
	/**
	 * Método para recuperar usuário pelo email
	 * */
	List<Usuario> getByEmail(String email);
}
