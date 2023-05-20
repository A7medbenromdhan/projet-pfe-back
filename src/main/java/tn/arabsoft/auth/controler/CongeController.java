package tn.arabsoft.auth.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.arabsoft.auth.entity.Conge;
import tn.arabsoft.auth.entity.TypeConge;
import tn.arabsoft.auth.payload.request.DemandeRequest;
import tn.arabsoft.auth.repository.CongeRepository;
import tn.arabsoft.auth.repository.TypeCongeRepository;
import tn.arabsoft.auth.response.MessageResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/conge")
public class CongeController {
    @Autowired
    CongeRepository congeRepository;

    @Autowired
    private TypeCongeRepository typecongeRepository;

    @PostMapping("/DemandeConge")
    public ResponseEntity<?> Demande(@Valid @RequestBody DemandeRequest DemandeRequest) {
        Conge conge = new Conge(DemandeRequest.getMatriculec(), DemandeRequest.getDateDebut(), DemandeRequest.getDateFin(), DemandeRequest.getDuree(),
                DemandeRequest.getStatut(), DemandeRequest.getCause(), DemandeRequest.getDatedemande());

        Long InttypeConge = DemandeRequest.getTypeConge();
        TypeConge typeConge = typecongeRepository.findById(InttypeConge)
                .orElseThrow(() -> new RuntimeException("Error: not found."));

        conge.setTypeConge(typeConge);
        congeRepository.save(conge);
        return ResponseEntity.ok(new MessageResponse("okkii"));

    }

    @GetMapping("/getCongesByMatricule/{matricule}")
    public List<Conge> getCongesByMatricule(@PathVariable String matricule) {
        return congeRepository.getConge(matricule);
    }

    @DeleteMapping("/conges/{id}")
    public ResponseEntity<String> deleteCongeById(@PathVariable Long id) {
        try {
            congeRepository.deleteById(id);
            return ResponseEntity.ok("Congé deleted successfully.");
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the congé.");
        }
    }


    @PutMapping("/editConge/{matricule}")
    public ResponseEntity<?> editConge(@PathVariable String matricule, @Valid @RequestBody Conge updatedConge) {
        List<Conge> existingConges = congeRepository.getConge(matricule);
        if (!existingConges.isEmpty()) {
            Conge existingConge = existingConges.get(0);

            // Update the properties of the existing Conge object
            existingConge.setDateDebut(updatedConge.getDateDebut());
            existingConge.setDateFin(updatedConge.getDateFin());
            existingConge.setDuree(updatedConge.getDuree());
            existingConge.setStatut(updatedConge.getStatut());
            existingConge.setCause(updatedConge.getCause());

            // Save the updated Conge object
            congeRepository.save(existingConge);

            return ResponseEntity.ok(new MessageResponse("Conge updated successfully."));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("Conge not found with the provided matricule."));
        }
    }
    
}
