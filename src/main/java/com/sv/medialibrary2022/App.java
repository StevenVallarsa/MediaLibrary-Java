
package com.sv.medialibrary2022;

import com.sv.medialibrary2022.controller.MediaLibraryController;
import com.sv.medialibrary2022.ui.UserIO;
import com.sv.medialibrary2022.ui.UserIOImpl;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: Console app to keep track of media (books, tapes, CDs, DVDs, etc...)
 *          using CRUD MVC pattern
 */
public class App {
    public static void main(String[] args) {
        
        MediaLibraryController controller = new MediaLibraryController();
        controller.run();
    }
}
