package com.test.vikrant.anime.Model;

import java.io.InputStream;

public class WallpaperItem {
    public String imageUrl;
    public String categoryId;

    public WallpaperItem(){

    }

    public WallpaperItem(String imageLink, String categoryId) {
        this.imageUrl = imageLink;
        this.categoryId = categoryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageLink) {
        this.imageUrl = imageLink;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
