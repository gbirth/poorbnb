package org.br.poorbnb.poorbnb.controller;

import javax.validation.Valid;

import org.br.poorbnb.poorbnb.model.Usuario;
import org.br.poorbnb.poorbnb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/usuario")
public class ControllerUsuario {
	
	private UsuarioService usuarioService;

	@Autowired
	ControllerUsuario(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

//	@GetMapping("/todos-usuarios")
//	public ResponseEntity<List<Usuario>> obterTodosUsuarios() {
//		return ResponseEntity.ok(this.usuarioService.obterTodosUsuarios());
//	}
//
//	@GetMapping("/busca-usuario/{id}")
//	public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable(value = "id") Long usuarioId)
//			throws ResourceNotFoundException {
//		return ResponseEntity.ok(this.usuarioService.obterUsuarioPorId(usuarioId));
//	}

//	@PostMapping("/cria-usuario")
//	public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
//		return ResponseEntity.ok(this.usuarioService.criarUsuario(usuario));
//	}

	@RequestMapping(value = "/criar-usuario", method = RequestMethod.POST)
	public String criarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario , BindingResult result, ModelMap model) {
		//if (ResponseEntity.ok(this.usuarioService.criarUsuario(usuario));
		this.usuarioService.criarUsuario(usuario);
		return "Poorbnb_Cadastro";
	}
//	@PutMapping("/atualiza-usuario/{id}")
//	public ResponseEntity<Usuario> atualizaUsuario(@PathVariable(value = "id") Long UsuarioId,
//			@Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
//		return ResponseEntity.ok(this.usuarioService.atualizaUsuario(UsuarioId, usuarioDetails));
//	}
//
//	@DeleteMapping("/deleta-usuario/{id}")
//	public ResponseEntity<Map<String, Boolean>> deletaUsuario(@PathVariable(value = "id") Long usuarioId)
//			throws Exception {
//		return ResponseEntity.ok(this.usuarioService.deletaUsuario(usuarioId));
//	}
}