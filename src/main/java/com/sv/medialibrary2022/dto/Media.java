
package com.sv.medialibrary2022.dto;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class Media {

    private String mediaID;
    private String title;
    private String creator;
    private String description;
    private String year;
    private String genre;
    private String format;
    private String library;
    
    // Once this entity is created as a database, the ID numbers  
    // will be auto generatred in sequential order.
    public Media(String mediaID) {
        this.mediaID = mediaID;
        this.library = "00"; // all new media put in default library upon creation
    }

    public String getMediaID() {
        return mediaID;
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

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }
}
