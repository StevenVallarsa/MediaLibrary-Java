
package com.sv.medialibrary2022.dto;

import java.util.Objects;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class Media {

    @Override
    public String toString() {
        return "Media{" + "mediaID=" + mediaID + ", title=" + title + ", creator=" + creator + ", description=" + description + ", year=" + year + ", genre=" + genre + ", format=" + format + ", library=" + library + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.mediaID);
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.creator);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.year);
        hash = 53 * hash + Objects.hashCode(this.genre);
        hash = 53 * hash + Objects.hashCode(this.format);
        hash = 53 * hash + Objects.hashCode(this.library);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Media other = (Media) obj;
        if (!Objects.equals(this.mediaID, other.mediaID)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.creator, other.creator)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.format, other.format)) {
            return false;
        }
        if (!Objects.equals(this.library, other.library)) {
            return false;
        }
        return true;
    }

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
    
    public Media() {
        this.library = "00";
    }

    public String getMediaID() {
        return mediaID;
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
