
package com.sv.medialibrary2022.dao;

import com.sv.medialibrary2022.dto.Library;
import com.sv.medialibrary2022.dto.Media;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */

@Component
public class MediaLibraryDaoImpl implements MediaLibraryDao {
    
    private Map<String, Media> media = new HashMap<>();
    private Map<String, Library> libraries = new HashMap<>();
    
    private int mediaIndex = 100;
    private int libraryIndex = 10;
    
    public final String LIBRARY_FILE;
    public final String MEDIA_FILE;
    public static final String DELIMITER = "::";
    
    public MediaLibraryDaoImpl() throws MediaLibraryPersistenceException {
        this("library.txt", "media.txt");
    }
    
    public MediaLibraryDaoImpl(String libraryFile, String mediaFile) throws MediaLibraryPersistenceException {
        LIBRARY_FILE = libraryFile;
        MEDIA_FILE = mediaFile;
        loadLibrary();
        loadMedia();
    }

    @Override
    public List<Media> getAllMedia() {
        return new ArrayList<Media>(media.values());
    }

    @Override
    public List<Library> getAllLibraries() {
        return new ArrayList<Library>(libraries.values());
    }

    @Override
    public Media addMedia(Media mediaItem) throws MediaLibraryPersistenceException {
        mediaItem.setMediaID(String.valueOf(mediaIndex++));
        Media prevMedia = media.put(mediaItem.getMediaID(), mediaItem);
        writeMedia();
        return prevMedia;
    }

    @Override
    public Library addLibrary(Library libraryItem) throws MediaLibraryPersistenceException {
        libraryItem.setLibraryID(String.valueOf(libraryIndex++));
        Library prevLibrary = libraries.put(libraryItem.getLibraryID(), libraryItem);
        writeLibrary();
        return prevLibrary;
    }

    @Override
    public List<Media> findMedia(String searchTerm) {
        List<Media> media = getAllMedia();
        List<Media> results = new ArrayList<>();
        searchTerm = searchTerm.toLowerCase();
        for (Media m : media) {
            if (m.getMediaID().contains(searchTerm) 
                    || m.getTitle().toLowerCase().contains(searchTerm)
                    || m.getDescription().toLowerCase().contains(searchTerm)
                    || m.getCreator().toLowerCase().contains(searchTerm)
                    || m.getFormat().toLowerCase().contains(searchTerm)
                    || m.getYear().contains(searchTerm)
                    || m.getFormat().toLowerCase().contains(searchTerm)
                    || m.getGenre().toLowerCase().contains(searchTerm)) {
                results.add(m);
            }
        }
        return results;
    }

    @Override
    public Library getLibrary(String libraryID) {
        return libraries.get(libraryID);
    }

    @Override
    public Media removeMedia(String mediaID) throws MediaLibraryPersistenceException {
        Media removedMedia = media.remove(mediaID);
        writeMedia();
        return removedMedia;
    }

    @Override
    public Library removeLibrary(String libraryID) throws MediaLibraryPersistenceException {
        Library removedLibrary = libraries.remove(libraryID);
        writeMedia();
        writeLibrary();
        return removedLibrary;
    }

    @Override
    public void modifyMedia(Media m) throws MediaLibraryPersistenceException {
        media.put(m.getMediaID(), m);
        writeMedia();
    }
    
    @Override
    public void modifyLibrary(Library l) throws MediaLibraryPersistenceException {
        libraries.put(l.getLibraryID(), l);
        writeLibrary();
    }





    private Library unmarshallLibrary(String libraryAsText) {
        String[] libraryTokens = libraryAsText.split(DELIMITER);
        
        Library libraryFromFile = new Library(libraryTokens[0]);
        libraryFromFile.setName(libraryTokens[1]);
        libraryFromFile.setLocation(libraryTokens[2]);
        libraryFromFile.setDescription(libraryTokens[3]);
        
        return libraryFromFile;
    }
    
    private Media unmarshallMedia(String mediaAsText) {
        String[] mediaTokens = mediaAsText.split(DELIMITER);
        
        Media mediaFromFile = new Media(mediaTokens[0]);
        mediaFromFile.setTitle(mediaTokens[1]);
        mediaFromFile.setCreator(mediaTokens[2]);
        mediaFromFile.setDescription(mediaTokens[3]);
        mediaFromFile.setYear(mediaTokens[4]);
        mediaFromFile.setGenre(mediaTokens[5]);
        mediaFromFile.setFormat(mediaTokens[6]);
        mediaFromFile.setLibrary(mediaTokens[7]);
        
        return mediaFromFile;
    }
    
    
    
    
    private void loadLibrary() throws MediaLibraryPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new MediaLibraryPersistenceException("Could not load library into memory.", e);
        }
        
        libraryIndex = Integer.parseInt(scanner.nextLine());
        
        Library currentLibrary;
        
        while (scanner.hasNextLine()) {
            currentLibrary = unmarshallLibrary(scanner.nextLine());
            libraries.put(currentLibrary.getLibraryID(), currentLibrary);
        }
        scanner.close();
    }
    
    private void loadMedia() throws MediaLibraryPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(MEDIA_FILE)));
        } catch (IOException e) {
            throw new MediaLibraryPersistenceException("Cound not load media data into memory", e);
        }
        
        Media currentMedia;
        
        mediaIndex = Integer.parseInt(scanner.nextLine());
        
        while (scanner.hasNext()) {
            currentMedia = unmarshallMedia(scanner.nextLine());
            media.put(currentMedia.getMediaID(), currentMedia);
        }
        scanner.close();
    }
    
    
    
    private String marshallLibrary(Library library) {
        String libraryAsText = library.getLibraryID() + DELIMITER;
        libraryAsText += library.getName() + DELIMITER;
        libraryAsText += library.getLocation() + DELIMITER;
        libraryAsText += library.getDescription();
        return libraryAsText;
    }
    
    private String marshallMedia(Media m) {
        String mediaAsText = m.getMediaID() + DELIMITER;
        mediaAsText += m.getTitle() + DELIMITER;
        mediaAsText += m.getCreator() + DELIMITER;
        mediaAsText += m.getDescription() + DELIMITER;
        mediaAsText += m.getYear() + DELIMITER;
        mediaAsText += m.getGenre() + DELIMITER;
        mediaAsText += m.getFormat() + DELIMITER;
        mediaAsText += m.getLibrary();
        return mediaAsText;
    }
    
    
    
    private void writeLibrary() throws MediaLibraryPersistenceException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new MediaLibraryPersistenceException("Could not save library data.", e);
        }
        
        out.println(String.valueOf(libraryIndex));
        libraries.values().stream().forEach(l -> {
            String libraryAsText = marshallLibrary(l);
            out.println(libraryAsText);
            out.flush();
        });
        out.close();
    }
    
    private void writeMedia() throws MediaLibraryPersistenceException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(MEDIA_FILE));
        } catch (IOException e) {
            throw new MediaLibraryPersistenceException("Could not save media data.", e);
        }
        out.println(String.valueOf(mediaIndex));
        media.values().stream().forEach(m -> {
            String mediaAsText = marshallMedia(m);
            out.println(mediaAsText);
            out.flush();
        });
        out.close();
    }
}
