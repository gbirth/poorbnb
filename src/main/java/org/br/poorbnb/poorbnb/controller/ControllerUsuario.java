package org.br.poorbnb.poorbnb.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Usuario;
import org.br.poorbnb.poorbnb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
public class ControllerUsuario {
	
	private UsuarioService usuarioService;

	@Autowired
	ControllerUsuario(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	
	@GetMapping("/todos-usuarios")
	public ResponseEntity<List<Usuario>> obterTodosUsuarios() {
		return ResponseEntity.ok(this.usuarioService.obterTodosUsuarios());
	}

	@GetMapping("/busca-usuario/{id}")
	public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable(value = "id") Long usuarioId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(this.usuarioService.obterUsuarioPorId(usuarioId));
	}

	@PostMapping("/cria-usuario")
	public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.ok(this.usuarioService.criarUsuario(usuario));
	}

	@PutMapping("/atualiza-usuario/{id}")
	public ResponseEntity<Usuario> atualizaUsuario(@PathVariable(value = "id") Long UsuarioId,
			@Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(this.usuarioService.atualizaUsuario(UsuarioId, usuarioDetails));
	}

	@DeleteMapping("/deleta-usuario/{id}")
	public ResponseEntity<Map<String, Boolean>> deletaUsuario(@PathVariable(value = "id") Long usuarioId)
			throws Exception {
		return ResponseEntity.ok(this.usuarioService.deletaUsuario(usuarioId));
	}
}