package com.fullcycle.CatalogoVideos.infrastructure.data;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fullcycle.CatalogoVideos.domain.entity.Category;
import com.fullcycle.CatalogoVideos.infraestructure.data.SpringDataCategoryRepository;
import com.fullcycle.CatalogoVideos.infraestructure.mysql.MySQLCategoryRepositoryImpl;
import com.fullcycle.CatalogoVideos.infraestructure.persistence.CategoryPersistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SpringDataCategoryRepositoryTests {

    @Autowired
    private SpringDataCategoryRepository repository;

    @Test
    public void saveCategory() {
        CategoryPersistence input = new CategoryPersistence();
        input.setName("Action");
        input.setDescription("Action Description");
        input.setIsActive(true);

        CategoryPersistence actual = repository.save(input);

        assertThat(actual).isNotNull();
        assertThat(actual).hasFieldOrPropertyWithValue("name", "Action");
        assertThat(actual.getIsActive()).isTrue();
    }

    
}
