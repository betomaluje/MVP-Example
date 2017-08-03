package com.betomaluje.mvpexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by betomaluje on 8/3/17.
 */

public class Pokemon {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sprites")
    @Expose
    private Sprites sprites;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getImageUrl() {
        return sprites != null ? sprites.getImageUrl() : "";
    }

    private class Sprites {
        @SerializedName("front_default")
        @Expose
        private String imageUrl;

        public String getImageUrl() {
            return imageUrl;
        }
    }
}