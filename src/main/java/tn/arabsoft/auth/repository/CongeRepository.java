package tn.arabsoft.auth.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.arabsoft.auth.entity.Conge;
import tn.arabsoft.auth.entity.Personnel;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {

      List<Conge> findByPersonnel(Personnel personnel);
      List<Conge> findByPersonnel_MatriculeP(String matricule);
      
     
         @Query(value="select * from conge where matriculec=:mat",nativeQuery=true)
         List<Conge> getConge(@Param("mat")String mat);
         
         @Modifying
         @Query(value = "DELETE FROM conge WHERE matriculec = :matriculec AND id = :congeId", nativeQuery = true)
         void deleteByMatriculecAndId(@Param("matriculec") String matriculec, @Param("congeId") Long congeId);

        
}
      

