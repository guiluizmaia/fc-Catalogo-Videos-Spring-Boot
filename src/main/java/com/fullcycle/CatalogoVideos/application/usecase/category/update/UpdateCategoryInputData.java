package com.fullcycle.CatalogoVideos.application.usecase.category.update;

import lombok.Data;

@Data
public class UpdateCategoryInputData {
    private String name;
    private String description;
    private Boolean isActive;
}
