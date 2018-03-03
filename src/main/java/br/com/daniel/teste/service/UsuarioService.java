package br.com.daniel.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.daniel.teste.model.Usuario;
import br.com.daniel.teste.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public void save(Usuario usuario) {
		usuario.setSenha(this.getPasswordEncoder().encode(usuario.getSenha()));
		this.repository.save(usuario);
	}
}
