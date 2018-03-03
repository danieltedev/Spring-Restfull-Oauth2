package br.com.daniel.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.daniel.teste.config.CustomUserDetails;
import br.com.daniel.teste.model.Perfil;
import br.com.daniel.teste.model.Usuario;
import br.com.daniel.teste.repository.UsuarioRepository;
import br.com.daniel.teste.service.UsuarioService;

@SpringBootApplication
public class TesteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteApiApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UsuarioRepository repository,
			UsuarioService service) throws Exception {
		if (repository.count() == 0)
			service.save(new Usuario(null, "usu", "usu",
					Arrays.asList(new Perfil(null, "user"), new Perfil(null, "actuator"))));
		builder.userDetailsService(this.userDetailsService(repository)).passwordEncoder(passwordEncoder);
	}
	
	private UserDetailsService userDetailsService(final UsuarioRepository repository) {
		return s -> new CustomUserDetails(repository.findByLogin(s));
	}
}
