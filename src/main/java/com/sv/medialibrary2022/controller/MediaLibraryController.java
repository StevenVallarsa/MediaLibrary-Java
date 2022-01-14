
package com.sv.medialibrary2022.controller;

import com.sv.medialibrary2022.dao.MediaLibraryDao;
import com.sv.medialibrary2022.dao.MediaLibraryPersistenceException;
import com.sv.medialibrary2022.dao.MediaLibraryDaoImpl;
import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import com.sv.medialibrary2022.ui.MediaLibraryView;
import com.sv.medialibrary2022.ui.UserIO;
import com.sv.medialibrary2022.ui.UserIOImpl;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: Work with user input 
 */
public class MediaLibraryController {
    
    private MediaLibraryView view;
    private MediaLibraryDao dao;
    
    public MediaLibraryController(MediaLibraryDao dao, MediaLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() throws MediaLibraryPersistenceException {
        boolean isRunning = true;
        int menuSelection = 0;
        
        while(isRunning) {
            
            List<Media> media = getMediaList();
            List<Library> libraries = getLibraryList();

            menuSelection = getMenuSelection();
            
            switch(menuSelection) {
                
                // LIST MEDIA BY LIBRARIES
                case 1:
                    view.displayLibrariesAndMedia(libraries, media);
                    break;
                    
                // CREATE NEW MEDIA ITEM
                case 2:
                    Media newMedia = view.createNewMedia();
                    dao.addMedia(newMedia);
                    view.displaySuccessBanner("created", newMedia.getFormat(), newMedia.getTitle());
                    break;
                    
                // SEARCH MEDIA
                case 3:
                    String search = view.getSearchTerm();
                    List<Media> results = dao.findMedia(search);
                    view.displaySearchResults(results);
                    break;
                    
                // GET MEDIA DETAILS
                case 4:
                    view.displayLibrariesAndMedia(libraries, media);
                    view.displayMediaItem(libraries, media);
                    break;
                    
                // MODIFY MEDIA
                case 5:
                    view.displayLibrariesAndMedia(libraries, media);
                    String[] revisedItem = view.modifyMediaOrLibrary(libraries, media);
                    String item = "";
                    String title = "";
                    if (revisedItem != null) {
                        if (revisedItem.length == 4) {
                            dao.modifyLibrary(revisedItem);
                            item = "library";
                            title = revisedItem[1];
                        } else {
                            dao.modifyMedia(revisedItem);
                            item = revisedItem[6];
                            title = revisedItem[1];
                        }
                        view.displaySuccessBanner("modified", item, title);
                    } 
                    break;
                    
                // REMOVE MEDIA OR LIBRARY   
                case 6:
                    view.displayLibrariesAndMedia(libraries, media);
                    String id = view.removeMediaOrLibrary(libraries, media);
                    if (id != null) {
                        if (id.length() == 3) {
                            Media removedItem = dao.removeMedia(id);
                            view.displaySuccessBanner("removed", removedItem.getFormat(), removedItem.getTitle());
                        } else {
                            Library removedLibrary = dao.removeLibrary(id);
                            view.displaySuccessBanner("removed", "library", removedLibrary.getName());
                        }
                    }
                    break;
                    
                case 7:
                    // CREATE NEW LIBRARY
                    Library newLibrary = view.createNewLibrary();
                    dao.addLibrary(newLibrary);
                    view.displaySuccessBanner("created", "library", newLibrary.getName());
                    break;
                
                // LIST LIBRARIES
                case 8:
                    view.displayLibraries(libraries);
                    break;
                case 9:
                    isRunning = false;
                    break;
                default:
                    view.print("UNKNOWN COMMAND");
            }
        }
        view.print("\nGOODBYE!");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private List<Library> getLibraryList() throws MediaLibraryPersistenceException {
        return dao.getAllLibraries();
    }

    private List<Media> getMediaList() throws MediaLibraryPersistenceException {
        return dao.getAllMedia();
    }
    
}
