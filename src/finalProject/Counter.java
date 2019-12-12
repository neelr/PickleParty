package finalProject;

import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Counter {
	
	int amount;
	double x;
	double y;
	Pane layer;
	ImageView imageView;
	Text text;
	
	public Counter(Pane layer, Image image, double x, double y) {
		
		this.layer = layer;
		
		this.x = x;
		this.y = y;
		
		this.imageView = new ImageView(image);
		this.imageView.relocate(x,  y);
		this.imageView.setFitHeight(28);
		this.imageView.setFitWidth(28);
		
		this.text = new Text(x + 35, y + 20, getStringAmount());
		this.text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		
		addToLayer();		
	}
	
	//Pass a negative number to decrease
	public void changeAmount(int num) {
		
		this.amount = num + this.amount;
		this.text.setText(getStringAmount());
		System.out.println(amount);
		
		Text animationText = new Text(x + 35, y + 32, "");
				
		if (num < 0) {
			
			animationText.setFill(Color.RED);
			animationText.setText(Integer.toString(num));
		}
		else {
			
			animationText.setFill(Color.GREEN);
			animationText.setText("+" + Integer.toString(num));
		}
		animationText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		this.layer.getChildren().add(animationText);
		
		
		EventHandler<ActionEvent> eventHandler = e -> {
			
			animationText.setY(animationText.getY() + 0.5);
			if (animationText.getY() >= this.y + 61) {
				
				animationText.setY(-100);
			}
		};
		
	
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(17), eventHandler));
		animation.setCycleCount(60);
		animation.play();		
	}
	
	public int getAmount() {
		
		return this.amount;
	}

	
	public String getStringAmount() {
		
		return Integer.toString(amount);
	}
	
	public void addToLayer() {
		
		this.layer.getChildren().addAll(this.imageView, this.text);
		
	}
	
}


