package br.com.please.api.contract.repository;

import br.com.please.api.util.RequestResult;


public interface BaseRepository<T> {

	/**
	 * Método para inserir usuário
	 * */
	RequestResult insert(T obj);	
	
	/**
	 * Método para atualizar usuário
	 * */
	RequestResult update(T obj);		
	
}
