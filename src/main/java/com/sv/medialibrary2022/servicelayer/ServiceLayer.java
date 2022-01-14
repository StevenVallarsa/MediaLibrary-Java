
package com.sv.medialibrary2022.servicelayer;

import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.util.List;

/**
 *
 * @author StevePro
 */
public interface ServiceLayer {
    boolean checkForDuplicates(List<Media> media, Media item);
    void createMedia(Media media) throws MediaLibraryValidationException;
    void createLibrary(Library library) throws MediaLibraryValidationException;
    List<Media> findMedia(String search);
    void modifyLibrary(String[] libraryArray);
    void modifyMedia(String[] mediaArray);
    Media deleteMedia(String id);
    Library deleteLibrary(String id);
    List<Library> getAllLibraries();
    List<Media> getAllMedia();
    
    
    
    
}
