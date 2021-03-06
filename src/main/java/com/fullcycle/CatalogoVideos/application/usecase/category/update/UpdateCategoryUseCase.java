package com.fullcycle.CatalogoVideos.application.usecase.category.update;

import java.util.UUID;

import com.fullcycle.CatalogoVideos.application.exception.NotFoundException;
import com.fullcycle.CatalogoVideos.domain.entity.Category;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateCategoryUseCase implements IUpdateCategoryUseCase{
    private ICategoryRepository repository;

    @Override
    public void execute(UUID id, UpdateCategoryInputData input) {
        Category category = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Category %s not found", id));
        
        category.update(
            input.getName(), 
            input.getDescription(), 
            input.getIsActive()
        );

        repository.update(category);        
    }
    
}
