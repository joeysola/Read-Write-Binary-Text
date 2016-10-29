/*
 * Name: Joey Solak
 * Date:
 * Class: CIT-130
 * Purpose Of The File:
 */
package rwbt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Joey Solak
 */
public class RWBT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        //Set Variables
        String name;
        String filename = "";
        String bort;
        String rorw;
        String info;
        String menu;
        String cont;
        final String BINARY = ".dat";
        final String TEXT = ".txt";
        
        
        
        //Ask for information
        Scanner keyboard = new Scanner(System.in);
        
        //Filename
        System.out.print("Enter the filename: ");
        name = keyboard.nextLine();
        System.out.println("");
        
        //Binary or Text
        System.out.print("Choose binary or text:(b/t)");
        bort = keyboard.nextLine();
        System.out.println("");
        
        if (bort.equals("b")){
            filename = name + BINARY;
        }
            else {
            filename = name + TEXT;
                    
                    }
            
        
        
        
        //Read or Write
        System.out.print("Choose read or write:(r/w)");
        rorw = keyboard.nextLine();
        System.out.println("");
        
        
        
        
        
        
        
        
       
        
        
        //Create and Write
        PrintWriter write = null;
        write = new PrintWriter(new FileOutputStream(filename));
        
        write.println("Write Line 1");
        write.println("Write Line 2");
        write.close();
        
    }
    
}
