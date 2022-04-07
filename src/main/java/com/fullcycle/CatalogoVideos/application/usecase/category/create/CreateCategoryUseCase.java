package com.fullcycle.CatalogoVideos.application.usecase.category.create;

import com.fullcycle.CatalogoVideos.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideos.domain.entity.Category;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateCategoryUseCase implements ICreateCategoryUseCase{
    
    private ICategoryRepository repository;
    @Override
    public CategoryOutputData execute(CreateCategoryInputData input) {
        var created = repository.create(toDomain(input));
        return CategoryOutputData.fromDomain(created);
    }

    private Category toDomain(CreateCategoryInputData input){
        return new Category(
            input.getName(),
            input.getDescription(),
            input.getIsActive()
        );
    }
    
} 