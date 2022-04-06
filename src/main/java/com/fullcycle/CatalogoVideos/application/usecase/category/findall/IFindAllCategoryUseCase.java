package com.fullcycle.CatalogoVideos.application.usecase.category.findall;

import java.util.List;

import com.fullcycle.CatalogoVideos.application.usecase.category.common.CategoryOutputData;

public interface IFindAllCategoryUseCase {
    List<CategoryOutputData> execute();
}
