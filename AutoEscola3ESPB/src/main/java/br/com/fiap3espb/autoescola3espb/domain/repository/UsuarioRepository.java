package br.com.fiap3espb.autoescola3espb.domain.repository;

import br.com.fiap3espb.autoescola3espb.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
