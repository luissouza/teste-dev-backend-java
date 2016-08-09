package br.com.please.api.contract.service;

import br.com.please.api.util.RequestResult;

public interface BaseService<T> {

	RequestResult save(T obj);		
}
