package com.api.productos.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.productos.entities.Usuario;
import com.api.productos.repositories.interfaces.UsuarioRepository;

@Service("UsuarioService")
public class UsuarioServicImpl implements UserDetailsService {

	@Autowired
	@Qualifier("I_UsuarioRepository")
	private UsuarioRepository iUsuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		Usuario usuario = iUsuarioRepository.findByUsuario(username);

		return new User(usuario.getUsuario(), encoder.encode(usuario.getContrasenia()), usuario.getEstado(),
				usuario.getEstado(), usuario.getEstado(), usuario.getEstado(), obtenerPermisos(usuario.getRol()));
	}

	public List<GrantedAuthority> obtenerPermisos(byte rol) {

		String roles[] = { "LECTURA", "USUARIO", "ADMINISTRADOR" };

		List<GrantedAuthority> auths = new ArrayList();

		for (int i = 0; i < rol; i++) {
			auths.add(new SimpleGrantedAuthority(roles[i]));
		}

		return auths;
	}

}
