# Media Library App
- A mid-complexity media library app to keep track of books, tapes, CDs, DVDs, etc...
- It will start as a console app and new functionality with each iteration until it becomes a Java web app

### 1 - First Iteration will use a text file to store media objects ("main" branch)
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

### 2 - Second Iteration will add a Service Layer ("2 service layer" branch)

### 3 - Third Iteration will add Unit Testing ("3 unit testing" branch)

### 4 - Fourth Iteration will add Lambdas and Streams ("4 lambda branch")

### 5 - Fifth Iteration will add Spring Boot for the dependency injection ("5 dependency injection" branch)

### 6 - Sixth Iteration will add a database to hold the library data ("6 database" branch)

### 7 - Seventh Iteration will add REST web connectivity ("7 rest" branch)

### 8 - Eighth Iteration will add ThymeLeaf to turn the Media Library into a full Java web application ("8 thymeleaf" branch)

