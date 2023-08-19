package com.driver.models;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table
public class Image{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int imageId;
    private String description;
    private String dimensions;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image(){

    }
    public Image(Blog blog, String description,String dimensions){
        this.blog = blog;
        this.dimensions = dimensions;
        this.description = description;
    }
    public Image(int  imageId, String description,String dimensions, Blog blog){
        this.imageId = imageId;
        this.dimensions = dimensions;
        this.description = description;
        this.blog = blog;
    }
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}