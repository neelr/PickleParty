// Ryan Ramsay 1739028

package finalProject;

import java.applet.Applet;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.applet.AudioClip;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class pictureTest extends Application{
	
	static ArrayList <Plot> plots = new ArrayList<Plot>();
	static ObservableList<Plot> plotsss = FXCollections.observableList(plots);
	
	static ArrayList <Jar> jars = new ArrayList<Jar>();
	static ObservableList<Jar> jarsss = FXCollections.observableList(jars);
	
	
		
	public void start(Stage stage) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
			
		Pane mainPane = new Pane();
		
		Button bt1 = new Button("Shop");
		Button buyPlot = new Button("Buy Plot");
		Button butJar = new Button("Buy Jar");
		Button butSell = new Button("Sell!");
		Pane buttonPane = new Pane();
		buttonPane.getChildren().add(bt1);
		VBox buttonStorePane = new VBox(10);
		buttonStorePane.setAlignment(Pos.CENTER);
		buttonStorePane.getChildren().addAll(buyPlot,butJar,butSell);
		BorderPane pane = new BorderPane();
		pane.setCenter(mainPane);
		pane.setBottom(buttonPane);
		
		Scene mainScene = new Scene(pane, 800, 500);
				
		Button backButton = new Button("Back");
		backButton.setAlignment(Pos.BOTTOM_LEFT);		
		Pane shopButtonPane = new Pane();
		shopButtonPane.getChildren().add(backButton);
		
		BorderPane shopPane = new BorderPane();	
		shopPane.setBottom(shopButtonPane);
		shopPane.setCenter(buttonStorePane);
		Scene shopScene = new Scene(shopPane, 800, 500);
		
		Button guestBt = new Button("Play as guest");
		Button signInBt = new Button("Sign in");
		Button newAccountBt = new Button("Create a new account");
		
		VBox menuButtonPane = new VBox(10);
		menuButtonPane.setAlignment(Pos.CENTER);
		menuButtonPane.getChildren().addAll(signInBt, guestBt, newAccountBt);
		
		Button creditsBt = new Button("Credits");
		Pane menuBottomPane = new Pane();
		menuBottomPane.getChildren().add(creditsBt);
		
		BorderPane menuPane = new BorderPane();
		menuPane.setCenter(menuButtonPane);
		menuPane.setBottom(menuBottomPane);
		
		Scene menuScene = new Scene(menuPane, 400, 500);
		
		Text creditsText = new Text(50, 200, "Ryan Ramsay:   Did the JavaFX programming\nand more! \n\nNeel Redcar:  ....did something...maybe?");
		creditsText.setFont(Font.font("Times New Roman", 17));
		Text creditsTitleText = new Text(130, 100, "Credits");
		creditsTitleText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
		Pane creditsTextPane = new Pane();
		creditsTextPane.getChildren().addAll(creditsText, creditsTitleText);
		
		Button creditsBackBt = new Button("Back");
		Pane creditsBtPane = new Pane();
		creditsBtPane.getChildren().add(creditsBackBt);
		
		BorderPane creditsPane = new BorderPane();	
		creditsPane.setCenter(creditsTextPane);
		creditsPane.setBottom(creditsBtPane);

		Scene creditsScene = new Scene(creditsPane, 400, 500);
		
		
		VBox signInCenter = new VBox(10);
		signInCenter.setAlignment(Pos.CENTER);
		Button signIn = new Button("Sign In");
		TextField b = new TextField(); 
		b.setMaxWidth(100);
		signInCenter.getChildren().addAll(b,signIn);
		BorderPane signInPane = new BorderPane();
		signInPane.setCenter(signInCenter);
		
		Scene signInScene = new Scene(signInPane, 400, 500);
		
		Pane newAccountPane = new Pane();
		
		Scene newAccountScene = new Scene(newAccountPane, 400, 500);
		
		Image image1 = new Image(new FileInputStream("coin.jpg"));
		Image image2 = new Image(new FileInputStream("cucumber.jpg"));
		Image image3 = new Image(new FileInputStream("pickle.png"));
		
		Counter coins = new Counter(mainPane, image1, 10, 20);
		Counter cucumbers = new Counter(mainPane, image2, 140, 20);
		Counter pickles = new Counter(mainPane, image3, 270, 20);		
		
		Counter coins2 = new Counter(shopPane, image1, 10, 20);
		Counter cucumbers2 = new Counter(shopPane, image2, 140, 20);
		Counter pickles2 = new Counter(shopPane, image3, 270, 20);
	
		
		
		
		
		EventHandler <MouseEvent> eventHandler = new EventHandler <MouseEvent> () {
			@Override
			public void handle(MouseEvent e)  {

				for (int i = 0; i < plots.size(); i++) {
					if (plots.get(i).contains(e.getX(), e.getY())) {
                        try {
							plots.get(i).clicked(coins, coins2, cucumbers, cucumbers2);
							
							
						} catch (FileNotFoundException e1) {
							
							e1.printStackTrace();
						}
                    }
				}
				
				for (int i = 0; i < jars.size(); i++) {
					if (jars.get(i).contains(e.getX(), e.getY())) {
                        try {
                        	Arc arc = new Arc(50, 50, 40, 40, 0, 0);
                        	arc.setType(ArcType.ROUND);
                        	arc.setFill(Color.rgb(255, 0, 0, 0.5));
                        	mainPane.getChildren().add(arc);
                        	jars.get(i).clicked(arc, cucumbers, cucumbers2, pickles, pickles2);
						} catch (FileNotFoundException e1) {
							
							e1.printStackTrace();
						}
                    }
				}
			}
		};
		
		mainScene.addEventFilter(MouseEvent.MOUSE_CLICKED,  eventHandler);
		
		
		
		
		
				

		
		
		bt1.setOnAction(e -> {stage.setScene(shopScene); } );
		backButton.setOnAction(e -> {stage.setScene(mainScene); } );
		guestBt.setOnAction(e -> {stage.setScene(mainScene);
		coins.changeAmount(100);
		coins2.changeAmount(100);
		try {
			newPlot(Mechanics.plots, mainPane);
			newJar(Mechanics.jars, mainPane);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}} );
		creditsBt.setOnAction(e -> {stage.setScene(creditsScene); } );
		creditsBackBt.setOnAction(e -> {stage.setScene(menuScene); } );
		signInBt.setOnAction(e -> {stage.setScene(signInScene); } );
		newAccountBt.setOnAction(e -> {stage.setScene(newAccountScene); } );
		butJar.setOnAction(e -> {
			if (Mechanics.money >= 100) {
				Mechanics.addJar();
				try {
					newJar(Mechanics.jars, mainPane);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				coins.changeAmount(-100);
				coins2.changeAmount(-100);
				Mechanics.money(-100);
			}
		});
		buyPlot.setOnAction(e -> {
			if (Mechanics.money >= 100) {
				Mechanics.addPlot();
				try {
					newPlot(Mechanics.plots, mainPane);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				coins.changeAmount(-100);
				coins2.changeAmount(-100);
				Mechanics.money(-100);
			}
		});
		butSell.setOnAction(e -> {
			System.out.print("HERE: "+Mechanics.pickles);
			if (Mechanics.pickles >= 50) {
				Mechanics.sell(-50);
				coins.changeAmount(50);
				coins2.changeAmount(50);
				pickles.changeAmount(-50);
				pickles2.changeAmount(-50);
				Mechanics.money(100);
			}
		});
		signIn.setOnAction(e -> {
			UserStorage person = new UserStorage(b.getText());
			person.load(b.getText());
			Mechanics.setUser(person);
			try {
				newPlot(Mechanics.plots, mainPane);
				newJar(Mechanics.jars, mainPane);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			coins.changeAmount(Mechanics.money);
			coins2.changeAmount(Mechanics.money);
			pickles.changeAmount(Mechanics.pickles);
			pickles2.changeAmount(Mechanics.pickles);
			cucumbers.changeAmount(Mechanics.cucumber);
			cucumbers2.changeAmount(Mechanics.cucumber);
			stage.setScene(mainScene);
		});
		stage.setScene(menuScene);
		
		stage.show();
					
		//playMusic();
		
		EventHandler<ActionEvent> musicEventHandler = e -> {
			
			try {
				playMusic();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				e1.printStackTrace();
			}
		};

		Timeline animation = new Timeline(new KeyFrame(Duration.seconds(44), musicEventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}	
	
	public static void main(String[] args)  {
		
	
		launch(args);
		
	}
		
	public static ImageView changePlot(ImageView pic, int stage) throws FileNotFoundException {
		
		stage ++;
		
		Image image1 = new Image(new FileInputStream("plot" + stage + ".png"));
		
		pic = new ImageView(image1);		
		
		return pic;	
	}	
	
	public void newPlot(int num, Pane pane) throws FileNotFoundException {
		
		Image image1 = new Image(new FileInputStream("plot1.png"));
		int x = 50;
		int y = 150;
		boolean switcher = false;
		for (int i = 0; i < num; i++) {
			Plot plot = new Plot(pane, image1, x, y);
			plots.add(plot);
			if (x == 50) {
				x = 180;
			} else {
				x = 50;
			}
			if (switcher) {
				y+=130;
				switcher = false;
			} else {
				switcher = true;
			}
		}
	}
	
	
	public void newJar(int num, Pane pane) throws FileNotFoundException {
		
		Image image1 = new Image(new FileInputStream("jar.jpg"));
	
		int x = 450;
		int y = 150;
		boolean switcher = false;
		for (int i = 0; i < num; i++) {
			Jar jar = new Jar(pane, image1, x, y);
			jars.add(jar);
			if (x == 450) {
				x = 570;
			} else {
				x = 450;
			}
			if (switcher) {
				y+=130;
				switcher = false;
			} else {
				switcher = true;
			}
		}
	}
	
	
	public static void playMusic() throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		File file = new File("pickleSong_aud.wav");
        URL url = null;
        if (file.canRead()) {url = file.toURI().toURL();}
        System.out.println(url);
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
        System.out.println("should've played by now");
	}
}
