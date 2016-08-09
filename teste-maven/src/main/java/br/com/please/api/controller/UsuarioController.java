package br.com.please.api.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.please.api.contract.service.UsuarioService;
import br.com.please.api.domain.Usuario;
import br.com.please.api.util.NotRestrict;
import br.com.please.api.util.RequestResult;

@Controller
@Path("/usuario")
public class UsuarioController {
	
	@Inject
	private Result result;
	
	@Inject
	private UsuarioService<Usuario> service;

	@NotRestrict
	@Get
	@Path("/teste")
	public void test(){		
		result.use(Results.json()).from("Luissssss!!!").serialize();
	}
	
	@NotRestrict
	@Post
	@Consumes("application/json")
	@Path("/login")
	public void login(Usuario usuario){
		RequestResult requestResult = service.doLogin(usuario);
		result.use(Results.json()).withoutRoot().from(requestResult).recursive().serialize();
	}
}
