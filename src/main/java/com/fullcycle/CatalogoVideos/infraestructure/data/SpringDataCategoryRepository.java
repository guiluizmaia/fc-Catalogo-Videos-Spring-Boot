package com.fullcycle.CatalogoVideos.infraestructure.data;

import java.util.UUID;

import com.fullcycle.CatalogoVideos.infraestructure.persistence.CategoryPersistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryPersistence, UUID>{
    
}
