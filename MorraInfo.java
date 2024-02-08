import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Consumer;

public class MorraInfo implements Serializable{
	
	// private Elements
	public int P1;
	public int P2;
	public int P1_Points;
	public int P2_Points;
	public int P1_Guess;
	public int P2_Guess;
	public String P1_Play;
	public String P2_Play;
	public boolean Has2Players;
	ArrayList<Integer> clientList = new ArrayList<Integer>();
	Consumer<Serializable> callback;
	
	//
	// public constructor that sets 
	// variables to default values.
	// 
	public MorraInfo(Consumer<Serializable> data) {
		P1 = 0;
		P2 = 0;
		P1_Points = -1;
		P2_Points = -1;
		P1_Guess = -1;
		P2_Guess = -1;
		P1_Play = "";
		P2_Play = "";
		Has2Players = false;
		callback = data;
	}
	
	//
	// Getters for Variables.
	//
	public int getP1() {
		return P1;
	}
	public int getP2() {
		return P2;
	}
	public int getP1Points() {
		return P1_Points;
	}
	public int getP2Points() {
		return P2_Points;
	}
	public int getP1Guess() {
		return this.P1_Guess;
	}
	public int getP2Guess() {
		return this.P2_Guess;
	}
	public String getP1Play() {
		return P1_Play;
	}
	
	public String getP2Play() {
		return P2_Play;
	}
	
	public boolean AreThere2Players() {
		return Has2Players;
	}
	
	//
	// Setters for Variables.
	// Sets p1.
	public void setP1(int p1) {
		this.P1 = p1;
	}

  // Sets P2.
	public void setP2(int p2) {
		this.P2 = p2;
	}

  // Sets p1 Guess.
	public void setP1Guess(int p1) {
		this.P1_Guess = p1;
	}

  // Sets P2 Guess.
	public void setP2Guess(int p2) {
		this.P2_Guess = p2;
	}

  // Sets P1 Points
	public void setP1Points(int p1) {
		P1_Points = p1;
	}

  // Sets the P2Points.
	public void setP2Points(int p2) {
		P2_Points = p2;
	}

  // Sets the P1 Play.
	public void setP1Play(String p1) {
		P1_Play = p1;
	}

  // Sets the p2 Play.
	public void setP2Play(String p2) {
		P2_Play = p2;
	}

  // Sets the boolean to p.
	public void setHas2Players(boolean p) {
		Has2Players = p;
	}
}