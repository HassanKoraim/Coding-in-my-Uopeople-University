/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import javax.swing.JFileChooser;

/**
 *
 * @author f
 */
public class Sets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        try{
            // My words file
            File file = new File("C:/Users/f/OneDrive/Documents/NetBeansProjects/lab_9/src/lab_9/words.txt");
            Scanner filein = new Scanner(file);
            filein.useDelimiter("[^a-zA-Z]+");
            
            HashSet<String> uniqueLine = new HashSet<String>();
            while (filein.hasNextLine()) {
                String line = filein.nextLine();
                line = line.toLowerCase();
                uniqueLine.add(line);
                //System.out.println(line);     
            }
                    // Another File Word from user
            File fileFromUser = getInputFileNameFromUser();
            Scanner fileUser = new Scanner(fileFromUser);
            fileUser.useDelimiter("[^a-zA-Z]+");
            HashSet<String> uniqueLineUser = new HashSet<String>();
            while (fileUser.hasNextLine()) {
                String line = fileUser.nextLine();
                line = line.toLowerCase();
                uniqueLineUser.add(line);
                //System.out.println(line);   
            }
            // loop in the word file user to check if there are difference words
            for(String s : uniqueLineUser){
                if (! uniqueLine.contains(s)){
                    System.out.println(s);
                }
                    }
            //System.out.println(uniqueLine.size());
            filein.close();
//            for( String line : uniqueLine){
//                System.out.println(line);
//            }
        }catch(FileNotFoundException e){
            System.out.println("File not Found :"+ e.getMessage());
        }

    }
        static File getInputFileNameFromUser() {
           JFileChooser fileDialog = new JFileChooser();
           fileDialog.setDialogTitle("Select File for Input");
           int option = fileDialog.showOpenDialog(null);
           if (option != JFileChooser.APPROVE_OPTION)
              return null;
           else
              return fileDialog.getSelectedFile();
        }
        static TreeSet corrections(String badWord, HashSet Dictionary){
            
        }
    
}
