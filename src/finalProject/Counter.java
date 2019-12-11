package finalProject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
		
		this.text = new Text(x + 30, y, getStringAmount());
		this.text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		
		addToLayer();
		
	}
	
	//Pass a negative number to decrease
	public void changeAmount(int num) {
		
		
		this.amount = num + this.amount;
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
