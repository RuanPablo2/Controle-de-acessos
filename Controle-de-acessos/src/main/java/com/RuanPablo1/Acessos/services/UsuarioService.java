package com.RuanPablo1.Acessos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.RuanPablo1.Acessos.dtos.UsuarioDTO;
import com.RuanPablo1.Acessos.dtos.UsuarioRoleDTO;
import com.RuanPablo1.Acessos.models.Role;
import com.RuanPablo1.Acessos.models.Usuario;
import com.RuanPablo1.Acessos.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public List<UsuarioDTO> listaUsuarios() {
		List<Usuario> list = usuarioRepository.findAll();
		return UsuarioDTO.convert(list);
	}

	public Usuario salvaUsuario(Usuario usuario) {
		String senhaCriptografa = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(senhaCriptografa);
		return usuarioRepository.save(usuario);
	}

	public UsuarioDTO buscaUsuario(Long id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return usuarioDTO;
	}

	public void deletaUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario atribuiRole(UsuarioRoleDTO usuarioRoleDTO) {
		Optional<Usuario> usuarioExists = usuarioRepository.findById(usuarioRoleDTO.getIdUsuario());
		List<Role> roles = new ArrayList<>();

		if (usuarioExists.isEmpty()) {
			throw new Error("Usuário não existe!");
		}

		roles = usuarioRoleDTO.getIdsRoles().stream().map(role -> {
			return new Role(role);
		}).collect(Collectors.toList());

		Usuario usuario = usuarioExists.get();

		usuario.setRoles(roles);
		;

		usuarioRepository.save(usuario);

		return usuario;
	}
}