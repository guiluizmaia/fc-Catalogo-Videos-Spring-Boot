package com.fullcycle.CatalogoVideos.application.category;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fullcycle.CatalogoVideos.application.usecase.category.delete.RemoveCategoryUseCase;
import com.fullcycle.CatalogoVideos.domain.entity.Category;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RemoveCategoryUseCaseTests {
    @InjectMocks
    private RemoveCategoryUseCase useCase;

    @Mock
    ICategoryRepository repository;

    @BeforeEach
    void initUseCase () {
        useCase = new RemoveCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsRemoveCategory() {
        Category category = new Category(
            "Action", 
            "Action Description",
            true
        );

        doNothing().when(repository).remove(category.getId());
        useCase.execute(category.getId());
        
        assertThat(category).isNotNull();
        verify(repository, times(1)).remove(category.getId());
    }
}
