
package com.sv.medialibrary2022.dto;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class Media {

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setLibraryID(String libraryID) {
        this.libraryID = libraryID;
    }
    
    private String mediaID;
    private String title;
    private String creator;
    private String description;
    private String year;
    private String genre;
    private String format;
    private String libraryID;
    
    public Media(String mediaID) {
        this.mediaID = mediaID;
    }
    
    public String getMediaID() {
        return mediaID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setAuthors(String author) {
        this.creator = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLibrary() {
        return libraryID;
    }

    public void setLibrary(String libraryID) {
        this.libraryID = libraryID;
    }
    

}
