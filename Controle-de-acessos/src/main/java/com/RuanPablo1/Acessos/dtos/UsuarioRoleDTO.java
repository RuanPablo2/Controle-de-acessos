package com.RuanPablo1.Acessos.dtos;

import java.util.List;
import java.util.Objects;

public class UsuarioRoleDTO {

	private Long idUsuario;

	private List<Long> idsRoles;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Long> getIdsRoles() {
		return idsRoles;
	}

	public void setIdsRoles(List<Long> idsRoles) {
		this.idsRoles = idsRoles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, idsRoles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioRoleDTO other = (UsuarioRoleDTO) obj;
		return Objects.equals(idUsuario, other.idUsuario) && Objects.equals(idsRoles, other.idsRoles);
	}
}
