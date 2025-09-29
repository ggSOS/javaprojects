package br.com.fiap3espb.autoescola3espb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap3espb.autoescola3espb.model.Instrutor;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    
}
