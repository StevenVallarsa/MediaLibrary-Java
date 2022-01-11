
package com.sv.medialibrary2022.controller;

import com.sv.medialibrary2022.ui.MediaLibraryView;
import com.sv.medialibrary2022.ui.UserIO;
import com.sv.medialibrary2022.ui.UserIOImpl;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: Work with user input 
 */
public class MediaLibraryController {
    
    private MediaLibraryView view = new MediaLibraryView();
    private UserIO io = new UserIOImpl();
    
    public void run() {
        boolean isRunning = true;
        int menuSelection = 0;
        
        while(isRunning) {
            
            menuSelection = getMenuSelection();
            
            switch(menuSelection) {
                case 1:
                    io.print("List Media & Libraries");
                    break;
                case 2:
                    io.print("Create Media");
                    break;
                case 3:
                    io.print("Create Library");
                    break;
                case 4:
                    io.print("View Specific Media");
                    break;
                case 5:
                    io.print("View Specific Library");
                    break;
                case 6:
                    io.print("Remove Media");
                    break;
                case 7:
                    io.print("Remove Library");
                    break;
                case 8:
                    isRunning = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        io.print("\nGOOD BYE!");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
}
