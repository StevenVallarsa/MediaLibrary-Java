
package com.sv.medialibrary2022.controller;

import com.sv.medialibrary2022.controller.dao.MediaLibraryDao;
import com.sv.medialibrary2022.controller.dao.MediaLibraryDaoImpl;
import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import com.sv.medialibrary2022.ui.MediaLibraryView;
import com.sv.medialibrary2022.ui.UserIO;
import com.sv.medialibrary2022.ui.UserIOImpl;
import java.util.List;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: Work with user input 
 */
public class MediaLibraryController {
    
    private MediaLibraryView view = new MediaLibraryView();
    private MediaLibraryDao dao = new MediaLibraryDaoImpl();
    
    public void run() {
        boolean isRunning = true;
        int menuSelection = 0;
        
        while(isRunning) {
            
            menuSelection = getMenuSelection();
            
            switch(menuSelection) {
                
                // LIST MEDIA BY LIBRARIES
                case 1:
                    view.displayLibrariesAndMedia(getLibraryList(), getMediaList());
                    break;
                    
                // CREATE NEW MEDIA ITEM
                case 2:
                    Media newMedia = view.getNewMediaInfo();
                    dao.addMedia(newMedia);
                    view.displaySuccessBanner("created", newMedia.getFormat(), newMedia.getTitle());
                    break;
                    
                // SEARCH MEDIA
                case 3:
                    String search = view.getSearchTerm();
                    List<Media> results = dao.findMedia(search);
                    view.displaySearchResults(results);
                    break;
                    
                // MODIFY MEDIA
                case 4:
                    List<Media> media = getMediaList();
                    List<Library> libraries = getLibraryList();
                    view.displayLibrariesAndMedia(libraries, media);
                    String[] revisedItem = view.modifyMediaOrLibrary(libraries, media);
                    if (revisedItem != null) {
                        if (revisedItem.length == 4) {
                            
                        }
                    }
                    
                    
                    break;
                    
                // REMOVE MEDIA    
                case 5:
                    view.print("Remove Media");
                    break;
                case 6:
                    // CREATE NEW LIBRARY
                    Library newLibrary = view.getNewLibraryInfo();
                    dao.addLibrary(newLibrary);
                    view.print("You successfully created a new library named \"" + newLibrary.getName() + "\"");
                    break;
                case 7:
                    view.print("List Libraries");
                    break;
                case 8:
                    view.print("Remove Library");
                    break;
                case 9:
                    isRunning = false;
                    break;
                default:
                    view.print("UNKNOWN COMMAND");
            }
        }
        view.print("\nGOOD BYE!");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private List<Library> getLibraryList() {
        return dao.getAllLibraries();
    }

    private List<Media> getMediaList() {
        return dao.getAllMedia();
    }
    
}
