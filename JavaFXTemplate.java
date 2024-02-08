import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {

	// Needed Texts;
	private Text PortNumberIndication;
	private Text StatListIndication;
	
	// Needed Button;
	private Button ServerStarter;
	
	// Needed Elements;
	private ComboBox<Integer> DropDownList;
	
	// Beautification elements
	private VBox VerticalBox;
	private HBox List_Text;
	private VBox List_Text2;
	
	// Scene ELement;
	private Scene MainScene;
	
	// ListView For statistics.
	private ListView StatsUpdateList;
	MorraInfo morraInfo;
	boolean joinedP1;
	boolean joinedP2;
	
	// Server.
	Server TheServer;
	
	//
	//
	//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//
	//
	//
	@Override
	public void start(Stage primaryStage) throws Exception {	
		// Setting the title of Stage.
		primaryStage.setTitle("Morra");
		
		// Setting and showing the Stage,
		primaryStage.setScene(this.GetIntroScene());
		primaryStage.show();
		
		// ComboBox EventHandler
		DropDownList.setOnAction(ComboBoxEvent -> {
			ServerStarter.setDisable(false);
		});
		
		// serverStarter EVentHandler;
		ServerStarter.setOnAction( ButtonEvent -> {
			primaryStage.setScene(this.GetStatScene());
			primaryStage.show();
			TheServer = new Server( data -> {
				Platform.runLater( () -> {
					StatsUpdateList.getItems().add(data.toString());
				});
			},DropDownList.getValue());
		});
	}

	//
	//
	//
	public Scene GetIntroScene() { 
		
		// Initializing the elements required...
		PortNumberIndication = new Text("Port Number: ");
		PortNumberIndication.setStyle("-fx-font-family: SansSerif;");
		
		ServerStarter = new Button("Start Server");
		ServerStarter.setStyle("-fx-font-family: SansSerif;");
		ServerStarter.setDisable(true);
		
		DropDownList = new ComboBox();
		DropDownList.setStyle("-fx-font-family: SansSerif;");
		
		List_Text = new HBox(PortNumberIndication, DropDownList);
		List_Text.setAlignment(Pos.CENTER);
		
		VerticalBox = new VBox(List_Text, ServerStarter);
		VerticalBox.setAlignment(Pos.CENTER);
		VerticalBox.setSpacing(20);
		
		// Adding to the DropDownList.
		DropDownList.getItems().addAll(5555, 7777, 8888);
		
		// Intializing the Scene.
		MainScene = new Scene(VerticalBox, 500, 500);
		return MainScene;
	}
	
	//
	//
	//
	public Scene GetStatScene() {
		
		// Initializing the elements
		StatsUpdateList = new ListView(); 
		// Nedd somethign to increase the font size;
		StatsUpdateList.setStyle("-fx-font-family: SansSerif; -fx-font-size: medium;");
		
		
		StatListIndication = new Text("Server Updates:");
		StatListIndication.setStyle("-fx-font-family: SansSerif;");
		
		List_Text2 = new VBox(StatListIndication, StatsUpdateList);
		List_Text2.setAlignment(Pos.CENTER_LEFT);
		
		// Initializing the Scene.
		MainScene = new Scene(List_Text2, 500, 500);
		return MainScene;
	}
	
}