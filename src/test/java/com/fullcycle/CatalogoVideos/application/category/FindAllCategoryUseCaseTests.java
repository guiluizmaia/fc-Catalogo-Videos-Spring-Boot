package com.fullcycle.CatalogoVideos.application.category;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import com.fullcycle.CatalogoVideos.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideos.application.usecase.category.findall.FindAllCategoryUseCase;
import com.fullcycle.CatalogoVideos.domain.entity.Category;
import com.fullcycle.CatalogoVideos.domain.repository.ICategoryRepository;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class FindAllCategoryUseCaseTests {
    @InjectMocks
    private FindAllCategoryUseCase useCase;

    @Mock
    ICategoryRepository repository;

    @BeforeEach
    void initUseCase () {
        useCase = new FindAllCategoryUseCase(repository);
    }
    
    @Test
    public void executeReturnsFindAllCategory() {
        List<Category> categories = Arrays.asList(
            new Category(
                "Action", 
                "Action Description", 
                true
            ),
            new Category(
                "Horror", 
                "Horror Description", 
                true
            ),
            new Category(
                "Suspense", 
                "Suspense Description", 
                true
            )
        );

        when(repository.findAll()).thenReturn(categories);

        // doReturn(categories).when(repository).findAll();
        List<CategoryOutputData> actual = useCase.execute();
        repository.findAll();

        assertThat(categories).isNotNull();
        assertThat(categories).hasSize(3);
        verify(repository, times(1)).findAll();

        assertThat(actual).isNotNull();
        assertThat(categories).hasSize(3);
    }
}
