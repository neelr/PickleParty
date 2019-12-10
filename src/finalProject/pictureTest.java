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
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class pictureTest extends Application{
	
	ArrayList <Plot> plots = new ArrayList<Plot>();
	ObservableList<Plot> plotsss = FXCollections.observableList(plots);
	
	ArrayList <Jar> jars = new ArrayList<Jar>();
	ObservableList<Jar> jarsss = FXCollections.observableList(jars);
	
	

	public void start(Stage stage) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
			
		Pane mainPane = new Pane();
		
		Button bt1 = new Button("Shop");
			
		Pane buttonPane = new Pane();
		buttonPane.getChildren().add(bt1);
		
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
		
		Scene shopScene = new Scene(shopPane, 800, 500);
		
		Button guestBt = new Button("Play as guest");
		Button signInBt = new Button("Sign in");
		Button newAccountBt = new Button("Create a new account");
		Button creditsBt = new Button("Credits");
		
		
		VBox menuButtonPane = new VBox(10);
		menuButtonPane.setAlignment(Pos.CENTER);
		
		menuButtonPane.getChildren().addAll(signInBt, guestBt, newAccountBt, creditsBt);
		
		BorderPane menuPane = new BorderPane();
		menuPane.setCenter(menuButtonPane);
		
		Scene menuScene = new Scene(menuPane, 400, 500);
		
		

		EventHandler <MouseEvent> eventHandler = new EventHandler <MouseEvent> () {
			@Override
			public void handle(MouseEvent e)  {

				for (int i = 0; i < plotsss.size(); i++) {
					if (plotsss.get(i).contains(e.getX(), e.getY())) {
                        try {
							plotsss.get(i).clicked();
						} catch (FileNotFoundException e1) {
							
							e1.printStackTrace();
						}
                    }
				}
				
				for (int i = 0; i < jarsss.size(); i++) {
					if (jarsss.get(i).contains(e.getX(), e.getY())) {
                        try {
                        	Arc arc = new Arc(50, 50, 40, 40, 0, 0);
                        	arc.setType(ArcType.ROUND);
                        	mainPane.getChildren().add(arc);
                        	jarsss.get(i).clicked(arc);
						} catch (FileNotFoundException e1) {
							
							e1.printStackTrace();
						}
                    }
				}
			}
			
		};
		
		mainScene.addEventFilter(MouseEvent.MOUSE_CLICKED,  eventHandler);
		
		
		newPlot(7, mainPane);
		
		newJar(1, mainPane);
		
				
		bt1.setOnAction(e -> {stage.setScene(shopScene); } );
		backButton.setOnAction(e -> {stage.setScene(mainScene); } );
		guestBt.setOnAction(e -> {stage.setScene(mainScene); } );
		
		stage.setScene(menuScene);
		
		stage.show();
		
			
		playMusic();
		
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
