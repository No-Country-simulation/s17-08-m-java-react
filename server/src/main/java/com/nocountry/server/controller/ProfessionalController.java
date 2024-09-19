package com.nocountry.server.controller;

import com.nocountry.server.model.dto.ProfessionalDto;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.service.impl.ProfessionalService;
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

    private final ProfessionalService professionalService;

    @PostMapping
    public ResponseEntity<?> createProfessional(@RequestBody @Valid ProfessionalDto dto){
        professionalService.createProfessional(dto);

        return new ResponseEntity<>("professional account created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfessional(@RequestBody @Valid ProfessionalDto dto, @PathVariable Long id){
        Professional professionalUpdated = professionalService.updateProfessional(dto, id);

        if(professionalUpdated != null){
            return new ResponseEntity<>(professionalUpdated, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("The professional with that id doesn't exits! ",HttpStatus.BAD_REQUEST);
        }
    }

    @SecurityRequirements
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessional(@PathVariable Long id){
        Professional professional = professionalService.findById(id);
        if(professional != null) {
            return new ResponseEntity<>(professionalService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("The professional with that id doesn't exists!", HttpStatus.NOT_FOUND);

    }

    @SecurityRequirements
    @GetMapping
    public ResponseEntity<?> getAllProfessionals(){
        List<Professional> professionals = professionalService.getAllProfessional();
        if(!professionals.isEmpty()){
            return new ResponseEntity<>(professionalService.getAllProfessional(), HttpStatus.OK);
        }else
            return new ResponseEntity<>("There isn't any professional to show", HttpStatus.NO_CONTENT);

    }

    @SecurityRequirements
    @GetMapping("/professionals/category/availability/{categoryId}/{availability}")
    public ResponseEntity<?> getProfessionalByCategoryAndAvailability(@PathVariable Long categoryId, @PathVariable String availability){
        List<Professional> professionalsByCategory = professionalService.getProfessionalByCategory(categoryId);
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
        List<Professional> professionalsByCategory = professionalService.getProfessionalByCategory(categoryId);
        if(rating > 5 || rating < 1){
            return ResponseEntity.ok(professionalsByCategory);
        }
        List<Professional> professionalsByCategoryRating = professionalsByCategory.stream().filter(
                professional -> professional.calculateAverageRating() >= rating).collect(Collectors.toList());

        return ResponseEntity.ok(professionalsByCategoryRating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessional(@PathVariable Long id) {
        if(professionalService.deleteProfessional(id)){
            return new ResponseEntity<>("Professional deleted", HttpStatus.OK);

        }else
            return new ResponseEntity<>("The professional with that id doesn't exists!", HttpStatus.NOT_FOUND);

    }
}
