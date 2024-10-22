/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateserver;
import java.io.PrintWriter;
import java.net.*;
import java.util.Date;
/**
 *
 * @author f
 */
public class DateServer {

/**
 * This program is a server that takes connection requests on
 * the port specified by the constant LISTENING_PORT.  When a
 * connection is opened, the program sends the current time to
 * the connected socket.  The program will continue to receive
 * and process connections until it is killed (by a CONTROL-C,
 * for example).  Note that this server processes each connection
 * as it is received, rather than creating a separate thread
 * to process the connection.
 */
    
    
    public static final int LISTENING_PORT = 32007;
    
    public static void main(String[] args) {
        ServerSocket listner; // Listens for incoming connections.
        Socket connection;    // For communication with the connecting program.
        
         /* Accept and process connections forever, or until some error occurs.
           (Note that errors that occur while communicating with a connected 
           program are caught and handled in the sendDate() routine, so
           they will not crash the server.) */
        try{
            listner = new ServerSocket(LISTENING_PORT);
            System.out.println("Listening on port " + LISTENING_PORT);
            while(true){
                connection = listner.accept();
                sendDate(connection);
            }
        }catch(Exception e){
            System.out.println("Sorry, the server has shut down.");
            System.out.println("Error:  " + e);
            return;
        }
           
    } // end main method
    /**
     * The parameter, client, is a socket that is already connected to another 
     * program.  Get an output stream for the connection, send the current time, 
     * and close the connection.
     */
    
    private static void sendDate(Socket client){
        try{
            Date now = new Date();
            PrintWriter outgoing;
            outgoing = new PrintWriter(client.getOutputStream());
            outgoing.println(now.toString());
            outgoing.flush();
            outgoing.close();
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }  // end sendDate()
    
    
}   //end class DateServer
