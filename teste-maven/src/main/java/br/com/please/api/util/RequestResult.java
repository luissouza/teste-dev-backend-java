package br.com.please.api.util;

import java.util.ArrayList;
import java.util.List;

import br.com.please.api.enums.StatusResult;

public class RequestResult {

	private List<MessageResult> messages;

	private Object obj;

	private List<Object> listObj;
	
	private StatusResult statusResult;
		
	public RequestResult() {
		this.messages = new ArrayList<MessageResult>();
	}		

	public List<MessageResult> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageResult> messages) {
		this.messages = messages;
	}

	public Object getObj() {
		return obj;
	}
	
	public void setObj(Object obj) {
		this.obj = obj;
	}

	public List<Object> getListObj() {
		return listObj;
	}

	public void setListObj(List<Object> listObj) {
		this.listObj = listObj;
	}

	public StatusResult getStatusResult() {
		return statusResult;
	}

	public void setStatusResult(StatusResult statusResult) {
		this.statusResult = statusResult;
	}

}
