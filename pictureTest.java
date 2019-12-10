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

		Scene creditsScene = new Scene(creditsPane, 400, 400);
		
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
                        	arc.setFill(Color.rgb(255, 0, 0, 0.5));
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
				
		newPlot(1, mainPane);
		newPlot(2, mainPane);
		newPlot(3, mainPane);
		newPlot(4, mainPane);
		
		newJar(1, mainPane);
		newJar(2, mainPane);
		newJar(3, mainPane);
		newJar(4, mainPane);
						
		bt1.setOnAction(e -> {stage.setScene(shopScene); } );
		backButton.setOnAction(e -> {stage.setScene(mainScene); } );
		guestBt.setOnAction(e -> {stage.setScene(mainScene); } );
		creditsBt.setOnAction(e -> {stage.setScene(creditsScene); } );
		creditsBackBt.setOnAction(e -> {stage.setScene(menuScene); } );
		
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
	
	public void newPlot(int slot, Pane pane) throws FileNotFoundException {
		
		Image image1 = new Image(new FileInputStream("plot1.png"));
			
		if (slot == 1) {
			
			Plot plot = new Plot(pane, image1, 50, 150);
			plots.add(plot);
		}
		else if (slot == 2) {
			
			Plot plot = new Plot(pane, image1, 180, 150);
			plots.add(plot);
		}
		else if (slot == 3) {
			
			Plot plot = new Plot(pane, image1, 50, 280);
			plots.add(plot);
		}
		else if (slot == 4) {
			
			Plot plot = new Plot(pane, image1, 180, 280);
			plots.add(plot);
		}
	}
		
	public void newJar(int slot, Pane pane) throws FileNotFoundException {
		
		Image image1 = new Image(new FileInputStream("jar.jpg"));
			
		if (slot == 1) {
			
			Jar jar = new Jar(pane, image1, 450, 150);
			jars.add(jar);
		}
		
		else if (slot == 2) {
			
			Jar jar = new Jar(pane, image1, 570, 150);
			jars.add(jar);
		}
		
		else if (slot == 3) {
			
			Jar jar = new Jar(pane, image1, 450, 280);
			jars.add(jar);
		}
		
		else if (slot == 4) {
			
			Jar jar = new Jar(pane, image1, 570, 280);
			jars.add(jar);
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
