package com.fullcycle.CatalogoVideos.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fullcycle.CatalogoVideos.domain.exception.DomainException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
public class CategoryTests {

    @Test
    public void throwDomainExceptionWheNameIsNull(){
        assertThrows(DomainException.class, () -> new Category(null, "Description"));
    }

    @Test
    public void throwDomainExceptionWheNameIsBlank(){
        assertThrows(DomainException.class, () -> new Category("", "Description"));
    }

    @Test
    public void createCategoryWithNameAndDescriptionIsNull() throws Exception {
        final Category entity = new Category(
            "Name 1",
            null
        );

        assertNotNull(entity);
        assertNotNull(entity.getId());
        assertEquals(entity.getName(), "Name 1");
        assertNull(entity.getDescription());
    }
    
    @Test
    public void createCategoryWithNameAndDescription() throws Exception {
        final Category entity = new Category(
            "Name 1",
            "Description 2"
        );

        assertNotNull(entity);
        assertNotNull(entity.getId());
        assertEquals(entity.getName(), "Name 1");
        assertEquals(entity.getDescription(), "Description 2");
    }
    
    @Test
    public void createCategoryAndIsActivateTrue() throws Exception {
        final Category entity = new Category(
            "Name 1",
            "Description 2"
        );

        assertNotNull(entity);
        assertTrue(entity.getIsActive());
    }

    @Test
    public void createCategoryAndIsDeactivate() throws Exception {
        final Category entity = new Category(
            "Name 1",
            "Description 2"
        );

        entity.deactive();
        assertNotNull(entity);
        assertFalse(entity.getIsActive());
    }


    @Test
    public void createCategoryAndUpdate() throws Exception {
        final Category entity = new Category(
            "Name 1",
            "Description 2"
        );

        assertNotNull(entity);
        assertEquals(entity.getName(), "Name 1");
        assertEquals(entity.getDescription(), "Description 2");
        assertTrue(entity.getIsActive());

        entity.update("Name 2", "Desc", false);

        assertNotNull(entity);
        assertEquals(entity.getName(), "Name 2");
        assertEquals(entity.getDescription(), "Desc");
        assertFalse(entity.getIsActive());

    }
    
}
