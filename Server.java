/*
	Trabalho CHAT
	Sistemas Distribuidos - GCC 129
	Universidade Federal de Lavras
	
	Data: 18/02/2022
*/

import java.net.*;
import java.io.*;
import java.lang.Thread;


public class Server
{
	 public static void main(String[] args) throws IOException {
		 
		ServerSocket serverSocket = null;
			 int porta = 3000;

		try {
			 serverSocket = new ServerSocket(porta);
			}
		catch (IOException e)
			{
			 System.err.println("Could not listen on port: " + porta);
			 System.exit(1);
			}

		Socket clientSocket = null;
		System.out.println ("Waiting for connection.....");

		try {
			 clientSocket = serverSocket.accept();
		}
		catch (IOException e){
			 System.err.println("Accept failed.");
			 System.exit(1);
		}

		System.out.println ("Connection successful");
		System.out.println ("Waiting for input.....");




		MsgWriter escritor = new MsgWriter(clientSocket);
		MsgListener escutador = new MsgListener(clientSocket);

		escritor.start();
		escutador.start();
		
		try{
			escritor.join();
			escutador.join();
		}catch(InterruptedException e){
			System.err.println("Exception thrown in .join() function of Thread");
			System.exit(1);
		}
		
		clientSocket.close();
		serverSocket.close();
	}
}
