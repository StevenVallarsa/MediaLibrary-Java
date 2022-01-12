
package com.sv.medialibrary2022.ui;

import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.management.Descriptor;

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
        io.print("4. Modify Media or Library ");
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
                    io.printMedia("%s: %-30s : %-20s : %s%n",new String[] {id, title, creator, format});
                }
            }
        }
    }

    public String getSearchTerm() {
        return io.readString("Enter your search term");
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

    public void modifyMedia(Media item) {

    }

    public String[] modifyMediaOrLibrary(List<Library> libraries, List<Media> media) {
        String input = io.readString("Select one of the ID numbers above");
        try {
            int testForInt = Integer.parseInt(input);
            if (input.length() < 2 || input.length() > 3) {
                throw new Exception("That's not a valid ID number");
            }
            if (input.equals("00")) {
                throw new Exception("You cannot modify the default library");
            }
            
        } catch (NumberFormatException e) {
            io.print("That's not an ID number");
            return null;
        } catch (Exception e) {
            io.print(e.getMessage());
            return null;
        }
        
        String[] libraryIDs = new String[libraries.size()];
        for (int i = 0; i < libraries.size(); i++) {
            libraryIDs[i] = libraries.get(i).getLibraryID();
        }
        
        if (input.length() == 2) {
            for (Library library : libraries) {
                if (library.getLibraryID().equals(input)) {
                    return modifyLibrary(library);
                }
            }
            io.print("That library doesn't exist");
            return null;
        } else {
            for (Media item : media) {
                if (item.getMediaID().equals(input)) {
                    return modifyMediaItem(item, libraryIDs);
                }
            }
            io.print("That media item doesn't exist");
            return null;
        }
    }
    
    private String[] modifyLibrary(Library library) {
        io.print("\n-+-+-+-+-+-+-+-+-+-+");
        io.print("MODIFY LIBRARY #" + library.getLibraryID() + ": " + library.getName());
        io.print("-+-+-+-+-+-+-+-+-+-+\n");
        io.print("Press ENTER on items you don't want to change\n");
        
        String name = io.readString("NAME: " + library.getName());
        String location = io.readString("LOCATION: " + library.getLocation());
        String description = io.readString("DESCRIPTION: " + library.getDescription());
        
        if (name.isBlank()) name = library.getName();
        if (location.isBlank()) location = library.getLocation();
        if (description.isBlank()) description = library.getDescription();
        
        return new String[] {library.getLibraryID(), name, location, description};
    }
    
    private String[] modifyMediaItem(Media media, String[] libraryIDs) {
        
        io.print("\n-+-+-+-+-+-+-+-+-+-+");
        io.print("MODIFY MEDIA ITEM #" + media.getMediaID()+ ": " + media.getTitle());
        io.print("-+-+-+-+-+-+-+-+-+-+\n");
        io.print("Press ENTER on items you don't want to change\n");
        
        String title = io.readString("TITLE: " + media.getTitle());
        String creator = io.readString("CREATOR: " + media.getCreator());
        String description = io.readString("DESCRIPTION: " + media.getDescription());
        String year = io.readString("YEAR: " + media.getYear());
        String genre = io.readString("GENRE: " + media.getGenre());
        String format = io.readString("FORMAT: " + media.getFormat());
        String library = io.readString("LIBRARY: " + media.getLibrary());
        
        if (Arrays.asList(libraryIDs).contains(library)) {
            if (title.isBlank()) title = media.getTitle();
            if (creator.isBlank()) creator = media.getCreator();
            if (description.isBlank()) description = media.getDescription();
            if (year.isBlank()) year = media.getYear();
            if (genre.isBlank()) genre = media.getGenre();
            if (format.isBlank()) format = media.getFormat();
            if (library.isBlank()) library = media.getLibrary();
            
            return new String[] {media.getMediaID(), title, creator, description, year, genre, format, library};
        }
        io.print("That library doesn't exist. No changes were made.");
        
        return null;
    }

}
