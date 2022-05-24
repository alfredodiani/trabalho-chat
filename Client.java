/*
	Trabalho CHAT
	Sistemas Distribuidos - GCC 129
	Universidade Federal de Lavras

	Data: 18/02/2022
*/

import java.io.*;
import java.net.*;
import java.lang.Thread;

public class Client {
    
	public static void main(String[] args) throws IOException {

        String serverHostname = new String ("localhost");
		int porta = 3000;

		System.out.println ("Attemping to connect to host " + serverHostname + " on port " + porta + ".");

        Socket echoSocket = null;
        
        
        try {
            echoSocket = new Socket(serverHostname, porta );
		} catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
		} catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
            System.exit(1);
		}



	MsgWriter escritor = new MsgWriter(echoSocket);
	MsgListener escutador = new MsgListener(echoSocket);

	escritor.start();
	escutador.start();
	
	try{
		escritor.join();
		escutador.join();
	}catch(InterruptedException e){
		System.err.println("Exception thrown in .join() function of Thread");
		System.exit(1);
	}


	echoSocket.close();
    }
}
