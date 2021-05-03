import java.io.*;
import java.net.*;

public class Chatterbox {

	private static DataOutputStream output;
	private static DataInputStream input;
	private static int PORT_NUMBER = 8000; //server connecten

	public static void main(String[] args) {

		// Chatterbox erstellen 
		//Chatterbox starten(serversocker erstellen)
		//warte auf client
		//set up streams 
		//lasse echo in einer schleife laufen
		

		try {
			ServerSocket ss = new ServerSocket(PORT_NUMBER);
			Socket s = ss.accept();
			input = new DataInputStream(s.getInputStream());
			output = new DataOutputStream(s.getOutputStream());
			//String str = (String)input.readUTF();
			//System.out.println("Client Says = " + str);
			if(input !=null) { echo();}
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void echo() throws IOException{
		String message = readMessage();
		writeMessage(message);
	}
	private static String readMessage() throws IOException {
		String str = (String)input.readUTF();
		return str;
	}	
	private static void writeMessage(String line) {
		try {
			
			output.writeUTF(line);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		
}