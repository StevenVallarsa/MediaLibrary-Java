
package com.sv.medialibrary2022.servicelayer;

import com.sv.medialibrary2022.dao.MediaLibraryPersistenceException;
import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.util.List;

/**
 *
 * @author StevePro
 */
public interface ServiceLayer {
    boolean checkForDuplicates(List<Media> media, Media item);
    void createMedia(Media media) throws MediaLibraryValidationException, MediaLibraryPersistenceException;
    void createLibrary(Library library) throws MediaLibraryValidationException, MediaLibraryPersistenceException;
    List<Media> findMedia(String search);
    void modifyLibrary(String[] libraryArray);
    void modifyMedia(String[] mediaArray);
    Media removeMedia(String id) throws MediaLibraryPersistenceException;
    Library removeLibrary(String id);
    List<Library> getAllLibraries();
    List<Media> getAllMedia();
}
