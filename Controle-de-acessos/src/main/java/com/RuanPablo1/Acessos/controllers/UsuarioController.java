package com.RuanPablo1.Acessos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.RuanPablo1.Acessos.dtos.UsuarioDTO;
import com.RuanPablo1.Acessos.dtos.UsuarioRoleDTO;
import com.RuanPablo1.Acessos.models.Usuario;
import com.RuanPablo1.Acessos.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> ListaUsuarios() {
		List<UsuarioDTO> list = usuarioService.listaUsuarios();
		return ResponseEntity.ok(list);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioDTO buscaUsuario(@PathVariable Long id) {
		return usuarioService.buscaUsuario(id);
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.salvaUsuario(usuario);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/role")
	public Usuario atribuiRole(@RequestBody UsuarioRoleDTO usuarioRoleDTO) {
		return usuarioService.atribuiRole(usuarioRoleDTO);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario editaUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
		return usuarioService.salvaUsuario(usuario);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletaUsuario(@PathVariable Long id) {
		usuarioService.deletaUsuario(id);
	}
}