package tn.arabsoft.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.arabsoft.auth.entity.EtypeConge;
import tn.arabsoft.auth.entity.TypeConge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.arabsoft.auth.entity.TypeConge;

@Repository
public interface TypeCongeRepository extends JpaRepository<TypeConge, Long> {
	// Define custom query methods if needed
}
