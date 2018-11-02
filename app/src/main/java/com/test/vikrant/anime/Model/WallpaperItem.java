package com.test.vikrant.anime.Model;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import java.io.InputStream;

>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
public class WallpaperItem {

    private String imagePath;
    private String imageUrl;
    private String categoryId;
<<<<<<< HEAD
    private String imageFinal;
    private long viewCount;
    public WallpaperItem(){

    }
    public WallpaperItem(String imageUrl,String imagePath,String finalImagePath){

        this.imagePath=imagePath;
        this.imageUrl=imageUrl;
        this.imageFinal =finalImagePath;
    }

=======

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

>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    public String getImagePath() {
        return imagePath;
    }

<<<<<<< HEAD
=======
//    public String getCategoryId() {
//        return categoryId;
//    }

>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    public String getImageUrl() {
        return imageUrl;
    }

<<<<<<< HEAD
    public String getImageFinal() {
        return imageFinal;
    }

    public void setImageFinal(String imageFinal) {
        this.imageFinal = imageFinal;
    }
=======
//    public void setCategoryId(String categoryId) {
//        this.categoryId = categoryId;
//    }
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
<<<<<<< HEAD

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }
=======
=======
public class WallpaperItem {
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
}
