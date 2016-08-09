package br.com.please.api.service;

import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import br.com.please.api.contract.repository.UsuarioRepository;
import br.com.please.api.contract.service.UsuarioService;
import br.com.please.api.domain.Cliente;
import br.com.please.api.domain.Usuario;
import br.com.please.api.enums.StatusMessage;
import br.com.please.api.enums.StatusResult;
import br.com.please.api.util.CryptoUtil;
import br.com.please.api.util.MessageResult;
import br.com.please.api.util.RequestResult;

public class UsuarioServiceImpl extends BaseServiceImpl<Usuario> implements UsuarioService<Usuario>{
			
	private UsuarioRepository<Usuario> repository;	
	
	public UsuarioServiceImpl() {
		super();
	}	
	
	@Inject
	public UsuarioServiceImpl(UsuarioRepository<Usuario> usuarioRepository){
		super();
		repository = usuarioRepository;
	}			
	
	public List<Usuario> listAll() {
		
		return repository.listAll();		
	}
	
	public Usuario getById(int id){
		
		return repository.getById(id);
	}

	public RequestResult delete(int id) {

		RequestResult result = new RequestResult();		
		
		return result;
	}	
		
	public List<Usuario> getByEmail(String email){		
		return repository.getByEmail(email);
	}		

	public List<Usuario> list() {
		
		return null;
	}
	
	public RequestResult doLogin(Usuario usuario) {

		RequestResult request = new RequestResult();			
		List<Usuario> users = this.getByEmail(usuario.getEmail());
		
		if(!users.isEmpty()){
			Usuario user = users.get(0);			
			if(user.getSenha().equals(CryptoUtil.crypto(usuario.getSenha()))){			
				request.setStatusResult(StatusResult.SUCCESS);
				request.getMessages().add(new MessageResult(StatusMessage.SUCCESS, ResourceBundle.getBundle("messages").getString("sucesso.loginefetuadosucesso")));
			}					
		}else{
			request.getMessages().add(new MessageResult(StatusMessage.ERROR, ResourceBundle.getBundle("messages").getString("erro.loginsemsucesso")));
		}	
		
		return request;
	}

}
