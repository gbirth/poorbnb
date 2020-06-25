package org.br.poorbnb.poorbnb.service;

import java.util.List;
import java.util.Map;

import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

	List<Usuario> obterTodosUsuarios();

	Usuario obterUsuarioPorId(Long usuarioId) throws ResourceNotFoundException;

	Usuario criarUsuario(Usuario Usuario);

	Usuario atualizaUsuario(Long UsuarioId, Usuario usuarioDetails) throws ResourceNotFoundException;

	Map<String, Boolean> deletaUsuario(Long UsuarioId) throws Exception;
}
