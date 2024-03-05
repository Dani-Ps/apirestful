package com.api.productos.repositories.interfaces;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.productos.entities.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Serializable> {

	Optional<Usuario> findByEmail(String email);

	Boolean existsByEmail(String email);

}
