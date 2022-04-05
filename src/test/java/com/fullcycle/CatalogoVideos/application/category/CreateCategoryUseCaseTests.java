package com.fullcycle.CatalogoVideos.application.category;

import com.fullcycle.CatalogoVideos.application.usecase.category.create.CreateCategoryUseCase;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CreateCategoryUseCaseTests {
    @InjectMocks
    private CreateCategoryUseCase useCase;

    @Mock
    ICategoryRepository repository;
    
    @Test
    public void executeReturnsCreatedCategory(){

    }
}
