/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directoryfile;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author f
 */
public class DirectoryFile {

/*
* This program lists the files in a directory specified by
* the user. The user is asked to type in a directory name.
* If the name entered by the user is not a directory, a
* message is printed and the program ends.
*/
    public static void main(String[] args) {
        // TODO code application logic here
        
// To Konow the current Directory 
//        String curr_directory = System.getProperty("user.dir");
//        System.out.println(curr_directory);
        listOfFilesInFile();
    }
        
    public static void listOfFilesInFile(){
        String directoryName;
        File directory;
        String[] files;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter The name of the directory");
        directoryName = scan.nextLine().trim();
        directory = new File(directoryName);
        if(! directory.isDirectory()){
            if(!directory.exists()){
                System.out.println("There is no such directory");
            }else{
                System.out.println("That file is not a directory");
            }
        }else{
            files = directory.list();
            System.out.println("Files in directory \"" + directory + "\":");
            for(int i = 0 ; i < files.length; i++){
                System.out.println("  " + files[i]);
            }
        }
    }
    
}
