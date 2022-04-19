package com.fullcycle.CatalogoVideos.infraestructure.data;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataCategoryRepository extends CrudRepository<CategoryPersistence, UUID>{
    
}
