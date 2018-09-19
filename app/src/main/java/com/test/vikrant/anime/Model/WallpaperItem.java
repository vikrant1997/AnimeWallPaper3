package com.test.vikrant.anime.Model;

import java.io.InputStream;

public class WallpaperItem {
<<<<<<< HEAD

    private String imagePath;
    private String imageUrl;
    private String categoryId;
=======
    public String imageUrl;
    public String categoryId;
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337

    public WallpaperItem(){

    }
<<<<<<< HEAD
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

=======

    public WallpaperItem(String imageLink, String categoryId) {
        this.imageUrl = imageLink;
        this.categoryId = categoryId;
    }

>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
    public String getImageUrl() {
        return imageUrl;
    }

<<<<<<< HEAD
//    public void setCategoryId(String categoryId) {
//        this.categoryId = categoryId;
//    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
=======
    public void setImageUrl(String imageLink) {
        this.imageUrl = imageLink;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
    }
}
