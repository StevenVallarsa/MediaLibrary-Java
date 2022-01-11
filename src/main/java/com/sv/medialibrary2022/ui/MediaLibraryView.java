
package com.sv.medialibrary2022.ui;

import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class MediaLibraryView {
    
    private UserIO io = new UserIOImpl();
    
        public void print(String prompt) {
            io.print(prompt);
        }
    
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
            item.setLibrary(libraryID);
            
            return item;
        }
        
        public void displayLibrariesAndMedia(List<Library> libraries, List<Media> media) {
            
            for (Library library : libraries) {
                io.print("\n-+-+-+-+-+-+-+-+-+-+-+-+");
                io.print(library.getLibraryID() + " : " + library.getDescription() + " : " + library.getLocation());
                io.print("-+-+-+-+-+-+-+-+-+-+-+-+");
                for (Media item : media) {
                    
                    String id = item.getMediaID();
                    String title = item.getTitle();
                    String creator = item.getCreator();
                    String format = item.getFormat();
                    
                    if (title.length() > 29) {
                        title = title.substring(0, 27) + "...";
                    }
                    if (creator.length() > 19) {
                        creator = creator.substring(0, 17) + "...";
                    }
                    if (item.getLibrary().equals(library.getLibraryID())) {
                        io.printMedia("+%s: %-30s : %-20s : %s%n",new String[] {id, title, creator, format});
                    }
                }
            }
        }
 
}
