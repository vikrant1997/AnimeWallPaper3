package com.test.vikrant.anime.Model;

import java.io.InputStream;

public class WallpaperItem {

    private String imagePath;
    private String imageUrl;
    private String categoryId;

    public WallpaperItem(){

    }
    public WallpaperItem(String imageUrl,String imagePath){

        this.imagePath=imagePath;
        this.imageUrl=imageUrl;

    }

//    public String getImagePath() {
//        return ImagePath;
//    }
//
//    public void setImagePath(String imagePath) {
//        ImagePath = imagePath;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getImagePath() {
        return imagePath;
    }

//    public String getCategoryId() {
//        return categoryId;
//    }

    public String getImageUrl() {
        return imageUrl;
    }

//    public void setCategoryId(String categoryId) {
//        this.categoryId = categoryId;
//    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
