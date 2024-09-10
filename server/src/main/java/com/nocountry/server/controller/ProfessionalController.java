package com.nocountry.server.controller;

import com.nocountry.server.model.dto.ProfessionalDto;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.service.impl.ProfessionalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/professional")
@RequiredArgsConstructor
public class ProfessionalController {

    private final ProfessionalService professionalService;

    @PostMapping("/")
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessional(@PathVariable Long id){
        Professional professional = professionalService.findById(id);
        if(professional != null) {
            return new ResponseEntity<>(professionalService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("The professional with that id doesn't exists!", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProfessionals(){
        List<Professional> professionals = professionalService.getAllProfessional();
        if(!professionals.isEmpty()){
            return new ResponseEntity<>(professionalService.getAllProfessional(), HttpStatus.OK);
        }else
            return new ResponseEntity<>("There isn't any professional to show", HttpStatus.NO_CONTENT);

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getProfessionalByCategory(@PathVariable Long categoryId){
        return ResponseEntity.ok(professionalService.getProfessionalByCategory(categoryId));
    }

    @GetMapping("/{availability}")
    public ResponseEntity<List<Professional>> getProfessionalsByAvailability(@PathVariable String availability){
        return ResponseEntity.ok(professionalService.getProfessionalByAvailability(availability));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessional(@PathVariable Long id) {
        if(professionalService.deleteProfessional(id)){
            return new ResponseEntity<>("Professional deleted", HttpStatus.OK);

        }else
            return new ResponseEntity<>("The professional with that id doesn't exists!", HttpStatus.NOT_FOUND);

    }
}
