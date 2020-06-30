package org.br.poorbnb.poorbnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.br.poorbnb.poorbnb.model.Usuario;
import org.br.poorbnb.poorbnb.repository.UsuarioRepository;
import org.br.poorbnb.poorbnb.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository UsuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository repository) {
		this.UsuarioRepository = repository;
	}

	public List<Usuario> obterTodosUsuarios() {
		return UsuarioRepository.findAll();
	}

	public Usuario obterUsuarioPorId(Long usuarioId) throws ResourceNotFoundException {
		Usuario usuario = UsuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado:: " + usuarioId));
		return usuario;
	}

	@Transactional
	public Usuario criarUsuario(Usuario usuario) {
		return UsuarioRepository.save(usuario);
	}

	public Usuario atualizaUsuario(Long UsuarioId, Usuario usuarioDetails) throws ResourceNotFoundException {
		Usuario usuario = UsuarioRepository.findById(UsuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not found on :: " + UsuarioId));

		usuario.setNome(usuarioDetails.getNome());
		usuario.setEmail(usuarioDetails.getEmail());
		usuario.setTipoUsuario(usuarioDetails.getEndereco());
		usuario.setCpfCnpj(usuarioDetails.getCpfCnpj());
		usuario.setDtNasc(usuarioDetails.getDtNasc());
		usuario.setTelefone(usuarioDetails.getTelefone());

		final Usuario updatedUsuario = UsuarioRepository.save(usuario);
		return updatedUsuario;
	}

	public Map<String, Boolean> deletaUsuario(Long usuarioId) throws Exception {
		Usuario usuario = UsuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado em :: " + usuarioId));

		UsuarioRepository.delete(usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}

}
