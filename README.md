# Media Library App
- A mid-complexity media library app to keep track of books, tapes, CDs, DVDs, etc...
- It will start as a console app and new functionality with each iteration until it becomes a Java web app

### 1 - First Iteration will use a text file to store media objects -- BRANCH main
- Create a simple console app that will keep track of your media items with two entities: __media__ and __libraries__ and the following classes / interfaces
- MVC Pattern:
---
- MediaLibraryDAOFileImpl __M__
  - MediaLibraryDAO (INTERFACE)
- MediaLibraryView __V__
- MediaLibraryController __C__
  - UserIO (INTERFACE)
- UserIOImpl __V__
---
- Media __M__
- Library __M__
---
- MediaLibraryDAOException -> Exception (EXTENDS)
---
The project will start with these Packages and classes:
- com.sv.MediaLibrary
  - App.java
- com.sv.MediaLibrary.controller
  - MediaLibraryController.java
- com.sv.MediaLibrary.dao
  - _MediaLibraryDao.java (interface)_
  - MediaLibraryDaoFileImpl.java
com.sv.MediaLibrary.dto
  - Media.java
  - Library.java
- com.sv.MediaLibrary.ui
  - MediaLibraryView.java
  - _UserIO.java (interface)_
  - UserIOConsoleImpl.java

### 2 - Second Iteration will add a Service Layer -- BRANCH 2-service_layer
- add dependency injection
- add custom Exception class to encapsulate errors
  - MediaLibraryValidationException
    - if the "title" or "format" aren't filled out for the media
    - if the mediaIndex variable hits 999 and is now full
    - if the libraryIndex variable hits 99 and is now full 
- add persistance via text files
- add marshalling and unmarshalling to read and write to text files
- add service layer
  - error for missing title or format
  - add default values to empty input
  - alert user to a duplicate title and format for an item
  - record audit log for every transaction

### 3 - Third Iteration will add Unit Testing 
- added stateful unit testing to DAO with dummy text files
- added service layer unit testing with use of DAO stub implementation 

### 4 - Fourth Iteration will add Lambdas and Streams -- BRANCH 4-lambda branch

### 5 - Fifth Iteration will add Spring Boot for the dependency injection -- BRANCH 5-dependency_injection"

### 6 - Sixth Iteration will add a database to hold the library data -- BRANCH 6-database

### 7 - Seventh Iteration will add REST web connectivity -- BRANCH 7-rest

### 8 - Eighth Iteration will add ThymeLeaf to turn the Media Library into a full Java web application -- BRANCH 8-thymeleaf


