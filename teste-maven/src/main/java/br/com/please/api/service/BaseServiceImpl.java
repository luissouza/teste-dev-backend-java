package br.com.please.api.service;

import br.com.please.api.contract.service.BaseService;
import br.com.please.api.util.RequestResult;


public class BaseServiceImpl<T> implements BaseService<T>{

	public RequestResult save(T obj) {
		return new RequestResult();
		
	}
}
