package tn.arabsoft.auth.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.arabsoft.auth.entity.Autorisation;

public interface AutorisationRepository extends JpaRepository<Autorisation, Long> {

	
	@Query(value = "SELECT * FROM autorisation WHERE matriculea = :matriculea", nativeQuery = true)
    List<Autorisation> getAutorisationsByMatriculea(@Param("matriculea") String matriculea);
	

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM autorisation WHERE matriculea = :matriculea", nativeQuery = true)
    void deleteAutorisationsByMatriculea(@Param("matriculea") String matriculea);
}

