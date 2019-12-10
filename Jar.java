package finalProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class Jar extends Equipment {

	boolean canPickle = true;
	boolean canCollect = false;
	
	int count;
	int green;
	int red;
	
	public Jar (Pane layer, Image image, double x, double y) {
		
		super(layer, image, x, y);
		
		this.imageView.setFitHeight(110);
		this.imageView.setFitWidth(95);
	}
	
	public void clicked(Arc arc) throws FileNotFoundException {
		
		System.out.println("Clicked");
		
		if (canPickle) {
			
			canPickle = false;
			pickle(arc);
		}
		else if (canCollect) {
			
			canCollect = false;
			collect();
		}
	}
	
	public void pickle(Arc arc) throws FileNotFoundException {
		
		System.out.println("tried to pickle");
		
		Image image1 = new Image(new FileInputStream("pickling.jpg"));
		
		this.imageView.setImage(image1);
		
		arc.setCenterX(this.x + 47);
		arc.setCenterY(this.y + 55);
		
		count = 0;
		red = 255;
		green = 0;
		
		EventHandler<ActionEvent> eventHandler = e -> {
			
			count ++;
			
			if (count % 5 == 0) {
				
				red -= 3;
				green += 3;
			}
			
			arc.setFill(Color.rgb(red, green, 0, 0.8));
			arc.setLength(arc.getLength() - 1);
			
			if (count == 361) {
				
				arc.setCenterX(-500);
				arc.setCenterY(-500);
				
				canCollect = true;
			}
		};
		
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), eventHandler));
		animation.setCycleCount(361);
		animation.play();
	}
	
	public void collect() throws FileNotFoundException {
		
		System.out.println("Tried to collect");
	
		Image image1 = new Image(new FileInputStream("jar.jpg"));
		
		this.imageView.setImage(image1);
		
		canPickle =  true;
	}
}
