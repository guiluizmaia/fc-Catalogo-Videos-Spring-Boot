package com.fullcycle.admin.catalogo.application;

import com.fullcycle.admin.catalogo.domain.Category;

public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN anIn);
}