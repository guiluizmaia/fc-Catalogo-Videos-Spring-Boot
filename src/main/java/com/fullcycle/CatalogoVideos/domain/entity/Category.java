package com.fullcycle.CatalogoVideos.domain.entity;

import java.util.UUID;

import com.fullcycle.CatalogoVideos.domain.exception.NotBlankException;
import com.fullcycle.CatalogoVideos.domain.exception.NotNullException;

public class Category {
    private UUID id;
    private String name;
    private String description;
    private Boolean isActive = true;    

    public Category(UUID id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
    }

    public Category(String name, String description) {
        this.id = UUID.randomUUID();
        this.setName(name);
        this.setDescription(description);
    }


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name)  {
        if (name == null){
            throw new NotNullException("Can not be null");
        }
        if (name.isEmpty()){
            throw new NotBlankException("Can not be blank");
        }
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isIsActive() {
        return this.isActive;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Boolean active(){
        return this.isActive = true;
    }

    public Boolean deactive(){
        return this.isActive = false;
    }

    public void update(String name, String description, Boolean isActive)  {
        this.setName(name);
        this.setDescription(description);
        if(isActive != null && isActive != this.getIsActive()){
            if (isActive == true){
                this.active();
            } else {
                this.deactive();
            }
        }
    }
}
