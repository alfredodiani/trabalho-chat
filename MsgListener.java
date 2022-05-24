/*
	Trabalho CHAT
	Sistemas Distribuidos - GCC 129
	Universidade Federal de Lavras

	Data: 18/02/2022
*/

import java.io.*;
import java.net.*;
import java.lang.Thread;



public class MsgListener extends Thread{
	
	Socket echoSocket;


	public MsgListener(Socket s){
		echoSocket = s;
	}

	@Override
	public void run(){
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));	
			while(true){
				System.out.println("Received: " + in.readLine());			
			}
		}catch(IOException e){
			System.err.println("I/O Error");
			System.exit(1);
		}
					
	}
}
