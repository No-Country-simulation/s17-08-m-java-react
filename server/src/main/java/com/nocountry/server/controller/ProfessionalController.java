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
import org.springframework.data.domain.Page;
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
            summary = "Allows to update a professional",
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
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unexpected error has occurred. We are working to resolve the problem.",
                            content = {@Content}
                    )
            },
            parameters = {
                    @Parameter(name = "id", description = "The professional id", required = true)
            })
    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> updateProfessional(@RequestBody @Valid ProfessionalUpdateRequest request,
                                                                   @PathVariable Long id) {
        return ResponseEntity.ok(professionalService.updateProfessional(request, id));
    }

    @Operation(
            summary = "Get a professional by id",
            description = "This endpoint allows to get a professional by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Professional successfully generated",
                            content = @Content(schema = @Schema(implementation = ProfessionalResponse.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Professional not found",
                            content = {@Content}),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unexpected error has occurred. We are working to resolve the problem.",
                            content = {@Content})
            },
            parameters = {
                    @Parameter(name = "id", description = "The professional id", required = true)
            }
    )
    @SecurityRequirements
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessional(@PathVariable Long id) {
        return ResponseEntity.ok(professionalService.findById(id));
    }

    @Operation(
            summary = "Get all professionals paginated",
            description = "if you don't specify the page and size, the default values are 0 and 10",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Professional list successfully generated",
                            content = @Content(schema = @Schema(implementation = ProfessionalResponse.class))),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There isn't any professional to show",
                            content = {@Content}),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unexpected error has occurred. We are working to resolve the problem.",
                            content = {@Content})
            }
    )
    @SecurityRequirements
    @GetMapping
    public ResponseEntity<?> getAllProfessionals(@RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<ProfessionalResponse> professionalPage = professionalService.getAllProfessional(page, size);
        if (professionalPage.isEmpty()) {
            return new ResponseEntity<>("There isn't any professional to show", HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(professionalPage);
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

    @Operation(
            summary = "Allow Lock a professional account",
            description = "you must specify the professional id, you must be an admin to lock a professional account",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Professional locked",
                            content = {@Content}),
                    @ApiResponse(
                            responseCode = "404",
                            description = "The professional with that id doesn't exists!",
                            content = {@Content}),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = {@Content}),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unexpected error has occurred. We are working to resolve the problem.",
                            content = {@Content})
            },
            parameters = {
                    @Parameter(name = "id", description = "The professional id", required = true)
            }
    )
    @PatchMapping("/{id}")
    public ResponseEntity<String> lockProfessional(@PathVariable Long id) {
        if (professionalService.lockProfessionalAccount(id)) {
            return new ResponseEntity<>("Professional locked", HttpStatus.OK);

        } else
            return new ResponseEntity<>("The professional with that id doesn't exists!", HttpStatus.NOT_FOUND);
    }
}
