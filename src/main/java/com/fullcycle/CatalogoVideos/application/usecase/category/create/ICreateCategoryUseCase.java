package com.fullcycle.CatalogoVideos.application.usecase.category.create;

import com.fullcycle.CatalogoVideos.application.usecase.category.common.CategoryOutputData;

public interface ICreateCategoryUseCase{
    CategoryOutputData execute(CreateCategoryInputData input);
}