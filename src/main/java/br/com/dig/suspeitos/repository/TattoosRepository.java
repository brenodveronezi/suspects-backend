package br.com.dig.suspeitos.repository;

import br.com.dig.suspeitos.entity.Tattoos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TattoosRepository extends JpaRepository<Tattoos, Long> {
}
