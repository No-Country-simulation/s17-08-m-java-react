package com.nocountry.server.controller;

import com.nocountry.server.model.dto.ProfessionalRequest;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.service.impl.ProfessionalServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Professionals")
@RestController
@RequestMapping("/professionals")
@RequiredArgsConstructor
public class ProfessionalController {

    private final ProfessionalServiceImpl professionalServiceImpl;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfessional(@RequestBody @Valid ProfessionalRequest request,
                                                @PathVariable Long id){
        return ResponseEntity.ok(professionalServiceImpl.updateProfessional(request, id));
    }

    @SecurityRequirements
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessional(@PathVariable Long id){
        Professional professional = professionalServiceImpl.findById(id);
        if(professional != null) {
            return new ResponseEntity<>(professionalServiceImpl.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("The professional with that id doesn't exists!", HttpStatus.NOT_FOUND);

    }

    @SecurityRequirements
    @GetMapping
    public ResponseEntity<?> getAllProfessionals(){
        List<Professional> professionals = professionalServiceImpl.getAllProfessional();
        if(!professionals.isEmpty()){
            return new ResponseEntity<>(professionalServiceImpl.getAllProfessional(), HttpStatus.OK);
        }else
            return new ResponseEntity<>("There isn't any professional to show", HttpStatus.NO_CONTENT);

    }

    @SecurityRequirements
    @GetMapping("/professionals/category/availability/{categoryId}/{availability}")
    public ResponseEntity<?> getProfessionalByCategoryAndAvailability(@PathVariable Long categoryId, @PathVariable String availability){
        List<Professional> professionalsByCategory = professionalServiceImpl.getProfessionalByCategory(categoryId);
        if(availability.isBlank()){
            return ResponseEntity.ok(professionalsByCategory);
        }
        List<Professional> professionalsByCategoryAvailability = professionalsByCategory.stream().filter(
                professional -> professional.getAvailability().equalsIgnoreCase(availability)).collect(Collectors.toList());
        
        return ResponseEntity.ok(professionalsByCategoryAvailability);
    }

    @SecurityRequirements
    @GetMapping("/professionals/category/rating/{categoryId}/{rating}")
    public ResponseEntity<?> getProfessionalByCategoryAndRating(@PathVariable Long categoryId, @PathVariable int rating){
        List<Professional> professionalsByCategory = professionalServiceImpl.getProfessionalByCategory(categoryId);
        if(rating > 5 || rating < 1){
            return ResponseEntity.ok(professionalsByCategory);
        }
        List<Professional> professionalsByCategoryRating = professionalsByCategory.stream().filter(
                professional -> professional.calculateAverageRating() >= rating).collect(Collectors.toList());

        return ResponseEntity.ok(professionalsByCategoryRating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessional(@PathVariable Long id) {
        if(professionalServiceImpl.deleteProfessional(id)){
            return new ResponseEntity<>("Professional deleted", HttpStatus.OK);

        }else
            return new ResponseEntity<>("The professional with that id doesn't exists!", HttpStatus.NOT_FOUND);

    }
}
