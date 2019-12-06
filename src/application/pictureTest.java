package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
public class pictureTest extends Application {
 public void start(Stage stage) throws FileNotFoundException {
  int p1 = 1;
  Image image1 = new Image(new FileInputStream("plot1.png"));
  Image image2 = new Image(new FileInputStream("plot2.png"));
  ImageView plot1 = plot.plot(1);
  ImageView plot2 = plot.plot(2);
  Pane mainPane = new Pane();
  mainPane.getChildren().add(plot1);
  mainPane.getChildren().add(plot2);
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
  bt1.setOnAction(e -> {
   stage.setScene(shopScene);
  });
  backButton.setOnAction(e -> {
   stage.setScene(mainScene);
  });
  stage.setScene(mainScene);
  stage.show();
 }
 public static void main(String[] args) {
  launch(args);
 }
 public static ImageView changePlot(ImageView pic, int stage) throws FileNotFoundException {
  stage++;
  Image image1 = new Image(new FileInputStream("plot" + stage + ".png"));
  pic = new ImageView(image1);
  return pic;
 }
 public static class plot {
  boolean canPlant = true;
  boolean canHarvest = false;
  public static ImageView plot(int slot) throws FileNotFoundException {
   Image image1 = new Image(new FileInputStream("plot1.png"));
   ImageView plot = new ImageView(image1);
   plot.setFitHeight(100);
   plot.setFitWidth(100);
   if (slot == 1) {
    plot.setX(50);
    plot.setY(300);
   } else if (slot == 2) {
    plot.setX(160);
    plot.setY(300);
   } else if (slot == 3) {
    plot.setX(50);
    plot.setY(410);
   } else if (slot == 4) {
    plot.setX(160);
    plot.setY(410);
   }
   return plot;
  }
  public void plant() {
   System.out.println("Tried to plant");
   if (canPlant) {
    canPlant = false;
   } else {
    System.out.println("You can't plant here");
   }
  }
  public void harvest() {
   System.out.println("Tried to harvest");
   if (canHarvest) {
    canHarvest = false;
    canPlant = true;
   } else {
    System.out.println("You can't harvest yet");
   }
  }
 }
}