
package com.sv.medialibrary2022;

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
        
        // TESTING UserIO
        
        UserIO io = new UserIOImpl();
        
        io.print("Print");
        
        String string = io.readString("readString");
        io.print("You typed in this string: " + string);
        
        int num = io.readInt("readInt:");
        io.print("You typed in this int: " + num);
        
        int numMinMax = io.readInt("readIntMinMax:", 0, 10);
        io.print("You typed in this int between 0 and 10: " + numMinMax);
        
    }
}
