package finalProject;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Plot  extends Equipment  {
	
	boolean canPlant = true;
	boolean canHarvest = false;
	int count = 0;
	
	
	public Plot (Pane layer, Image image, double x, double y) {
		
		super(layer, image, x, y);
		
		this.imageView.setFitHeight(100);
		this.imageView.setFitWidth(100);
		
	}
	
	
	public void plant() throws FileNotFoundException {
		
		Image image2 = new Image(new FileInputStream("plot2.png"));
		Image image3 = new Image(new FileInputStream("plot3.png"));
		Image image4 = new Image(new FileInputStream("plot4.png"));
		
		System.out.println("Tried to plant");
		
		if (canPlant) {
		
			
			canPlant = false;
			
			//start grow cycle
			count = 0;
			
			EventHandler<ActionEvent> eventHandler = e -> {
				
				if (count == 0) {
					
					this.imageView.setImage(image3);
				}
				else if (count == 1) {
					
					this.imageView.setImage(image4);
					canHarvest= true;
				}
				
				count ++;
			};
			
			this.imageView.setImage(image2);
			Timeline animation = new Timeline(new KeyFrame(Duration.seconds(15), eventHandler));
			animation.setCycleCount(3);
			animation.play();
			
			
			
		}
		
		else {
			
			System.out.println("You can't plant here");
		}
		
	}
	
	public void harvest() throws FileNotFoundException {
		
		Image image1 = new Image(new FileInputStream("plot1.png"));
		Image image4 = new Image(new FileInputStream("plot4.png"));
		
		
		System.out.println("Tried to harvest");
		
		if (canHarvest) {
			Mechanics.add();
			canHarvest = false;
			canPlant = true;
			this.imageView.setImage(image1);
			
			
		}
		
		else {
			
			System.out.println("You can't harvest yet");
		}
		
	}
	
	
	
	public void clicked(Counter one, Counter two, Counter three, Counter four) throws FileNotFoundException {
	
		
		if (canPlant) {
			plant();
			one.changeAmount(-10);
			two.changeAmount(-10);
		}
		
		else if(canHarvest) {
			harvest();
			three.changeAmount(100);
			four.changeAmount(100);
		}
		
	}
	

}
