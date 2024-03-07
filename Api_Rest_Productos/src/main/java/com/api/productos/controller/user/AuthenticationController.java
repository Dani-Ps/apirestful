package com.api.productos.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.productos.dto.request.SignUpRequest;
import com.api.productos.dto.request.SigninRequest;
import com.api.productos.dto.response.user.JwtAuthenticationResponse;
import com.api.productos.service.interfaces.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

	private final AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("/signup")
	@Operation(summary = "Registro de usuario", description = "Registro de un nuevo usuario")
	@ApiResponse(responseCode = "200", description = "Usuario registrado exitosamente")
	public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
		return ResponseEntity.ok(authenticationService.signup(request));
	}

	@PostMapping("/signin")
	@Operation(summary = "Inicio de sesión", description = "Inicio de sesión de usuario")
	@ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
		return ResponseEntity.ok(authenticationService.signin(request));
	}
}