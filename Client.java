import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.management.MonitorInfo;
import java.net.Socket;
import java.util.function.Consumer;

public class Client extends Thread{
	
	// Necessary Elements for client to run.
	private int PortNumber;
	private String IPaddress;
	public MorraInfo morrainfo;
	
	// HAs consumer to update in the scene.
	Consumer<String> P1Points;
	Consumer<String> P2Points;
	Consumer<String> P2Guess;
	
	//
	// Client constructor to be implemented
	// it initializes the necessry elements required
	// It also initializes the consumers.
	//
	public Client(int port, String ipa, Consumer<Serializable> data, Consumer<String> data2, Consumer<String> data3, Consumer<String> data4) {
		PortNumber = port;
		IPaddress = "127.0.0.1";
		morrainfo = new MorraInfo(data);
		P1Points = data2;
		P2Points = data3;
		P2Guess = data4;
	}

	// Client connection and socket elements,
	// input and output stream.
	Socket Connection;
	ObjectInputStream In;
	ObjectOutputStream Out;
	
	
	//
	// run method is a necessary emthod in order
	// to execute the thread, it initializes sockets and
	// streams with necessry elements.
	//
	public void run() {
		
		try {
			Connection = new Socket(IPaddress, PortNumber);
			In = new ObjectInputStream(Connection.getInputStream());
			Out = new ObjectOutputStream(Connection.getOutputStream());
			// Sets to tcp no delay as it will make transfer faster.
			Connection.setTcpNoDelay(true);
		} catch (Exception e) {
			// Print Stack if an exception is not found.
			e.printStackTrace();
		}
		
		// RUn till U catch an exception in the thread.
		while(true) {
			try {
				this.morrainfo = (MorraInfo) In.readObject();
				P1Points.accept(((Integer)morrainfo.getP1Points()).toString());
				P2Points.accept(((Integer)morrainfo.getP2Points()).toString());
				P2Guess.accept(((Integer)morrainfo.getP2Guess()).toString());
			} catch (Exception e) {
				break;
			}
		}
		
	}
	
	//
	// The method send the morraInfo in the
	// Socket to the server and also throws exceptions.
	//
	public void send(MorraInfo m){
		
		try {
			Out.writeObject(m);
		} catch (Exception e) {
			e.printStackTrace();
			// Mostly due to server not connected.
			System.out.println("Server Not Connected!");
		}
		
	}
	
	
}