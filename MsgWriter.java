/*
	Trabalho CHAT
	Sistemas Distribuidos - GCC 129
	Universidade Federal de Lavras

	Data: 18/02/2022
*/

import java.io.*;
import java.net.*;
import java.lang.Thread;



public class MsgWriter extends Thread{
	
	Socket echoSocket;	
	

	public MsgWriter(Socket s){
		echoSocket = s;
	}


	@Override
	public void run(){
		try{
			PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;
		
			System.out.println ("Chat Ready! ");	

			while ((userInput = stdIn.readLine()) != null){
				out.println(userInput);
			}
		}catch(IOException e){
				System.err.println("I/O Error");
				System.exit(1);
		}
		
	}
}
