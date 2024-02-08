import java.io.FileInputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {

	// Main Scene.
	private Scene MainScene;
	
	//Scene 1 Elements
	private Label PortLabel;
	private TextField PortTextField;
	private Label IPALabel;
	private TextField IPATextField;
	private Button ConnecTButton;
	private HBox portHBox;
	private HBox ipaHBox;
	private VBox mainPack;
	private BorderPane startPane;
	
	//Scene 2 Elements
	private TextField ServerMessage;
	private TextField P1PointsField;
	private TextField P2PointsField;
	private TextField P2GuessField;
	private Label P1PointsLabel;
	private Label P2PointsLabel;
	private Label P2GuessLabel;
	private Text SelctnumText;
	private Text SelectGuessText;
	
	private HBox Box1Section2;
	private HBox Box2Section2;
	private HBox Box3Section2;
	private VBox Box_TwoandThree;
	private HBox MainBoxSection2;
	
	private Image ImageZero;
	private Image ImageOne;
	private Image ImageTwo;
	private Image ImageThree;
	private Image ImageFour;
	private Image ImageFive;
	
	private ImageView IVOne;
	private ImageView IVTwo;
	private ImageView IVThree;
	private ImageView IVFour;
	private ImageView IVFive;
	private ImageView IVZero;
	
	private Label LBZero;
	private Label LBOne;
	private Label LBTwo;
	private Label LBThree;
	private Label LBFour;
	private Label LBFive;
	
	private VBox LBIM0;
	private VBox LBIM1;
	private VBox LBIM2;
	private VBox LBIM3;
	private VBox LBIM4;
	private VBox LBIM5;
	
	private RadioButton RB0;
	private RadioButton RB1;
	private RadioButton RB2;
	private RadioButton RB3;
	private RadioButton RB4;
	private RadioButton RB5;
	private RadioButton RB6;
	private RadioButton RB7;
	private RadioButton RB8;
	private RadioButton RB9;
	private RadioButton RB10;
	
	private HBox ImageBox;
	private HBox RadioButtonBox;
	
	private VBox MainBox;
	
	private Stage MainStage;
	
	private Client C;
	
	// Scene 3 Elements
	private Button playAgain;
	private Button quit;
	private Scene EndScene;
	private VBox endHBox;
	private BorderPane endPane;
	
	int numClients = 0;
	ListView<String> gameUpdate;
	boolean hasOpponent = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to JavaFX");
		
		this.InitializeIntroSceneElems();
		this.InitialiseEndSceneElems();
		this.InitialisePlaySceneElements();
		
		// Setting the stage and start Scene.
		primaryStage.setScene(this.GetIntroScene());
		primaryStage.show();
		
		// Event Handler for Intro Scene.
		PortTextField.textProperty().isNotEmpty().addListener(tf->{
			IPATextField.textProperty().isNotEmpty().addListener(i->{
				ConnecTButton.setDisable(false);
			});
		});
		
		ConnecTButton.setOnAction(cb -> {
			primaryStage.setScene(this.GetGamePlayScene());
			String ipAddress = IPATextField.getText();
			int portNumber = Integer.parseInt(PortTextField.getText());
			C = new Client(portNumber, ipAddress, data -> {
				Platform.runLater( () -> {
					ServerMessage.setText(data.toString());
				});
			}, data2 -> {
				Platform.runLater( () -> {
					P1PointsField.setText(data2.toString());
				});
			}, data3 -> {
				Platform.runLater( () -> {
					P2PointsField.setText(data3.toString());
				});
			}, data4 -> {
				Platform.runLater( () -> {
					P2GuessField.setText(data4.toString());
				});
			});
			primaryStage.show();
			C.start();
		});
		
		LBIM0.setOnMouseClicked(e -> {
			C.morrainfo.setP1Play("Zero");
			this.DisableClickableImages(true);
			this.setRadioButtonAbility(false);
		});
		
		LBIM1.setOnMouseClicked(e -> {
			C.morrainfo.setP1Play("One");
			this.DisableClickableImages(true);
			this.setRadioButtonAbility(false);
		});
		
		LBIM2.setOnMouseClicked(e -> {
			C.morrainfo.setP1Play("Two");
			this.DisableClickableImages(true);
			this.setRadioButtonAbility(false);
		});
		
		LBIM3.setOnMouseClicked(e -> {
			C.morrainfo.setP1Play("Three");
			this.DisableClickableImages(true);
			this.setRadioButtonAbility(false);
		});
		
		LBIM4.setOnMouseClicked(e -> {
			C.morrainfo.setP1Play("Four");
			this.DisableClickableImages(true);
			this.setRadioButtonAbility(false);
		});
		
		LBIM5.setOnMouseClicked(e -> {
			C.morrainfo.setP1Play("Five");
			this.DisableClickableImages(true);
			this.setRadioButtonAbility(false);
		});
		
		// EVent Handlers for radio Button.
		RB0.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(0);
			C.send(C.morrainfo);
		});
		
		RB1.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(1);
			C.send(C.morrainfo);
		});
		
		RB2.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(2);
			C.send(C.morrainfo);
		});
		
		RB3.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(3);
			C.send(C.morrainfo);
		});
		
		RB4.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(4);
			C.send(C.morrainfo);
		});
		
		RB5.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(5);
			C.send(C.morrainfo);
		});
		
		RB6.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(6);
			C.send(C.morrainfo);
		});
		
		RB7.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(7);
			C.send(C.morrainfo);
		});
		
		RB8.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(8);
			C.send(C.morrainfo);
		});
		
		RB9.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(9);
			C.send(C.morrainfo);
		});
		
		RB10.setOnAction(e -> {
			this.setRadioButtonAbility(true);
			C.morrainfo.setP1Guess(10);
			C.send(C.morrainfo);
		});
	}
	
	public void DisableClickableImages(boolean x) {
		LBIM0.setDisable(x);
		LBIM1.setDisable(x);
		LBIM2.setDisable(x);
		LBIM3.setDisable(x);
		LBIM4.setDisable(x);
		LBIM5.setDisable(x);
	}
	
	public void InitializeIntroSceneElems() {
		// Initialising elements;
		PortLabel = new Label("PORT NUMBER:");
		PortLabel.setStyle("-fx-font-family: SansSerif;");
		
		IPALabel = new Label("IP ADDRESS:");
		IPALabel.setStyle("-fx-font-family: SansSerif;");
		
		PortTextField = new TextField();
		PortTextField.setPromptText("Enter Port Number");
		PortTextField.setStyle("-fx-font-family: SansSerif;");
		
		IPATextField = new TextField();
		IPATextField.setPromptText("Enter IP Address");
		IPATextField.setStyle("-fx-font-family: SansSerif;");
		
		portHBox = new HBox(15, PortLabel, PortTextField);
		ipaHBox = new HBox(15, IPALabel, IPATextField);
		
		ConnecTButton = new Button("CONNECT!");
		ConnecTButton.setDisable(false);
		ConnecTButton.setStyle("-fx-font-family: SansSerif;");
		
		mainPack = new VBox(15, portHBox, ipaHBox, ConnecTButton);
		
		startPane = new BorderPane(mainPack, null, null, null, null);
		startPane.setPadding(new Insets(150));
	}
	
	public Scene GetIntroScene() {
		MainScene = new Scene(startPane, 500, 500);
		return MainScene;
	}
	
	public void InitialiseEndSceneElems() {
		// Initializing the Variable.
		playAgain = new Button("Play Again");
		
		quit = new Button("Quit");
		
		endHBox = new VBox(15, playAgain, quit);
		
		endPane = new BorderPane(endHBox, null, null, null, null);
		endPane.setPadding(new Insets(150));	
	}
	
	public Scene GetEndDecision() {
		EndScene = new Scene(endPane, 500,500);
		return EndScene;
	}
	
	public void InitialisePlaySceneElements() {
		//Initializing the elements.

		// Initializing the ServerMessage. and VBox elemenst 1.
		ServerMessage = new TextField();
		ServerMessage.setEditable(false);
		ServerMessage.setText("Server Updates!");
		ServerMessage.setStyle("-fx-font-family: SansSerif;");
		
		// Initializing the VBox element section2.
		P1PointsField = new TextField();
		P1PointsField.setText("0");
		P1PointsField.setStyle("-fx-font-family: SansSerif;");
		P1PointsField.setEditable(false);
		
		P2PointsField = new TextField();
		P2PointsField.setText("0");
		P2PointsField.setStyle("-fx-font-family: SansSerif;");
		P2PointsField.setEditable(false);
		
		P2GuessField = new TextField();
		P2GuessField.setText("-");
		P2GuessField.setStyle("-fx-font-family: SansSerif;");
		P2GuessField.setEditable(false);
		
		P1PointsLabel = new Label("Player 1 Points:");
		P1PointsLabel.setStyle("-fx-font-family: SansSerif;");
		
		P2PointsLabel = new Label("Player 2 Points:");
		P2PointsLabel.setStyle("-fx-font-family: SansSerif;");
		
		P2GuessLabel = new Label("Player 2 Guess:");
		P2GuessLabel.setStyle("-fx-font-family: SansSerif;");
		
		// Beautifying elements initializing.
		// Add Padding!!!!!
		Box1Section2 = new HBox(P1PointsLabel, P1PointsField);
		Box2Section2 = new HBox(P2PointsLabel, P2PointsField);
		Box3Section2 = new HBox(P2GuessLabel, P2GuessField);
		
		Box_TwoandThree = new VBox(Box2Section2, Box3Section2);
		MainBoxSection2 = new HBox(Box1Section2, Box_TwoandThree);
		
		
		// Initializing the Images.
		ImageZero = new Image("/Images/Zerofing.png", true);
		ImageOne = new Image("/Images/Onefing.png", true);
		ImageTwo = new Image("/Images/Twofing.png", true);
		ImageThree = new Image("/Images/Threefing.png", true);
		ImageFour = new Image("/Images/Fourfing.png", true);
		ImageFive = new Image("/Images/Fivefing.png", true);
		
		IVZero = new ImageView(ImageZero);
		IVOne = new ImageView(ImageOne);
		IVTwo = new ImageView(ImageTwo);
		IVThree = new ImageView(ImageThree);
		IVFour = new ImageView(ImageFour);
		IVFive = new ImageView(ImageFive);
		
		LBZero = new Label("Zero (0)");
		LBZero.setStyle("-fx-font-family: SansSerif;");
		
		LBOne = new Label("One (1)");
		LBOne.setStyle("-fx-font-family: SansSerif;");
		
		LBTwo = new Label("Two (2)");
		LBTwo.setStyle("-fx-font-family: SansSerif;");
		
		LBThree = new Label("Three (3)");
		LBThree.setStyle("-fx-font-family: SansSerif;");
		
		LBFour = new Label("Four (4)");
		LBFour.setStyle("-fx-font-family: SansSerif;");
		
		LBFive = new Label("Five (5)");
		LBFive.setStyle("-fx-font-family: SansSerif;");
		
		LBIM0 = new VBox(IVZero, LBZero);
		LBIM1 = new VBox(IVOne, LBOne);
		LBIM2 = new VBox(IVTwo, LBTwo);
		LBIM3 = new VBox(IVThree, LBThree);
		LBIM4 = new VBox(IVFour, LBFour);
		LBIM5 = new VBox(IVFive, LBFive);
		
		
		ImageBox = new HBox(LBIM0, LBIM1, LBIM2, LBIM3, LBIM4, LBIM5);

		// Initializing the guesses section;
		RB0 = new RadioButton("0");
		RB0.setStyle("-fx-font-family: SansSerif;");
		
		RB1 = new RadioButton("1");
		RB1.setStyle("-fx-font-family: SansSerif;");
		
		RB2 = new RadioButton("2");
		RB2.setStyle("-fx-font-family: SansSerif;");
		
		RB3 = new RadioButton("3");
		RB3.setStyle("-fx-font-family: SansSerif;");
		
		RB4 = new RadioButton("4");
		RB4.setStyle("-fx-font-family: SansSerif;");
		
		RB5 = new RadioButton("5");
		RB5.setStyle("-fx-font-family: SansSerif;");
		
		RB6 = new RadioButton("6");
		RB6.setStyle("-fx-font-family: SansSerif;");
		
		RB7 = new RadioButton("7");
		RB7.setStyle("-fx-font-family: SansSerif;");
		
		RB8 = new RadioButton("8");
		RB8.setStyle("-fx-font-family: SansSerif;");
		
		RB9 = new RadioButton("9");
		RB9.setStyle("-fx-font-family: SansSerif;");
		
		RB10 = new RadioButton("10");
		RB10.setStyle("-fx-font-family: SansSerif;");
		this.setRadioButtonAbility(true);
		
		RadioButtonBox = new HBox(RB0,RB1, RB2, RB3, RB4, RB5, RB6, RB7, RB8, RB9, RB10);
		
		// Text Initiailizing.
		SelctnumText = new Text("Number of Fingures");
		SelctnumText.setStyle("-fx-font-family: SansSerif;");
		
		SelectGuessText = new Text("Make your Guess");
		SelectGuessText.setStyle("-fx-font-family: SansSerif;");
		
		// Initializing the VBox.
		MainBox = new VBox(ServerMessage, MainBoxSection2, SelctnumText, ImageBox, SelectGuessText, RadioButtonBox);
		MainBox.setSpacing(20);
		MainBox.setAlignment(Pos.TOP_CENTER);
	}
	
	public Scene GetGamePlayScene() {
		MainScene = new Scene(MainBox, 600, 600);
		return MainScene;
	}
	
	public void setRadioButtonAbility(boolean x) {
		RB0.setDisable(x);
		RB1.setDisable(x);
		RB2.setDisable(x);
		RB3.setDisable(x);
		RB4.setDisable(x);
		RB5.setDisable(x);
		RB6.setDisable(x);
		RB7.setDisable(x);
		RB8.setDisable(x);
		RB9.setDisable(x);
		RB10.setDisable(x);
	}
	
}
