package com.RuanPablo1.Acessos.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.RuanPablo1.Acessos.models.Usuario;

public class UsuarioInserirDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;
	
	private String password;

	private String nome;

	private String email;

	public UsuarioInserirDTO(Usuario usuario) {
		this.username = usuario.getUsername();
		this.password = usuario.getPassword();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioInserirDTO other = (UsuarioInserirDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}	
}
