package com.api.productos.repositories.interfaces;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.productos.entities.Usuario;

@Repository("I_UsuarioRepository")
public interface I_UsuarioRepository extends JpaRepository<Usuario, Serializable>{

	public abstract Usuario findById(int id);

	public abstract Usuario findByUsuario(String usuario);
	
	public abstract Usuario findByContrasenia(String contrasenia);

	public abstract Usuario findByRol(byte rol);
	
	public abstract Usuario findByEstado(boolean estado);



	
}
