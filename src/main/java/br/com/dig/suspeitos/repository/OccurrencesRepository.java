package br.com.dig.suspeitos.repository;

import br.com.dig.suspeitos.entity.Occurrences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccurrencesRepository extends JpaRepository<Occurrences, Long> {

    @Query(value = """
            SELECT o.id, o.article, o.date, o.historic, o.law, o.procedure\s
            FROM occurrences AS o
            INNER JOIN person_occurrences AS po
            ON o.id = po.occurrences_id
            WHERE po.person_id = ?1""", nativeQuery = true)
    List<Occurrences> findByPersonId(Long id);

}
