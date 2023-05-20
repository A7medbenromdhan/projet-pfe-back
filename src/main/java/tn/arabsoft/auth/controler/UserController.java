package tn.arabsoft.auth.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.auth.entity.Conge;
import tn.arabsoft.auth.entity.Personnel;
import tn.arabsoft.auth.entity.Autorisation;
import tn.arabsoft.auth.entity.TypeConge;
import tn.arabsoft.auth.payload.request.AutorisationRequest;
import tn.arabsoft.auth.payload.request.DemandeRequest;
import tn.arabsoft.auth.repository.CongeRepository;
import tn.arabsoft.auth.repository.TypeCongeRepository;
import tn.arabsoft.auth.repository.UserRepository;
import tn.arabsoft.auth.response.MessageResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private CongeRepository congeRepository;

	@GetMapping("/get/{mat}")
	public Optional<Personnel> get(@PathVariable String mat) {
		return this.userRepository.findByMatriculeP(mat);
	}
	@GetMapping("/getCongesByMatricule/{matricule}")
	public ResponseEntity<List<Conge>> getCongesByMatricule(@PathVariable String matricule) {
	    Optional<Personnel> personnelOptional = userRepository.findByMatriculeP(matricule);
	    
	    if (personnelOptional.isPresent()) {
	        Personnel personnel = personnelOptional.get();
	        List<Conge> conges = congeRepository.findByPersonnel(personnel);
	        return ResponseEntity.ok(conges);
	    } else {
	        throw new RuntimeException("Error: User not found.");
	    }
	}




	@DeleteMapping("/{matriculeP}")
	public ResponseEntity<String> delete(@PathVariable String matriculeP) {
		userRepository.deleteByMatriculeP(matriculeP);
		return ResponseEntity.ok("Deleted");
	}
}
