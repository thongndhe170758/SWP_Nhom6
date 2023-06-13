/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author taote
 */
public class CategoryGenreInfo {
    private int categoryId;
    private int genreId;

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public CategoryGenreInfo() {
    }

    public CategoryGenreInfo(int categoryId, int genreId) {
        this.categoryId = categoryId;
        this.genreId = genreId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getGenreId() {
        return genreId;
    }

    @Override
    public String toString() {
        return "CategoryGenreInfo{" + "categoryId=" + categoryId + ", genreId=" + genreId + '}';
    }
    
}
