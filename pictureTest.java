// Ryan Ramsay 1739028

package finalProject;

import java.awt.List;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class pictureTest extends Application{
	
	ArrayList <Plot> plots = new ArrayList<Plot>();
	
	ObservableList<Plot> plotsss = FXCollections.observableList(plots);
	
	

	public void start(Stage stage) throws FileNotFoundException {

		int p1 = 1;
	
		Image image1 = new Image(new FileInputStream("plot1.png"));
		Image image2 = new Image(new FileInputStream("plot2.png"));
		
		
		
		Pane mainPane = new Pane();
		

		Button bt1 = new Button("Shop");
			
		Pane buttonPane = new Pane();
		buttonPane.getChildren().add(bt1);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(mainPane);
		pane.setBottom(buttonPane);
		
		Scene mainScene = new Scene(pane, 600, 600);
		
		
		Button backButton = new Button("Back");
		backButton.setLayoutX(540);
		
		Pane shopButtonPane = new Pane();
		shopButtonPane.getChildren().add(backButton);
		
		BorderPane shopPane = new BorderPane();
				
		shopPane.setBottom(shopButtonPane);
		
		Scene shopScene = new Scene(shopPane, 600, 600);
		
		
		
		

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
				
				
			}
			
		};
		
		mainScene.addEventFilter(MouseEvent.MOUSE_CLICKED,  eventHandler);
		
		
		newPlot(1, mainPane);
		newPlot(2, mainPane);
		
		bt1.setOnAction(e -> {stage.setScene(shopScene); } );
		backButton.setOnAction(e -> {stage.setScene(mainScene); } );
		
		stage.setScene(mainScene);
		
		stage.show();
		
		
		
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
			
			Plot plot = new Plot(pane, image1, 50, 300);
			plots.add(plot);
		}
		
		else if (slot == 2) {
			
			Plot plot = new Plot(pane, image1, 160, 300);
			plots.add(plot);
		}
		
		else if (slot == 3) {
			
			Plot plot = new Plot(pane, image1, 50, 410);
			plots.add(plot);
		}
		
		else if (slot == 4) {
			
			Plot plot = new Plot(pane, image1, 160, 410);
			plots.add(plot);
		}

		
	}
	
	
}
