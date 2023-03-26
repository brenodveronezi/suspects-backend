package br.com.dig.suspeitos.repository;

import br.com.dig.suspeitos.entity.Occurrences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrencesRepository extends JpaRepository<Occurrences, Long> {
}
