package br.com.cadastroUnico.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastroUnico.dto.UsuarioDto;
import br.com.cadastroUnico.model.Usuario;
import br.com.cadastroUnico.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuario() {
		List<Usuario> listaUsuario = null;
		try {
			listaUsuario = usuarioRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaUsuario;
	}

	public void inserirUsuario(UsuarioDto usuarioDto){
		try {
			Usuario usuario = new Usuario();
			usuario.setNome(usuarioDto.getNome());
			usuario.setSexo(usuarioDto.getSexo());
			usuario.setEmail(usuarioDto.getEmail());
			usuario.setIdade(usuarioDto.getIdade());
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarUsuario(UsuarioDto usuarioDto){
		try {
			Usuario usuario = new Usuario();
			usuario.setId(usuarioDto.getId());
			usuario.setNome(usuarioDto.getNome());
			usuario.setSexo(usuarioDto.getSexo());
			usuario.setEmail(usuarioDto.getEmail());
			usuario.setIdade(usuarioDto.getIdade());
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluirUsuario(Long id){
		try {
			usuarioRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
