package br.com.dig.suspeitos.repository;

import br.com.dig.suspeitos.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    //String FILTER_PERSON_ON_FIRST_NAME_AND_LAST_NAME_QUERY = "select p from Person p where UPPER(p.firstname) like CONCAT('%',UPPER(?1),'%') and UPPER(p.lastname) like CONCAT('%',UPPER(?2),'%')";

    String FILTER_PERSON_ON_FIRST_NAME_AND_LAST_NAME_QUERY = "select p from Person p where UPPER(p.firstname) like CONCAT('%',UPPER(?1),'%') and UPPER(p.lastname) like CONCAT('%',UPPER(?2),'%') and p.age BETWEEN ?3 AND ?4";


    @Query(value = FILTER_PERSON_ON_FIRST_NAME_AND_LAST_NAME_QUERY)
    List<Person> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Integer idadeDe, Integer idadeAte);


}
