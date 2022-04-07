package com.fullcycle.CatalogoVideos.application.category;

import static org.mockito.Mockito.when;

import java.util.Optional;

import com.fullcycle.CatalogoVideos.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideos.application.usecase.category.get.FindByIdCategoryUseCase;
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
public class FindByIdCategoryUseCaseTest {
    @InjectMocks
    private FindByIdCategoryUseCase useCase;

    @Mock
    ICategoryRepository repository;

    @BeforeEach
    void initUseCase () {
        useCase = new FindByIdCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsFindByIdCategory() throws Exception {
        Category category = new Category(
            "Action", 
            "Action Description",
            true
        );

        Optional<Category> opCategory = Optional.of(category);
        
        when(repository.findById(category.getId())).thenReturn(opCategory);

        CategoryOutputData actual = useCase.execute(category.getId());

        assertThat(category).isNotNull();
        assertThat(actual).isNotNull();
    }
}
