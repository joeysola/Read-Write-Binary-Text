/*
 * Name: Joey Solak
 * Date:
 * Class: CIT-130
 * Purpose Of The File:
 */
package rwbt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Joey Solak
 */
public class RWBT {

    public static void main(String[] args) throws FileNotFoundException {
        
        //Set Variables
        String name;
        String filename = "";
        String bort;
        String rorw;
        String info;
        String menu = "Y";
        String cont = "Y";
        final String BINARY = ".dat";
        final String TEXT = ".txt";
        
        
        do{
            
        
        //Ask for information
        Scanner keyboard = new Scanner(System.in);
        
        //Filename
        System.out.print("Enter the filename: ");
        name = keyboard.nextLine();
        
        
        //Binary or Text
        System.out.print("Choose binary or text:(b/t) ");
        bort = keyboard.nextLine();
        
        if (bort.equals("b")){
            filename = name + BINARY;
        }
            else {
            filename = name + TEXT;
        }
        
        //Read or Write
        System.out.print("Choose read or write:(r/w) ");
        rorw = keyboard.nextLine();
        
        
        //Decision Time
        
        if (rorw.equalsIgnoreCase("R") && bort.equalsIgnoreCase("T")){
        
            //Read from Text File
            Scanner read = null;
            PrintWriter rw = null;
            
            try{
            read = new Scanner(new FileInputStream(filename));
            rw = new PrintWriter(new FileOutputStream(filename, true));
            }
            catch (FileNotFoundException e){
                System.out.println("Error opening your file. The program will now exit.");
                System.exit(0);
            }
        
            //Scan through lines of text file
            String line = null;
            int count = 0;
            System.out.println("File contains:");
            while (read.hasNextLine()){
                line = read.nextLine();
                count++;
                rw.println(count + " " + line);
                System.out.println(line); //Display 
            }
            read.close(); //Close
            } 
        
        
        
        else if (rorw.equalsIgnoreCase("W") && bort.equalsIgnoreCase("T")){
            
            do {
            //Enter Information
            System.out.print("Enter a line of information to write: ");
            info = keyboard.nextLine();


            //Create and Write Text
            PrintWriter write = null;

            try{
            write = new PrintWriter(new FileOutputStream(filename, true));
            }
            catch (FileNotFoundException e){
                System.out.println("Error opening your file. The program will now exit.");
                System.exit(0);    
            }

            write.println(info);//Write to Text File
            write.close();//Close 
            
            System.out.print("Would you like to enter another line?(y/n) ");
            menu = keyboard.nextLine();
            
            } while (menu.equalsIgnoreCase("Y"));

                      
            }
            
        
            System.out.print("\nWould you like to continue the program?(y/n) ");
            cont = keyboard.nextLine();
            
        } while(cont.equalsIgnoreCase("Y"));
        
        
      }
    }
    

