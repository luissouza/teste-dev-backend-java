package br.com.please.api.util;

import br.com.please.api.enums.StatusMessage;

public class MessageResult {

	private StatusMessage status;	 
	
	private String text;	
	
	public MessageResult(StatusMessage status, String text) {		
		this.status = status;
		this.text = text;
	}
	
	public StatusMessage getStatus() {
		return status;
	}
	public void setStatus(StatusMessage status) {
		this.status = status;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}	
	
}
