
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
            io.print("3. Search Media");
            io.print("4. Move Media Item");
            io.print("5. Remove Media");    
            io.print("6. Create Library");
            io.print("7. List Libraries");
            io.print("8. Remove Library");
            io.print("9. EXIT");
            
            return io.readInt("\nWhat would like to do?", 1, 9);
        }
        
        public Media getNewMediaInfo() {
            io.print("\n-+-+-+-+-+-+-+-+-+-+-+-");
            io.print("CREATE A NEW MEDIA ITEM");
            io.print("-+-+-+-+-+-+-+-+-+-+-+-");
            
            Media item = new Media();
            
            item.setTitle(io.readString("Title"));
            item.setCreator(io.readString("Creator"));
            item.setDescription(io.readString("Description"));
            item.setYear(io.readString("Year"));
            item.setGenre(io.readString("Genre"));
            item.setFormat(io.readString("Media format"));
            item.setLibrary("00");
            
            return item;
        }
        
        public Library getNewLibraryInfo() {
            io.print("\n-+-+-+-+-+-+-+-+-+-+");
            io.print("CREATE A NEW LIBRARY");
            io.print("-+-+-+-+-+-+-+-+-+-+");
            
            Library newLibrary = new Library();
            newLibrary.setName(io.readString("New library name"));
            newLibrary.setDescription(io.readString("Description"));
            newLibrary.setLocation(io.readString("Location"));
            return newLibrary;
        }
        
        public void displaySuccessBanner(String action, String format, String title) {
            io.print("You successfully " + action + " a " + format + " with the title of \" + title + \".");
        }
        
        public void displayLibrariesAndMedia(List<Library> libraries, List<Media> media) {
            
            for (Library library : libraries) {
                io.print("\n-+-+-+-+-+-+-+-+-+-+-+-+");
                io.print(library.getLibraryID() + " : " + library.getName()+ " : " + library.getLocation());
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
        
        public String getSearchTerm() {
            return io.readString("What are you looking for?");
        }
        
        public void displaySearchResults(List<Media> searchResults) {
            io.print("\n-+-+-+-+-+-+-+-+-+-+");
            io.print("SEARCH MEDIA LIBRARY");
            io.print("-+-+-+-+-+-+-+-+-+-+");
            io.printMedia("%s : %s : %-30s : %-20s : %s%n",new String[] {"ID", "LIB", "TITLE", "CREATOR", "FORMAT"});
            
            
            for (Media m : searchResults) {
                String id = m.getMediaID();
                String title = m.getTitle();
                String creator = m.getCreator();
                String format = m.getFormat();
                String lib = m.getLibrary();
                
                if (title.length() > 29) {
                    title = title.substring(0, 27) + "...";
                }
                if (creator.length() > 19) {
                    creator = creator.substring(0, 17) + "...";
                }
                
                io.printMedia("%s : %s : %-30s : %-20s : %s%n",new String[] {id, lib, title, creator, format});
                
            }
            
        }
        
 
}
