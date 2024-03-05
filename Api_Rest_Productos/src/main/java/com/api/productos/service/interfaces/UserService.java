package com.api.productos.service.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.api.productos.dto.response.user.UsuarioResponse;

public interface UserService {
	UserDetailsService userDetailsService();

	List<UsuarioResponse> getAllUsers();
}
