package com.fullcycle.CatalogoVideos.application.usecase.category.findall;

import java.util.List;
import java.util.stream.Collectors;

import com.fullcycle.CatalogoVideos.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindAllCategoryUseCase implements IFindAllCategoryUseCase{

    private ICategoryRepository repository;

    @Override
    public List<CategoryOutputData> execute() {
        var list = repository.findAll();
        return list.stream().map(c -> CategoryOutputData.fromDomain(c)).collect(Collectors.toList());
    }
    
}
