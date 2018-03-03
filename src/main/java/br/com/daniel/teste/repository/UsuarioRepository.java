package br.com.daniel.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daniel.teste.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByLogin(String login);
}
