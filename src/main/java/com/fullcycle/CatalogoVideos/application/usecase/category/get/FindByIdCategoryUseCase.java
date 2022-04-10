package com.fullcycle.CatalogoVideos.application.usecase.category.get;

import java.util.UUID;

import com.fullcycle.CatalogoVideos.application.exception.NotFoundException;
import com.fullcycle.CatalogoVideos.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindByIdCategoryUseCase implements IFindByIdCategoryUseCase {

    private ICategoryRepository repository;
    
    @Override
    public CategoryOutputData execute(UUID id) {
        return repository.findById(id)
            .map(CategoryOutputData::fromDomain)
            .orElseThrow(() -> new NotFoundException("Category %s not found", id));

    }
    
}
