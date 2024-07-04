/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclient;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author f
 */
public class DataClient {

/**
* This program opens a connection to a computer specified
* as the first command-line argument. If no command-line
* argument is given, it prompts the user for a computer
* to connect to. The connection is made to
* the port specified by LISTENING PORT. The program reads one
* line of text from the connection and then closes the
* connection. It displays the text that it read on
* standard output. This program is meant to be used with
* the server program, DateServer, which sends the current
* date and time on the computer where the server is running.
*/

    public static final int LISTENING_PORT = 32007;
    public static void main(String[] args) {
        String hostName ;     // Name of the server computer to connect to.
        Socket connection;       // A socket for communicating with server.
        BufferedReader incoming;    // For reading data from the connection.
        
        /* Get computer name from command line. */
        if (args.length > 0 ){
            hostName = args[0];
        }else{
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Computer Name or IP address: ");
            hostName = scan.nextLine();
        }
        
        /* Make the connection, then read and display a line of text. */
        try{
            connection = new Socket(hostName , LISTENING_PORT);
            incoming = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String lineFromServer = incoming.readLine();
            if(lineFromServer == null){
                // A null from incoming.readLine() indicates that
                // end-of-stream was encountered.
                throw new IOException("Connection was opened, " +
                            "but server did not send any data.");
            }
            System.out.println();
            System.out.println(lineFromServer);
            System.out.println();
            incoming.close();
        }
         catch (Exception e){
             System.out.println("Error: " + e);
         }
    } // end main()
    
} //end class DateClient
