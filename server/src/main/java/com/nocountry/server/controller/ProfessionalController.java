package com.nocountry.server.controller;

import com.nocountry.server.model.dto.ProfessionalResponse;
import com.nocountry.server.model.dto.ProfessionalUpdateRequest;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.service.IProfessionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    private final IProfessionalService professionalService;

    @Operation(
            summary = "allows to update a professional",
            description = "This endpoint allows to update a professional, the professional must exist and the category must exist",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Professional updated successfully",
                            content = @Content(schema = @Schema(implementation = ProfessionalResponse.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request body",
                            content = {@Content}),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = {@Content}),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Professional not found or category not found",
                            content = {@Content}),
            },
    parameters = {
            @Parameter(name = "id", description = "The professional id", required = true)
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> updateProfessional(@RequestBody @Valid ProfessionalUpdateRequest request,
                                                                   @PathVariable Long id) {
        return ResponseEntity.ok(professionalService.updateProfessional(request, id));
    }

    @SecurityRequirements
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessional(@PathVariable Long id) {
        Professional professional = professionalService.findById(id);
        if (professional != null) {
            return new ResponseEntity<>(professionalService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("The professional with that id doesn't exists!", HttpStatus.NOT_FOUND);

    }

    @SecurityRequirements
    @GetMapping
    public ResponseEntity<?> getAllProfessionals() {
        List<Professional> professionals = professionalService.getAllProfessional();
        if (!professionals.isEmpty()) {
            return new ResponseEntity<>(professionalService.getAllProfessional(), HttpStatus.OK);
        } else
            return new ResponseEntity<>("There isn't any professional to show", HttpStatus.NO_CONTENT);

    }

    @SecurityRequirements
    @GetMapping("/professionals/category/availability/{categoryId}/{availability}")
    public ResponseEntity<?> getProfessionalByCategoryAndAvailability(@PathVariable Long categoryId, @PathVariable String availability) {
        List<Professional> professionalsByCategory = professionalService.getProfessionalByCategory(categoryId);
        if (availability.isBlank()) {
            return ResponseEntity.ok(professionalsByCategory);
        }
        List<Professional> professionalsByCategoryAvailability = professionalsByCategory.stream().filter(
                professional -> professional.getAvailability().equalsIgnoreCase(availability)).collect(Collectors.toList());

        return ResponseEntity.ok(professionalsByCategoryAvailability);
    }

    @SecurityRequirements
    @GetMapping("/professionals/category/rating/{categoryId}/{rating}")
    public ResponseEntity<?> getProfessionalByCategoryAndRating(@PathVariable Long categoryId, @PathVariable int rating) {
        List<Professional> professionalsByCategory = professionalService.getProfessionalByCategory(categoryId);
        if (rating > 5 || rating < 1) {
            return ResponseEntity.ok(professionalsByCategory);
        }
        List<Professional> professionalsByCategoryRating = professionalsByCategory.stream().filter(
                professional -> professional.calculateAverageRating() >= rating).collect(Collectors.toList());

        return ResponseEntity.ok(professionalsByCategoryRating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessional(@PathVariable Long id) {
        if (professionalService.deleteProfessional(id)) {
            return new ResponseEntity<>("Professional deleted", HttpStatus.OK);

        } else
            return new ResponseEntity<>("The professional with that id doesn't exists!", HttpStatus.NOT_FOUND);

    }
}
