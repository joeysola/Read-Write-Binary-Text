/*
 * Name: Joey Solak
 * Date:
 * Class: CIT-130
 * Purpose Of The File:
 */
package rwbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Joey Solak
 */
public class RWBT {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //Set Variables
        String name;
        String filename = "";
        String bort;
        String rorw;
        String info = "TESTING 1 2 3";
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
        
        
        //DECISION TREE
        
        //IF READ AND TEXT
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
        
        
        //IF WRITE AND TEXT
        else if (rorw.equalsIgnoreCase("W") && bort.equalsIgnoreCase("T")){
            
            do {
            //Enter Information
            System.out.print("Enter a line of information to write: ");
            info = keyboard.nextLine();
            menu = "Y";

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
        
        //IF WRITE AND BINARY
        else if(rorw.equalsIgnoreCase("W") && bort.equalsIgnoreCase("B") ){
        
            do {
            //Enter Information
            System.out.print("Enter a line of information to write: ");
            info = keyboard.nextLine();
            menu = "Y";
            
            //Write Binary File
        
        DataOutputStream bWrite = null;
        
        try{
            bWrite =
                new DataOutputStream(new FileOutputStream(filename, true));
            }
            catch (IOException e){
                System.out.println("Error opening your file. The program will now exit.");
                System.exit(0);    
            }

            bWrite.writeUTF(info);//Write to Text File
            //bWrite.close();
            
            System.out.print("Would you like to enter another line?(y/n) ");
            menu = keyboard.nextLine();
    
            } while (menu.equalsIgnoreCase("Y"));
        }
            
        //IF READ AND BINARY
        else if(rorw.equalsIgnoreCase("R") && bort.equalsIgnoreCase("B")){
         
        //Read Binary File
         String bOutput = "BLAH";
         DataInputStream bRead;
        
         
         try{
             bRead = new DataInputStream(new FileInputStream(filename));
           try{ 
            while (bRead.available()>0){
             bOutput = bRead.readUTF();
             System.out.println(bOutput);
            }
           }
             catch(EOFException e){
                    System.out.println("No more lines in the file.");
                    }bRead.close();
         }
         
         catch (FileNotFoundException e){
             System.out.println("Error opening your file. The program will now exit.");
             System.exit(0);
             
         } 
                }

          System.out.print("\nWould you like to continue the program?(y/n) ");
            cont = keyboard.nextLine(); 
            
        } while(cont.equalsIgnoreCase("Y"));

         }
         
    }

