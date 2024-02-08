
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Server {
	
	private int PortNumber;  // port number for server
	private int Players;  // number of clients in the game
	private ArrayList<ClientThread> Clients;  // array list containing clientthreads
	private ServerThread MainServer;  // for starting ServerThread  
	public MorraInfo MI_Server;  // for morraInfo's instance
	
	// Server() constructor that has consumer and portnumber
	public Server(Consumer<Serializable> data, int pn) {
		// initializes the variables
		PortNumber = pn;
		Players = 1;
		Clients = new ArrayList<ClientThread>();
		MainServer = new ServerThread();
		MainServer.start();
		MI_Server = new MorraInfo(data);
	}
	
	public class ServerThread extends Thread {
		
		public void run() {
			try(ServerSocket mySocket = new ServerSocket(PortNumber)){
				System.out.println("Server is waiting for the Players!");
				MI_Server.callback.accept("Server is waiting for the Players!");
				
				while(true) {
					// Describes actions from Player 1
					ClientThread c1 = new ClientThread(mySocket.accept(), Players);
					System.out.println("Player #" + Players + " has connected.");
					System.out.println("Player #" + Players + " is waiting for another Player!");
					MI_Server.callback.accept("Player #" + Players + " has connected.");
					MI_Server.callback.accept("Player #" + Players + " is waiting for another Player!");
					// Describes actions from Player 2
					ClientThread c2 = new ClientThread(mySocket.accept(), Players+1);
					System.out.println("Player #" + (Players+1) + " has connected.");
					System.out.println("Player #" + Players + " and Player #" + (Players+1) + " are now playing.");
					MI_Server.callback.accept("Player #" + (Players+1) + " has connected.");
					MI_Server.callback.accept("Player #" + Players + " and Player #" + (Players+1) + " are now playing.");
					
					// adds client threads for player 1 and 2 to Clients arraylist
					
					Clients.add(c1);
					c1.start();
					Clients.add(c2);
					c2.start();
					Players += 2;
				}
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Serveer unable to lauch!!");
			}
		}
		
	}

  //
  // Clienthread class to make thread for eacha nd
  // individual client.
  //
	public class ClientThread extends Thread{
		Socket SC1; // socket connection
		int Players = 1;

    // Streams to transfer data.
		ObjectInputStream In1;
		ObjectOutputStream Out1;
		
		// ClientThread's constructor
		public ClientThread(Socket sock, int clientNumbers) {
			this.SC1 = sock;
			this.Players = clientNumbers;
		}

    //
    // ManageClient to 
    // 
		public void manageClients(MorraInfo mi) {
			for(int i = 0; i < Clients.size(); i++) {
				ClientThread ct = Clients.get(i);
				try
				{
					ct.Out1.writeObject(mi);
				}
				catch(Exception e) {}
			}
		}

    //
    // The method is necessary for the implementation of threads.
    // It initializes the streams and also catches exceptions.
    // It also listens for the input from the client.
    //
		public void run() {
			
			try {
				In1 = new ObjectInputStream(SC1.getInputStream());
				Out1 = new ObjectOutputStream(SC1.getOutputStream());
				// TO make the tranfer of data faster.
        SC1.setTcpNoDelay(true);
				MI_Server.clientList.add(1);
				manageClients(MI_Server);
				
			} catch (Exception e) {
				System.out.println("Streams unavailable!!");
			}
			
			while(true) {
				try 
				{
					MorraInfo p1MI = (MorraInfo)In1.readObject();
					MI_Server = p1MI;
					manageClients(MI_Server);
          // Sets the transfer fatser.
					SC1.setTcpNoDelay(true);
				}
				catch(Exception e) {
					MI_Server.Has2Players = false;
					manageClients(MI_Server);
					Clients.remove(this);
					System.out.println("Client has left!");
					break;
				}
				
			}
		}
		
	}
	
}	