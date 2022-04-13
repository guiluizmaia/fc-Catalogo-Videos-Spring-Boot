package com.fullcycle.CatalogoVideos.application.category;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import com.fullcycle.CatalogoVideos.application.exception.NotFoundException;

import com.fullcycle.CatalogoVideos.application.usecase.category.update.UpdateCategoryInputData;
import com.fullcycle.CatalogoVideos.application.usecase.category.update.UpdateCategoryUseCase;
import com.fullcycle.CatalogoVideos.domain.entity.Category;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UpdateCategoryUseCaseTests {
    @InjectMocks
    private UpdateCategoryUseCase useCase;

    @Mock
    ICategoryRepository repository;

    @BeforeEach
    void initUseCase () {
        useCase = new UpdateCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsUpdateCategoryUseCaseName () {
        Category category = new Category(
            "Action", 
            "Action Description",
            true
        );

        Category expected = new Category(
            "Action2", 
            "Description",
            true
        );

        Optional<Category> opCategory = Optional.of(category);
        
        when(repository.findById(category.getId())).thenReturn(opCategory);
        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName("Action2");
        input.setDescription("Description");
        input.setIsActive(category.getIsActive());

        category.update(
            input.getName(), 
            input.getDescription(), 
            input.getIsActive());

        doNothing()
            .when(repository)
            .update(category);
        
        useCase.execute(category.getId(), input);

        assertThat(category).isNotNull();
        assertThat(expected).isNotNull();
        assertThat(category.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void executeReturnsUpdateCategoryUseCase () {
        Category category = new Category(
            "Action", 
            "Action Description",
            true
        );

        Category expected = new Category(
            "Action2", 
            "Description 2",
            true
        );

        Optional<Category> opCategory = Optional.of(category);
        
        when(repository.findById(category.getId())).thenReturn(opCategory);
        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName("Action2");
        input.setDescription("Description 2");
        input.setIsActive(false);

        category.update(
            input.getName(), 
            input.getDescription(), 
            input.getIsActive());

        doNothing()
            .when(repository)
            .update(category);
        
        useCase.execute(category.getId(), input);

        assertThat(category).isNotNull();
        assertThat(expected).isNotNull();
        assertThat(category.getName()).isEqualTo(expected.getName());
        assertThat(category.getDescription()).isEqualTo(expected.getDescription());
        assertFalse(category.getIsActive());
    }

    @Test
    public void throwNotFoundExceptionWhenCategoryIsNotFound() {
        Category category = new Category(
            "Action", 
            "Action Description",
            true
        );
        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName("Action2");
        input.setDescription("Description");
        input.setIsActive(category.getIsActive());
        assertThrows(NotFoundException.class, () -> {
           useCase.execute(UUID.fromString("3a1542ef-83c0-4809-98bb-17e9307672c8"), input);
        });
    }
}
