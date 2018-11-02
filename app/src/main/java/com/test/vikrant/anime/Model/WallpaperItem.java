package com.test.vikrant.anime.Model;

public class WallpaperItem {

    private String imagePath;
    private String imageUrl;
    private String categoryId;
    private String imageFinal;
    private long viewCount;
    public WallpaperItem(){

    }
    public WallpaperItem(String imageUrl,String imagePath,String finalImagePath){

        this.imagePath=imagePath;
        this.imageUrl=imageUrl;
        this.imageFinal =finalImagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageFinal() {
        return imageFinal;
    }

    public void setImageFinal(String imageFinal) {
        this.imageFinal = imageFinal;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }
}
