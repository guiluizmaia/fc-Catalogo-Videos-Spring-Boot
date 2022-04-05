package com.fullcycle.CatalogoVideos.application.usecase.category.common;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryOutputData {
    private UUID id;
    private String name;
    private String description;
    private Boolean isActive;
}
