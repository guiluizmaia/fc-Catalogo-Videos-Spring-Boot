package com.fullcycle.CatalogoVideos.infraestructure.mysql;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fullcycle.CatalogoVideos.domain.entity.Category;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;
import com.fullcycle.CatalogoVideos.infraestructure.data.SpringDataCategoryRepository;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MySQLCategoryRepositoryImpl implements ICategoryRepository{

    private SpringDataCategoryRepository repository;

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public Optional<Category> findById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void remove(UUID id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Category category) {
        // TODO Auto-generated method stub
        
    }
    
}
