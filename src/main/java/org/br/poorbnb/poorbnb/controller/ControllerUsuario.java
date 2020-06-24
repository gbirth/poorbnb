package org.br.poorbnb.poorbnb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Usuario;
import org.br.poorbnb.poorbnb.repository.UsuarioRepository;
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
public class ControllerUsuario implements UsuarioService {

	@Autowired
	private UsuarioRepository UsuarioRepository;

	@GetMapping("/usuarios")
	public List<Usuario> obterTodosUsuarios() {
		return UsuarioRepository.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable(value = "id") Long usuarioId)
			throws ResourceNotFoundException {
		Usuario usuario = UsuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado:: " + usuarioId));
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping("/usuarios")
	public Usuario criarUsuario(@Valid @RequestBody Usuario usuario) {
		return UsuarioRepository.save(usuario);
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> atualizaUsuario(@PathVariable(value = "id") Long UsuarioId,
			@Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
		Usuario usuario = UsuarioRepository.findById(UsuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not found on :: " + UsuarioId));
		// revisar
		usuario.setNome(usuarioDetails.getNome());
		usuario.setEmail(usuarioDetails.getEmail());
		usuario.setTipoUsuario(usuarioDetails.getEndereco());
		usuario.setCpfCnpj(usuarioDetails.getCpfCnpj());
		usuario.setDtNasc(usuarioDetails.getDtNasc());
		usuario.setTelefone(usuarioDetails.getTelefone());

		final Usuario updatedUsuario = UsuarioRepository.save(usuario);
		return ResponseEntity.ok(updatedUsuario);
	}

	@DeleteMapping("/Usuario/{id}")
	public Map<String, Boolean> deletaUsuario(@PathVariable(value = "id") Long usuarioId) throws Exception {
		Usuario usuario = UsuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado em :: " + usuarioId));

		UsuarioRepository.delete(usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}
}