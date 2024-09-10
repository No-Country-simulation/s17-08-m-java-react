package com.nocountry.server.repository;

import com.nocountry.server.model.entity.Category;
import com.nocountry.server.model.entity.Professional;
import org.hibernate.sql.ast.tree.cte.CteColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    List<Professional> findAllByCategories(Category category);

    List<Professional> findAllByAvailability(String availability);
}
