
package com.sv.medialibrary2022.ui;

import com.sv.medialibrary2022.dto.Media;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class MediaLibraryView {
    
    private UserIO io = new UserIOImpl();
    
        public int printMenuAndGetSelection() {

            io.print("\nMAIN MENU");
            io.print("=========");
            io.print("1. List Media by Libraries");
            io.print("2. Create Media");
            io.print("3. Create Library");
            io.print("4. View Specific Media");
            io.print("5. View Specific Library");
            io.print("6. Remove Media");
            io.print("7. Remove Library");
            io.print("8. Move Media Item");
            io.print("9. EXIT");
            
            return io.readInt("\nWhat is your pleasure?", 1, 9);
        }
        
        public Media getNewMediaInfo() {
            String mediaID = io.readString("ID #");
            String title = io.readString("Title");
            String creator = io.readString("Creator");
            String description = io.readString("Description");
            String year = io.readString("Year");
            String genre = io.readString("Genre");
            String format = io.readString("Media format");
            String libraryID = "00"; // All media default to return cart on creation
            
            Media item = new Media(mediaID);
            item.setTitle(title);
            item.setCreator(creator);
            item.setDescription(description);
            item.setYear(year);
            item.setGenre(genre);
            item.setFormat(format);
            item.setLibraryID(libraryID);
            
            return item;
        }
 
}
