package br.com.cadastroUnico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastroUnico.dto.UsuarioDto;
import br.com.cadastroUnico.model.Usuario;
import br.com.cadastroUnico.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/listaUsuario")
	public ResponseEntity<?> listarUsuario() {
		List<Usuario> listaUsuario = null;
		try {
			listaUsuario = usuarioService.listarUsuario();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(listaUsuario);
	}

	@PostMapping("/inserirUsuario")
	public ResponseEntity<?> inserirUsuario(@RequestBody UsuarioDto usuarioDto) {
		try {
			usuarioService.inserirUsuario(usuarioDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(HttpStatus.OK);
		
	}
}
