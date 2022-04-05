package com.fullcycle.CatalogoVideos.application.usecase.category.create;

import com.fullcycle.CatalogoVideos.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateCategoryUseCase implements ICreateCategoryUseCase{
    
    private ICategoryRepository repository;
    @Override
    public CategoryOutputData execute(CreateCategoryInputData input) {
        return null;
    }
    
} 