
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
                case 1:
                    // LIST MEDIA BY LIBRARIES
                    List<Library> libraries = getLibraryList();
                    List<Media> media = getMediaList();
                    view.displayLibrariesAndMedia(libraries, media);
                    break;
                case 2:
                    // CREATE NEW MEDIA ITEM
                    Media newMedia = view.getNewMediaInfo();
                    dao.addMedia(newMedia);
                    view.displaySuccessBanner("created", newMedia.getFormat(), newMedia.getTitle());
                    break;
                case 3:
                    view.print("View Specific Media Item");
                    break;
                case 4:
                    view.print("Move Media Item");
                    break;
                case 5:
                    view.print("Remove Media");
                    break;
                case 6:
                    // CREATE NEW LIBRARY
                    Library newLibrary = view.
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
