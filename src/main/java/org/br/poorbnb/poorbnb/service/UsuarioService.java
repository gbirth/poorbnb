package org.br.poorbnb.poorbnb.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UsuarioService {

	List<Usuario> obterTodosUsuarios();

	// verificar sé é assim a assinatura do método
	ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable(value = "id") Long usuarioId)
			throws ResourceNotFoundException;

	Usuario criarUsuario(@Valid @RequestBody Usuario Usuario);

	ResponseEntity<Usuario> atualizaUsuario(@PathVariable(value = "id") Long UsuarioId,
			@Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException;
	
	Map<String, Boolean> deletaUsuario(
		       @PathVariable(value = "id") Long UsuarioId) throws Exception;
}
