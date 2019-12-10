package finalProject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Equipment {

	
	Image image;
	ImageView imageView;
	
	Pane layer;
	
	double x;
	double y;
	
	
	public Equipment(Pane layer, Image image, double x, double y) {
		
		this.layer = layer;
		this.image = image;
		this.x = x;
		this.y = y;
		
		this.imageView = new ImageView(image);
		this.imageView.relocate(x,  y);;
		
		addToLayer();
		
	}
	
	public void addToLayer() {
		
		this.layer.getChildren().add(this.imageView);
	}
	
	public void removeFromLayer() {
		
		this.layer.getChildren().add(this.imageView);
	}
	
	public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public boolean contains(double x, double y) {
    	
    	if (x >= this.x && x <= this.x + 100 && y >= this.y && y <= this.y + 100) {
    		
    		return true;
    	}
    	else
    		return false;
    	
    }
	
	
	
	
}
