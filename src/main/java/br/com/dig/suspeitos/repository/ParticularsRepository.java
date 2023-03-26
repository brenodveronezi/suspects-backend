package br.com.dig.suspeitos.repository;

import br.com.dig.suspeitos.entity.Particulars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticularsRepository extends JpaRepository<Particulars, Long> {
}
