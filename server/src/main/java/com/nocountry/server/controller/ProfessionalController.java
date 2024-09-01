package com.nocountry.server.controller;

import com.nocountry.server.model.dto.ProfessionalDto;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.service.impl.ProfessionalService;
import com.nocountry.server.service.impl.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arregloYa/v1/")
@RequiredArgsConstructor

public class ProfessionalController {
    private final ProfessionalService professionalService;

    private final UserService userService;

    @PostMapping("professional")
    public ResponseEntity<?> createProfessional(@RequestBody @Valid ProfessionalDto dto){
        professionalService.createProfessional(dto);

        return new ResponseEntity<String>("professional account created", HttpStatus.CREATED);
    }

    @PutMapping("professional/{id}")
    public ResponseEntity<?> updateProfessional(@RequestBody @Valid ProfessionalDto dto, @RequestParam Long id){
        Professional professionalUpdated = professionalService.updateProfessional(dto, id);

        if(professionalUpdated != null){
            return new ResponseEntity<Professional>(professionalUpdated, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("The professional with that id doesn't exits! ",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("professional/{id}")
    public ResponseEntity<?> getProfessional(@RequestParam Long id){
        if(professionalService.findById(id) != null) {
            return new ResponseEntity<Professional>(professionalService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<String>("The professional with that id doesn't exists!", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("professionals")
    public ResponseEntity<?> getAllProfessionals(){
        return new ResponseEntity<List<Professional>>(professionalService.getAllProfessional(), HttpStatus.OK);
    }

    @DeleteMapping("professional/{id}")
    public ResponseEntity<String> deleteProfessional(@RequestParam Long id) {
        if(professionalService.deleteProfessional(id)){
            return new ResponseEntity<String>("Professional deleted", HttpStatus.OK);

        }else
            return new ResponseEntity<String>("The professional with that id doesn't exists!", HttpStatus.BAD_REQUEST);

    }
}
