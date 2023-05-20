package tn.arabsoft.auth.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.arabsoft.auth.entity.Autorisation;
import tn.arabsoft.auth.payload.request.AutorisationRequest;
import tn.arabsoft.auth.repository.AutorisationRepository;
import tn.arabsoft.auth.response.MessageResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/autorisation")
public class AutorisationController {

    @Autowired
    private AutorisationRepository autorisationRepository;

    @PostMapping("/createAutorisation")
    public ResponseEntity<?> createAutorisation(@Valid @RequestBody AutorisationRequest autorisationRequest) {
        Autorisation autorisation = new Autorisation(
                autorisationRequest.getMatriculea(),
                autorisationRequest.getHeureSortie(),
                autorisationRequest.getHeureRetour(),
                autorisationRequest.getMotif(),
                autorisationRequest.getDuree()
        );

        // Save the autorisation
        autorisationRepository.save(autorisation);

        return ResponseEntity.ok(new MessageResponse("Autorisation created successfully."));
    }


    @GetMapping("/getAutorisationsByMatricule/{matriculea}")
    public List<Autorisation> getAutorisationsByMatricule(@PathVariable String matriculea) {
        return autorisationRepository.getAutorisationsByMatriculea(matriculea);
    }

    @PutMapping("/updateAutorisationsByMatricule/{matriculea}")
    public ResponseEntity<?> updateAutorisationsByMatricule(@PathVariable String matriculea, @Valid @RequestBody AutorisationRequest autorisationRequest) {
        List<Autorisation> existingAutorisations = autorisationRepository.getAutorisationsByMatriculea(matriculea);
        if (!existingAutorisations.isEmpty()) {
            for (Autorisation existingAutorisation : existingAutorisations) {
                // Update the properties of each existing Autorisation object
                existingAutorisation.setMatriculea(autorisationRequest.getMatriculea());
                existingAutorisation.setHeureSortie(autorisationRequest.getHeureSortie());
                existingAutorisation.setHeureRetour(autorisationRequest.getHeureRetour());
                existingAutorisation.setMotif(autorisationRequest.getMotif());
                existingAutorisation.setDuree(autorisationRequest.getDuree());

                // Save the updated Autorisation object
                autorisationRepository.save(existingAutorisation);
            }

            return ResponseEntity.ok(new MessageResponse("Autorisations updated successfully."));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("No Autorisations found with the provided matriculea."));
        }
    }

    @DeleteMapping("/deleteAutorisationsByMatricule/{matriculea}")
    public ResponseEntity<?> deleteAutorisationsByMatricule(@PathVariable String matriculea) {
        List<Autorisation> existingAutorisations = autorisationRepository.getAutorisationsByMatriculea(matriculea);
        if (!existingAutorisations.isEmpty()) {
            autorisationRepository.deleteAutorisationsByMatriculea(matriculea);
            return ResponseEntity.ok(new MessageResponse("Autorisations deleted successfully."));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("No Autorisations found with the provided matriculea."));
        }
    }

    // ... (remaining mappings)
    
    @GetMapping("/getAllAutorisations")
    public ResponseEntity<?> getAllAutorisations() {
        List<Autorisation> autorisations = autorisationRepository.findAll();
        return ResponseEntity.ok(autorisations);
    }
}