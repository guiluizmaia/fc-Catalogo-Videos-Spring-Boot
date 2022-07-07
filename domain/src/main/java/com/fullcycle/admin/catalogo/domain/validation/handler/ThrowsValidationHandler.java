package com.fullcycle.admin.catalogo.domain.validation.handler;

import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.validation.Error;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.width(List.of(anError));
    }

    @Override
    public ValidationHandler append(final ValidationHandler anHandler) {
        throw DomainException.width(anHandler.getErrors());
    }

    @Override
    public ValidationHandler append(final Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception ex){
            throw DomainException.width(List.of(new Error(ex.getMessage())));
        }

        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }

}
