package br.com.please.api.contract.repository;

import br.com.please.api.util.RequestResult;


public interface BaseRepository<T> {

	/**
	 * M�todo para inserir usu�rio
	 * */
	RequestResult insert(T obj);	
	
	/**
	 * M�todo para atualizar usu�rio
	 * */
	RequestResult update(T obj);		
	
}
