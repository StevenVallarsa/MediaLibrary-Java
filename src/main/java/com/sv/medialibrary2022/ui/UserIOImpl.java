
package com.sv.medialibrary2022.ui;

import java.util.Scanner;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-10
 * purpose: 
 */
public class UserIOImpl implements UserIO {
    
    Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String prompt) {
        System.err.println(prompt);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        
        while(true) {
            String input = readString(prompt);
            try {
                int inputInt = Integer.parseInt(input);
                return inputInt;
            } catch (Exception e) {
                print("That wasn't an integer. Try again.\n");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        
        while(true) {
            int input = readInt(prompt);
            if (input >= min && input <= max) {
                return input;
            } else {
                print("That wasn't between " + min + " and " + max + ". Please try again.");
            }
        }
    }
}
