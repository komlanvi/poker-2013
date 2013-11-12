package net;

import java.net.*;
import java.io.*;
import java.util.*;

public class MyServer {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7777);
		} catch (IOException e) {
			System.err.println("Could not listen on port.");
			System.exit(1);
		}
		int c=0;
		while (true) {
			c++;
			Socket clientSocket = null;
			try {
				System.out.println("Server listnening");
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
					true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String inputLine;

			out.println("Server 1");

			while ((inputLine = in.readLine()) != null) {
				if (inputLine.equals("Bye."))
					break;
				Date now = new Date(System.currentTimeMillis());
				out.println(now + ": " + inputLine);
			}
			out.close();
			in.close();
			clientSocket.close();
			if(c==1){
				serverSocket.close();
				//System.out.println("Fine trasmissione");
				System.exit(0);
			}
		}
	}
}