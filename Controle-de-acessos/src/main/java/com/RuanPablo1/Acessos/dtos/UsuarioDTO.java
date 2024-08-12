package com.RuanPablo1.Acessos.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.RuanPablo1.Acessos.models.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String nome;

	private String email;

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.username = usuario.getUsername();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

	public static List<UsuarioDTO> convert(List<Usuario> usuario) {
		return usuario.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
